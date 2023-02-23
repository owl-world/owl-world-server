package com.owls.owlworld.question;

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
@Table(name = "question")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "university_id", nullable = false)
    private Long universityId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public QuestionEntity(Long id, String title, String content, Long memberId, Long universityId, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.universityId = universityId;
        this.createdAt = createdAt;
    }

    public QuestionEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public QuestionDto toDto(MemberDto memberDto, UniversityDto universityDto) {
        return new QuestionDto(id, title, content, memberDto, universityDto, createdAt);
    }
}
