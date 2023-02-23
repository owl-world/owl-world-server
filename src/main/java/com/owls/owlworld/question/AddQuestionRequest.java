package com.owls.owlworld.question;

public class AddQuestionRequest {

    String title;
    String content;

    Long universityId;

    public AddQuestionRequest() {
    }

    public AddQuestionRequest(String title, String content, Long universityId) {
        this.title = title;
        this.content = content;
        this.universityId = universityId;
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

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }
}
