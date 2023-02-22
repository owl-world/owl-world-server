package com.owls.owlworld.comment;

public class AddCommentRequest {

    private Long postId;
    private String content;

    public AddCommentRequest() {
    }

    public AddCommentRequest(Long postId, String content) {
        this.postId = postId;
        this.content = content;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
