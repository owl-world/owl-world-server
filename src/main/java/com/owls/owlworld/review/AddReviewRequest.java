package com.owls.owlworld.review;

import java.util.List;

public class AddReviewRequest {

    List<Integer> scores;

    public AddReviewRequest() {
    }

    public AddReviewRequest(List<Integer> scores) {
        this.scores = scores;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }
}
