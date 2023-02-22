package com.owls.owlworld.post;

import com.owls.owlworld.comment.CommentDto;
import com.owls.owlworld.comment.CommentService;
import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.member.MemberService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final MemberService memberService;
    private final CommentService commentService;

    public PostService(PostRepository postRepository, MemberService memberService, CommentService commentService) {
        this.postRepository = postRepository;
        this.memberService = memberService;
        this.commentService = commentService;
    }

    public GetAllPostResponse getPosts(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<PostEntity> result = postRepository.findAll(pageRequest);

        List<PostEntity> content = result.getContent();

        return new GetAllPostResponse(
            result.getTotalPages(),
            result.getTotalElements(),
            content.stream()
                .map(postEntity -> {
                    MemberDto memberDto = new MemberDto(postEntity.getMemberId());
                    int commentCount = commentService.getCommentCount(postEntity.getId());
                    return postEntity.toDto(memberDto, null, commentCount);
                }).collect(Collectors.toList()));
    }

    public PostDto getPost(Long postId) {
        PostEntity postEntity = postRepository.findById(postId)
            .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0006));
        MemberDto memberDto = memberService.findById(postEntity.getMemberId());
        List<CommentDto> comments = commentService.getComments(postId);
        return postEntity.toDto(memberDto, comments, comments.size());
    }

    public PostDto createPost(AddPostRequest addPostRequest, Long memberId) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(addPostRequest.getTitle());
        postEntity.setContent(addPostRequest.getContent());
        postEntity.setMemberId(memberId);

        MemberDto memberDto = memberService.findById(memberId);
        return postRepository.save(postEntity).toDto(memberDto, null, 0);
    }
}
