package com.owls.owlworld.like;

import com.owls.owlworld.answer.AnswerRepository;
import com.owls.owlworld.comment.CommentRepository;
import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import com.owls.owlworld.member.MemberService;
import com.owls.owlworld.post.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final AnswerRepository answerRepository;
    private final MemberService memberService;

    public LikeService(LikeRepository likeRepository, PostRepository postRepository, CommentRepository commentRepository, AnswerRepository answerRepository, MemberService memberService) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.answerRepository = answerRepository;
        this.memberService = memberService;
    }

    public int addLike(AddLikeRequest addLikeRequest, Long memberId) {

        // 게시글이 존재하는지 확인
        if (addLikeRequest.getTargetType().equals("post")) {
            if (!postRepository.existsById(addLikeRequest.getTargetId())) {
                throw new BusinessErrorException(ErrorCode.ERROR_0006);
            }
        }

        // 댓글이 존재하는지 확인
        if (addLikeRequest.getTargetType().equals("comment")) {
            if (!commentRepository.existsById(addLikeRequest.getTargetId())) {
                throw new BusinessErrorException(ErrorCode.ERROR_0007);
            }
        }

        if (addLikeRequest.getTargetType().equals("answer")) {
            if (!answerRepository.existsById(addLikeRequest.getTargetId())) {
                throw new BusinessErrorException(ErrorCode.ERROR_0012);
            }
        }

        // 멤버가 이미 좋아요를 눌렀다면 예외처리
        if (likeRepository.existsByTargetTypeAndTargetIdAndMemberId(addLikeRequest.getTargetType(), addLikeRequest.getTargetId(), memberId)) {
            throw new BusinessErrorException(ErrorCode.ERROR_0009);
        }

        LikeEntity likeEntity = new LikeEntity();
        likeEntity.setTargetId(addLikeRequest.getTargetId());
        likeEntity.setTargetType(addLikeRequest.getTargetType());
        likeEntity.setMemberId(memberId);

        LikeEntity saved = likeRepository.save(likeEntity);
        return getLikeCount(saved.getTargetType(), saved.getTargetId());
    }

    public int removeLike(RemoveLikeRequest removeLikeRequest, Long memberId) {
        LikeEntity likeEntity = likeRepository.findByTargetTypeAndTargetIdAndMemberId(removeLikeRequest.getTargetType(), removeLikeRequest.getTargetId(), memberId)
            .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0010));

        likeRepository.delete(likeEntity);
        return getLikeCount(likeEntity.getTargetType(), likeEntity.getTargetId());
    }

    public int getLikeCount(String targetType, Long targetId) {
        return likeRepository.countByTargetTypeAndTargetId(targetType, targetId);
    }

    // 좋아요를 눌렀는지 확인
    public boolean isLiked(String targetType, Long targetId, Long memberId) {
        return likeRepository.existsByTargetTypeAndTargetIdAndMemberId(targetType, targetId, memberId);
    }
}
