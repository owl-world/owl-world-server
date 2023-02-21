package com.owls.owlworld.member;

public class AddMemberRequest {

    String email;
    Long majorId;
    String nickname;
    String password;

    public AddMemberRequest() {
    }

    public AddMemberRequest(String email, Long majorId, String nickname, String password) {
        this.email = email;
        this.majorId = majorId;
        this.nickname = nickname;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
