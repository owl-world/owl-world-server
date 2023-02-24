package com.owls.owlworld.review;

import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.university.UniversityDto;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "review")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "university_id", nullable = false)
    private Long universityId;

    @Column(name = "review_question_id", nullable = false)
    private Long reviewQuestionId;

    @Column(name = "score", nullable = false)
    private int score;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public ReviewEntity() {
    }

    public ReviewEntity(Long id, Long memberId, Long universityId, Long reviewQuestionId, int score, LocalDateTime createdAt) {
        this.id = id;
        this.memberId = memberId;
        this.universityId = universityId;
        this.reviewQuestionId = reviewQuestionId;
        this.score = score;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public Long getReviewQuestionId() {
        return reviewQuestionId;
    }

    public void setReviewQuestionId(Long reviewQuestionId) {
        this.reviewQuestionId = reviewQuestionId;
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

    public ReviewDto toDto(MemberDto memberDto, UniversityDto universityDto, ReviewQuestionDto reviewQuestionDto) {
        return new ReviewDto(id, memberDto, universityDto, reviewQuestionDto, score, createdAt);
    }
}
