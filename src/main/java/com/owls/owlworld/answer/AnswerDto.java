package com.owls.owlworld.answer;

public class AnswerDto {

    private Long id;

    private String content;

    private Long questionId;

    private Long memberId;

    private boolean isAccepted;

    public AnswerDto(Long id, String content, Long questionId, Long memberId, boolean isAccepted) {
        this.id = id;
        this.content = content;
        this.questionId = questionId;
        this.memberId = memberId;
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

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
