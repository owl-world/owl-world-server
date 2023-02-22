package com.owls.owlworld.like;

public class RemoveLikeRequest {

    private Long targetId;
    private String targetType;

    public RemoveLikeRequest(Long targetId, String targetType) {
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
