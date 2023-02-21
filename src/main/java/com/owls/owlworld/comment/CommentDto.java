package com.owls.owlworld.comment;

import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.post.PostDto;

public class CommentDto {

    private Long id;

    private String content;

    private MemberDto memberDto;

    private PostDto postDto;

    private String createdAt;

    public CommentDto(Long id, String content, MemberDto memberDto, PostDto postDto, String createdAt) {
        this.id = id;
        this.content = content;
        this.memberDto = memberDto;
        this.postDto = postDto;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MemberDto getMemberDto() {
        return memberDto;
    }

    public void setMemberDto(MemberDto memberDto) {
        this.memberDto = memberDto;
    }

    public PostDto getPostDto() {
        return postDto;
    }

    public void setPostDto(PostDto postDto) {
        this.postDto = postDto;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
