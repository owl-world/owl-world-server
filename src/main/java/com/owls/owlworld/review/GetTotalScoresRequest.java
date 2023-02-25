package com.owls.owlworld.review;

import java.util.List;

public class GetTotalScoresRequest {

    private List<Long> universityIds;

    public GetTotalScoresRequest() {
    }

    public GetTotalScoresRequest(List<Long> universityIds) {
        this.universityIds = universityIds;
    }

    public List<Long> getUniversityIds() {
        return universityIds;
    }

    public void setUniversityIds(List<Long> universityIds) {
        this.universityIds = universityIds;
    }
}
