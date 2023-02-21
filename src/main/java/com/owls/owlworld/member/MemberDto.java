package com.owls.owlworld.member;

import com.owls.owlworld.university.UniversityMajorDto;
import java.time.LocalDateTime;

public class MemberDto {

    private Long id;

    private String nickname;

    private String email;

    private String password;
    private UniversityMajorDto universityMajorDto;

    private LocalDateTime createdAt;

    public MemberDto(Long id) {
        this.id = id;
    }

    public MemberDto(Long id, String nickname, String email, String password, UniversityMajorDto universityMajorDto, LocalDateTime createdAt) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.universityMajorDto = universityMajorDto;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UniversityMajorDto getUniversityMajorDto() {
        return universityMajorDto;
    }

    public void setUniversityMajorDto(UniversityMajorDto universityMajorDto) {
        this.universityMajorDto = universityMajorDto;
    }
}
