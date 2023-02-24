package com.owls.owlworld.review;

import java.time.LocalDateTime;

public class ReviewQuestionDto {

    Long id;
    String question;
    LocalDateTime createdAt;

    public ReviewQuestionDto(Long id, String question, LocalDateTime createdAt) {
        this.id = id;
        this.question = question;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
