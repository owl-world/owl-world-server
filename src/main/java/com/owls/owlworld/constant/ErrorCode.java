package com.owls.owlworld.constant;

public enum ErrorCode {

    ERROR_0001("ERROR_0001", "중복", "중복된 이메일입니다."),
    ERROR_0002("ERROR_0002", "중복", "중복된 닉네임입니다."),
    ERROR_0003("ERROR_0003", "찾을 수 없음", "대학교를 찾을 수 없습니다."),
    ERROR_0004("ERROR_0004", "찾을 수 없음", "사용자를 찾을 수 없습니다."),
    ERROR_0005("ERROR_0005", "인증 실패", "인증 실패"),
    ERROR_0006("ERROR_0006", "찾을 수 없음", "글을 찾을 수 없습니다."),
    ERROR_0007("ERROR_0007", "찾을 수 없음", "댓글을 찾을 수 없습니다."),
    ERROR_0008("ERROR_0008", "찾을 수 없음", "타입을 찾을 수 없습니다."),
    ERROR_0009("ERROR_0009", "실패", "이미 좋아요를 누른 글입니다."),
    ERROR_0010("ERROR_0010", "실패", "좋아요를 찾을 수 없습니다.");

    private final String code;
    private final String message;
    private final String userMessage;

    ErrorCode(String code, String message, String userMessage) {
        this.code = code;
        this.message = message;
        this.userMessage = userMessage;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getUserMessage() {
        return userMessage;
    }
}
