package com.owls.owlworld.answer;

import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.question.QuestionDto;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "answer")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "question_id", nullable = false)
    private Long questionId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "is_accepted", nullable = false)
    private boolean isAccepted;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public AnswerEntity() {
    }

    public AnswerEntity(Long id, String content, Long questionId, Long memberId, boolean isAccepted, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.questionId = questionId;
        this.memberId = memberId;
        this.isAccepted = isAccepted;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public AnswerDto toDto(QuestionDto questionDto, MemberDto memberDto, int likeCount, boolean liked) {
        return new AnswerDto(id, content, likeCount, liked, questionDto, memberDto, isAccepted, createdAt);
    }
}
