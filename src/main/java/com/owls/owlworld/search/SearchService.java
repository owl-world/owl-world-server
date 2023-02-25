package com.owls.owlworld.search;

import com.owls.owlworld.post.GetAllPostResponse;
import com.owls.owlworld.post.PostService;
import com.owls.owlworld.question.GetAllQuestionResponse;
import com.owls.owlworld.question.QuestionService;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    private final QuestionService questionService;
    private final PostService postService;

    public SearchService(QuestionService questionService, PostService postService) {
        this.questionService = questionService;
        this.postService = postService;
    }

    public SearchResponse search(SearchRequest searchRequest, Long memberId) {
        int page = searchRequest.getPage();
        int size = searchRequest.getSize();
        String keyword = searchRequest.getKeyword();
        GetAllQuestionResponse questions = questionService.getQuestionsByKeyword(size, page, keyword);
        if (memberId == null) {
            return new SearchResponse(keyword, null, questions);
        }

        GetAllPostResponse posts = postService.getPostsByKeyword(size, page, keyword, memberId);
        return new SearchResponse(keyword, posts, questions);
    }
}
