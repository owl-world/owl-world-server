package com.owls.owlworld.search;

import com.owls.owlworld.post.GetAllPostResponse;
import com.owls.owlworld.question.GetAllQuestionResponse;

public class SearchResponse {

    String keyword;
    GetAllPostResponse posts;
    GetAllQuestionResponse questions;

    public SearchResponse() {
    }

    public SearchResponse(String keyword, GetAllPostResponse posts, GetAllQuestionResponse questions) {
        this.keyword = keyword;
        this.posts = posts;
        this.questions = questions;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public GetAllPostResponse getPosts() {
        return posts;
    }

    public void setPosts(GetAllPostResponse posts) {
        this.posts = posts;
    }

    public GetAllQuestionResponse getQuestions() {
        return questions;
    }

    public void setQuestions(GetAllQuestionResponse questions) {
        this.questions = questions;
    }
}
