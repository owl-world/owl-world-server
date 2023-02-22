package com.owls.owlworld.comment;

import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.member.MemberService;
import com.owls.owlworld.post.PostDto;
import com.owls.owlworld.post.PostEntity;
import com.owls.owlworld.post.PostRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final MemberService memberService;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository, MemberService memberService) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.memberService = memberService;
    }

    public List<CommentDto> getComments(Long postId) {
        List<CommentEntity> commentEntities = commentRepository.findAllByPostIdOrderByCreatedAtDesc(postId);

        return commentEntities.stream()
            .map(commentEntity -> {
                MemberDto memberDto = memberService.findById(commentEntity.getMemberId());
                return commentEntity.toDto(memberDto, null);
            }).collect(Collectors.toList());
    }

    public int getCommentCount(Long postId) {
        return commentRepository.countByPostId(postId);
    }

    public CommentDto addComment(AddCommentRequest addCommentRequest, Long memberId) {

        PostEntity postEntity = postRepository
            .findById(addCommentRequest.getPostId())
            .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0006));

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setContent(addCommentRequest.getContent());
        commentEntity.setPostId(addCommentRequest.getPostId());
        commentEntity.setMemberId(memberId);

        MemberDto memberDto = memberService.findById(memberId);
        PostDto postDto = postEntity.toDto(memberDto, null, 0, 0, false);
        return commentRepository.save(commentEntity).toDto(memberDto, postDto);
    }
}
