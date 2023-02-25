package com.owls.owlworld.review;

import com.owls.owlworld.university.UniversityDto;
import java.util.List;

public class GetToalScoresResponse {

    private UniversityDto universityDto;
    private List<Integer> totalScores;

    public GetToalScoresResponse() {
    }

    public GetToalScoresResponse(UniversityDto universityDto, List<Integer> totalScores) {
        this.universityDto = universityDto;
        this.totalScores = totalScores;
    }

    public UniversityDto getUniversityDto() {
        return universityDto;
    }

    public void setUniversityDto(UniversityDto universityDto) {
        this.universityDto = universityDto;
    }

    public List<Integer> getTotalScores() {
        return totalScores;
    }

    public void setTotalScores(List<Integer> totalScores) {
        this.totalScores = totalScores;
    }
}
