package com.owls.owlworld.post;

import com.owls.owlworld.member.MemberDto;
import java.time.LocalDateTime;

public class PostDto {

    private Long id;

    private String title;

    private String content;

    private MemberDto memberDto;

    private LocalDateTime createdAt;

    public PostDto(Long id, String title, String content, MemberDto memberDto, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
