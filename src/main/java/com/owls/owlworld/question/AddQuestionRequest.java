package com.owls.owlworld.question;

public class AddQuestionRequest {

    String content;

    Long universityId;

    public AddQuestionRequest() {
    }

    public AddQuestionRequest(String content, Long universityId) {
        this.content = content;
        this.universityId = universityId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }
}
