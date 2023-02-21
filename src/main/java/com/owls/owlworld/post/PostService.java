package com.owls.owlworld.post;

import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.member.MemberService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final MemberService memberService;

    public PostService(PostRepository postRepository, MemberService memberService) {
        this.postRepository = postRepository;
        this.memberService = memberService;
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
                    return postEntity.toDto(memberDto);
                }).collect(Collectors.toList()));
    }

    public PostDto createPost(AddPostRequest addPostRequest, Long memberId) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(addPostRequest.getTitle());
        postEntity.setContent(addPostRequest.getContent());
        postEntity.setMemberId(memberId);

        MemberDto memberDto = memberService.findById(memberId);
        return postRepository.save(postEntity).toDto(memberDto);
    }


}
