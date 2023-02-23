package com.owls.owlworld.answer;

import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.question.QuestionDto;

public class AnswerDto {

    private Long id;

    private String content;

    private QuestionDto question;

    private MemberDto member;

    private boolean isAccepted;

    public AnswerDto(Long id, String content, QuestionDto question, MemberDto member, boolean isAccepted) {
        this.id = id;
        this.content = content;
        this.question = question;
        this.member = member;
        this.isAccepted = isAccepted;
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
}
