package com.owls.owlworld.constant;

public enum ErrorCode {

    ERROR_0001("ERROR_0001", "중복", "중복된 이메일입니다."),
    ERROR_0002("ERROR_0002", "중복", "중복된 닉네임입니다."),
    ERROR_0003("ERROR_0003", "찾을 수 없음", "대학교를 찾을 수 없습니다."),
    ERROR_0004("ERROR_0004", "찾을 수 없음", "사용자를 찾을 수 없습니다."),
    ERROR_0005("ERROR_0005", "인증 실패", "인증 실패");

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
