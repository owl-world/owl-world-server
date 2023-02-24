package com.owls.owlworld.like;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.owls.owlworld.member.MemberDto;
import java.time.LocalDateTime;

public class LikeDto {

    private Long id;

    private Likeable target;

    private String targetType;

    private MemberDto memberDto;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime createdAt;

    public LikeDto(Long id, Likeable target, String targetType, MemberDto memberDto, LocalDateTime createdAt) {
        this.id = id;
        this.target = target;
        this.targetType = targetType;
        this.memberDto = memberDto;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Likeable getTarget() {
        return target;
    }

    public void setTarget(Likeable target) {
        this.target = target;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
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
