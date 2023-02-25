package com.owls.owlworld.post;

import com.owls.owlworld.comment.CommentDto;
import com.owls.owlworld.comment.CommentService;
import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import com.owls.owlworld.like.LikeService;
import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.member.MemberService;
import com.owls.owlworld.question.QuestionEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final MemberService memberService;
    private final CommentService commentService;
    private final LikeService likeService;

    public PostService(PostRepository postRepository, MemberService memberService, CommentService commentService, LikeService likeService) {
        this.postRepository = postRepository;
        this.memberService = memberService;
        this.commentService = commentService;
        this.likeService = likeService;
    }

    public GetAllPostResponse getPosts(Integer page, Integer size, Long memberId) {
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
                    int likeCount = likeService.getLikeCount("post", postEntity.getId());
                    // 좋아요를 눌렀는지
                    boolean isLiked = likeService.isLiked("post", postEntity.getId(), memberId);
                    return postEntity.toDto(memberDto, null, commentCount, likeCount, isLiked);
                }).collect(Collectors.toList()));
    }

    public PostDto getPost(Long postId, Long memberId) {
        PostEntity postEntity = postRepository.findById(postId)
            .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0006));
        MemberDto memberDto = memberService.findById(postEntity.getMemberId());
        List<CommentDto> comments = commentService.getComments(postId);
        int likeCount = likeService.getLikeCount("post", postEntity.getId());

        // 좋아요를 눌렀는지
        boolean isLiked = likeService.isLiked("post", postEntity.getId(), memberId);

        return postEntity.toDto(memberDto, comments, comments.size(), likeCount, isLiked);
    }

    public List<PostDto> getTop3PostsInLast12Hours(Long memberId) {
        List<Long> postIds = postRepository.findTop3PostIdsInLast100Hours();
        return postIds.stream()
            .map(postId -> this.getPost(postId, memberId)).collect(Collectors.toList());
    }

    public PostDto createPost(AddPostRequest addPostRequest, Long memberId) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(addPostRequest.getTitle());
        postEntity.setContent(addPostRequest.getContent());
        postEntity.setMemberId(memberId);

        MemberDto memberDto = memberService.findById(memberId);
        return postRepository.save(postEntity).toDto(memberDto, null, 0, 0, false);
    }

    public GetAllPostResponse getPostsByKeyword(int page, int size, String keyword, Long memberId) {
        Pageable pageRequest = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<PostEntity> result = postRepository.findByContentContainingOrTitleContaining(keyword, keyword, pageRequest);

        List<PostEntity> content = result.getContent();

        return new GetAllPostResponse(
            result.getTotalPages(),
            result.getTotalElements(),
            content.stream()
                .map(postEntity -> {
                    MemberDto memberDto = memberService.findById(postEntity.getMemberId());
                    int commentCount = commentService.getCommentCount(postEntity.getId());
                    int likeCount = likeService.getLikeCount("post", postEntity.getId());
                    // 좋아요를 눌렀는지
                    boolean isLiked = likeService.isLiked("post", postEntity.getId(), memberId);
                    return postEntity.toDto(memberDto, null, commentCount, likeCount, isLiked);
                }).collect(Collectors.toList()));
    }
}
