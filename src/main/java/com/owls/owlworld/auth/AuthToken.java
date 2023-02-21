package com.owls.owlworld.auth;

public class AuthToken {
    Long id;
    String email;
    String nickname;
    Long university_major_id;
    Long university_id;

    public AuthToken(Long id, String email, String nickname, Long university_major_id, Long university_id) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.university_major_id = university_major_id;
        this.university_id = university_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getUniversity_major_id() {
        return university_major_id;
    }

    public void setUniversity_major_id(Long university_major_id) {
        this.university_major_id = university_major_id;
    }

    public Long getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(Long university_id) {
        this.university_id = university_id;
    }
}
