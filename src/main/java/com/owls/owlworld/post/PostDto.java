package com.owls.owlworld.post;

import com.owls.owlworld.comment.CommentDto;
import com.owls.owlworld.member.MemberDto;
import java.time.LocalDateTime;
import java.util.List;

public class PostDto {

    private Long id;

    private String title;

    private String content;

    private List<CommentDto> comments;
    private MemberDto memberDto;

    private LocalDateTime createdAt;

    public PostDto(Long id, String title, String content, List<CommentDto> comments, MemberDto memberDto, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.comments = comments;
        this.memberDto = memberDto;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
