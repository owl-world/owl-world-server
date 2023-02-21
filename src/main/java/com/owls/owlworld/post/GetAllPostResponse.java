package com.owls.owlworld.post;

import java.util.List;

public class GetAllPostResponse {

    int totalPages;
    Long totalElements;
    List<PostDto> posts;

    public GetAllPostResponse(int totalPages, Long totalElements, List<PostDto> posts) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.posts = posts;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }
}
