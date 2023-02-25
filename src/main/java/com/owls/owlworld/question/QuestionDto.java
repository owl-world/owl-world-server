package com.owls.owlworld.question;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.owls.owlworld.answer.AnswerDto;
import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.university.UniversityDto;
import java.time.LocalDateTime;
import java.util.List;

public class QuestionDto {

    private Long id;
    private String content;
    private int answerCount;
    private List<AnswerDto> answers;
    private MemberDto member;

    private UniversityDto universityDto;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime createdAt;

    public QuestionDto(Long id, String content, int answerCount, List<AnswerDto> answers, MemberDto member, UniversityDto universityDto, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.answerCount = answerCount;
        this.answers = answers;
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

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
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
