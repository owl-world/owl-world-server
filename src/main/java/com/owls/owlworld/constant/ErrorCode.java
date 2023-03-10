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
    ERROR_0010("ERROR_0010", "실패", "좋아요를 찾을 수 없습니다."),
    ERROR_0011("ERROR_0011", "찾을 수 없음", "질문을 찾을 수 없습니다."),
    ERROR_0012("ERROR_0012", "찾을 수 없음", "답변을 찾을 수 없습니다."),
    ERROR_0013("ERROR_0013", "실패", "본인 글의 답변에만 채택을 할 수 있습니다."),
    ERROR_0014("ERROR_0014", "실패", "이미 채택 된 질문입니다."),
    ERROR_0015("ERROR_0015", "실패", "이미 채택 된 답변입니다."),
    ERROR_0016("ERROR_0016", "실패", "서버에 등록된 질문 개수만큼 점수를 요청해야합니다."),
    ERROR_0017("ERROR_0017", "실패", "리뷰는 최대 5점까지 남길 수 있습니다.");


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
