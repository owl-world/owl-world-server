package com.owls.owlworld.search;

import com.owls.owlworld.post.GetAllPostResponse;
import com.owls.owlworld.question.GetAllQuestionResponse;
import java.util.List;

public class SearchResponse {

    String keyword;
    GetAllPostResponse posts;
    GetAllQuestionResponse questions;

    List<ArticleDto> articles;

    public SearchResponse() {
    }

    public SearchResponse(String keyword, GetAllPostResponse posts, GetAllQuestionResponse questions, List<ArticleDto> articles) {
        this.keyword = keyword;
        this.posts = posts;
        this.questions = questions;
        this.articles = articles;
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

    public List<ArticleDto> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDto> articles) {
        this.articles = articles;
    }
}
