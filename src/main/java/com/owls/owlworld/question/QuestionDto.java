package com.owls.owlworld.question;

import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.university.UniversityDto;
import java.time.LocalDateTime;

public class QuestionDto {

    private Long id;
    private String title;
    private String content;
    private int answerCount;
    private MemberDto member;

    private UniversityDto universityDto;
    private LocalDateTime createdAt;

    public QuestionDto(Long id, String title, String content, int answerCount, MemberDto member, UniversityDto universityDto, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answerCount = answerCount;
        this.member = member;
        this.universityDto = universityDto;
        this.createdAt = createdAt;
    }

    public QuestionDto() {
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

    public MemberDto getMember() {
        return member;
    }

    public void setMember(MemberDto member) {
        this.member = member;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public UniversityDto getUniversityDto() {
        return universityDto;
    }

    public void setUniversityDto(UniversityDto universityDto) {
        this.universityDto = universityDto;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
