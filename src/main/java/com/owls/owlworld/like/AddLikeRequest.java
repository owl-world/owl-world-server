package com.owls.owlworld.like;

public class AddLikeRequest {
    private Long targetId;
    private String targetType;

    public AddLikeRequest(Long targetId, String targetType) {
        this.targetId = targetId;
        this.targetType = targetType;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }
}
