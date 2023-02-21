package com.owls.owlworld.member;

import com.owls.owlworld.university.UniversityMajorDto;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname", nullable = false, unique = true, length = 50)
    private String nickname;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "university_major_id", nullable = false)
    private Long universityMajorId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public MemberEntity() {
    }

    public MemberEntity(Long id, String nickname, String email, String password, Long universityMajorId, LocalDateTime createdAt) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.universityMajorId = universityMajorId;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUniversityMajorId() {
        return universityMajorId;
    }

    public void setUniversityMajorId(Long universityId) {
        this.universityMajorId = universityId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public MemberDto toDto(UniversityMajorDto universityMajorDto) {
        return new MemberDto(id, nickname, email, password, universityMajorDto, createdAt);
    }
}
