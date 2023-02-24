package com.owls.owlworld.review;

import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.university.UniversityDto;
import java.time.LocalDateTime;

public class ReviewDto {

    Long id;
    MemberDto memberDto;
    UniversityDto universityDto;
    ReviewQuestionDto reviewQuestionDto;
    int score;
    LocalDateTime createdAt;

    public ReviewDto(Long id, MemberDto memberDto, UniversityDto universityDto, ReviewQuestionDto reviewQuestionDto, int score, LocalDateTime createdAt) {
        this.id = id;
        this.memberDto = memberDto;
        this.universityDto = universityDto;
        this.reviewQuestionDto = reviewQuestionDto;
        this.score = score;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MemberDto getMemberDto() {
        return memberDto;
    }

    public void setMemberDto(MemberDto memberDto) {
        this.memberDto = memberDto;
    }

    public UniversityDto getUniversityDto() {
        return universityDto;
    }

    public void setUniversityDto(UniversityDto universityDto) {
        this.universityDto = universityDto;
    }

    public ReviewQuestionDto getReviewQuestionDto() {
        return reviewQuestionDto;
    }

    public void setReviewQuestionDto(ReviewQuestionDto reviewQuestionDto) {
        this.reviewQuestionDto = reviewQuestionDto;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
