package com.owls.owlworld.answer;

import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.question.QuestionDto;
import java.time.LocalDateTime;

public class AnswerDto {

    private Long id;

    private String content;
    private int likeCount;

    private QuestionDto question;

    private MemberDto member;

    private boolean isAccepted;

    private LocalDateTime createdAt;

    public AnswerDto(Long id, String content, int likeCount, QuestionDto question, MemberDto member, boolean isAccepted, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.likeCount = likeCount;
        this.question = question;
        this.member = member;
        this.isAccepted = isAccepted;
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

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public QuestionDto getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDto question) {
        this.question = question;
    }

    public MemberDto getMember() {
        return member;
    }

    public void setMember(MemberDto member) {
        this.member = member;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
