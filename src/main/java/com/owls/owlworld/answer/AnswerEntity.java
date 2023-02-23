package com.owls.owlworld.answer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "question_id", nullable = false)
    private Long questionId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "is_accepted", nullable = false)
    private boolean isAccepted;

    public AnswerEntity() {
    }

    public AnswerEntity(Integer id, String content, Long questionId, Long memberId, boolean isAccepted) {
        this.id = id;
        this.content = content;
        this.questionId = questionId;
        this.memberId = memberId;
        this.isAccepted = isAccepted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
