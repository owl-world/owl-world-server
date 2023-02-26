package com.owls.owlworld.university;

public class GetAllUniversityWithScoreResponse {

    private UniversityDto universityDto;
    private Integer avgScore;

    public GetAllUniversityWithScoreResponse() {
    }

    public GetAllUniversityWithScoreResponse(UniversityDto universityDto, Integer avgScore) {
        this.universityDto = universityDto;
        this.avgScore = avgScore;
    }

    public UniversityDto getUniversityDto() {
        return universityDto;
    }

    public void setUniversityDto(UniversityDto universityDto) {
        this.universityDto = universityDto;
    }

    public Integer getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Integer avgScore) {
        this.avgScore = avgScore;
    }
}
