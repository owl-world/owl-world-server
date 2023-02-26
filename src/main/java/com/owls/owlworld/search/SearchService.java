package com.owls.owlworld.search;

import com.owls.owlworld.post.GetAllPostResponse;
import com.owls.owlworld.post.PostService;
import com.owls.owlworld.question.GetAllQuestionResponse;
import com.owls.owlworld.question.QuestionDto;
import com.owls.owlworld.question.QuestionService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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
        List<ArticleDto> questionArticle = questions.getQuestions()
            .stream().map(questionDto -> {
                ArticleDto articleDto = new ArticleDto();
                articleDto.setId(questionDto.getId());
                articleDto.setContent(questionDto.getContent());
                articleDto.setAnswerCount(questionDto.getAnswerCount());
                articleDto.setMemberDto(questionDto.getMember());
                articleDto.setUniversityDto(questionDto.getUniversityDto());
                articleDto.setCreatedAt(questionDto.getCreatedAt());
                articleDto.setType("question");
                return articleDto;
            }).collect(Collectors.toList());

        if (memberId == null) {
            return new SearchResponse(keyword, null, questions, questionArticle);
        }

        GetAllPostResponse posts = postService.getPostsByKeyword(size, page, keyword, memberId);

        List<ArticleDto> postArticle = posts.getPosts()
            .stream().map(postDto -> {
                ArticleDto articleDto = new ArticleDto();
                articleDto.setId(postDto.getId());
                articleDto.setTitle(postDto.getTitle());
                articleDto.setContent(postDto.getContent());
                articleDto.setLikeCount(postDto.getLikeCount());
                articleDto.setAnswerCount(postDto.getCommentCount());
                articleDto.setLiked(postDto.isLiked());
                articleDto.setMemberDto(postDto.getMemberDto());
                articleDto.setCreatedAt(postDto.getCreatedAt());
                articleDto.setType("post");
                return articleDto;
            }).collect(Collectors.toList());

        List<ArticleDto> searched = new ArrayList<>();
        searched.addAll(questionArticle);
        searched.addAll(postArticle);

        Collections.sort(searched, new ArticleCreatedAtCompator().reversed());
        return new SearchResponse(keyword, posts, questions, searched);
    }
}
