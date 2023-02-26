package com.owls.owlworld.review;

import com.owls.owlworld.university.UniversityDto;
import java.util.List;

public class GetTotalScoresResponse {

    private UniversityDto universityDto;
    private List<Integer> totalScores;
    private Integer avg;

    public GetTotalScoresResponse() {
    }

    public GetTotalScoresResponse(UniversityDto universityDto, List<Integer> totalScores, Integer avg) {
        this.universityDto = universityDto;
        this.totalScores = totalScores;
        this.avg = avg;
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

    public Integer getAvg() {
        return avg;
    }

    public void setAvg(Integer avg) {
        this.avg = avg;
    }
}
