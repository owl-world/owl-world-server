package com.owls.owlworld.review;

public interface GetTotalScoreProjection {

    Long getUniversityId();

    Long getReviewQuestionId();

    Double getAvgScore();
}
