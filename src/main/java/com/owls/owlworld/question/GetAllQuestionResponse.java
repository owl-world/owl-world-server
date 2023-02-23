package com.owls.owlworld.question;

import java.util.List;

public class GetAllQuestionResponse {
    int totalPages;
    Long totalElements;
    List<QuestionDto> questions;

    public GetAllQuestionResponse(int totalPages, Long totalElements, List<QuestionDto> questions) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.questions = questions;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}
