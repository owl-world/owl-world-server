package com.owls.owlworld.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.owls.owlworld.like.Likeable;
import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.post.PostDto;
import java.time.LocalDateTime;

public class CommentDto implements Likeable {

    private Long id;

    private String content;

    private MemberDto memberDto;

    private PostDto postDto;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime createdAt;

    public CommentDto(Long id, String content, MemberDto memberDto, PostDto postDto, LocalDateTime createdAt) {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
