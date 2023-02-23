package com.owls.owlworld.answer;

public class AddAnswerRequest {

    String content;
    Long questionId;

    public AddAnswerRequest() {
    }

    public AddAnswerRequest(String content, Long questionId) {
        this.content = content;
        this.questionId = questionId;
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
}
