package com.owls.owlworld.like;

import com.owls.owlworld.comment.CommentRepository;
import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.member.MemberService;
import com.owls.owlworld.post.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final MemberService memberService;

    public LikeService(LikeRepository likeRepository, PostRepository postRepository, CommentRepository commentRepository, MemberService memberService) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.memberService = memberService;
    }

    public LikeDto addLike(AddLikeRequest addLikeRequest, Long memberId) {

        MemberDto memberDto = memberService.findById(memberId);

        Likeable likeable;
        if (addLikeRequest.getTargetType().equals("post")) {
            likeable = postRepository.findById(addLikeRequest.getTargetId())
                .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0006))
                .toDto(memberDto, null, 0);
        } else if (addLikeRequest.getTargetType().equals("comment")) {
            likeable = commentRepository.findById(addLikeRequest.getTargetId())
                .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0006))
                .toDto(memberDto, null);
        } else {
            throw new BusinessErrorException(ErrorCode.ERROR_0008);
        }

        LikeEntity likeEntity = new LikeEntity();
        likeEntity.setTargetId(addLikeRequest.getTargetId());
        likeEntity.setTargetType(addLikeRequest.getTargetType());
        likeEntity.setMemberId(memberId);

        return likeRepository.save(likeEntity).toDto(likeable, memberDto);
    }
}
