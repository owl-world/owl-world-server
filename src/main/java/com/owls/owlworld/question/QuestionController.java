package com.owls.owlworld.question;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("")
    public QuestionDto createQuestion(AddQuestionRequest addQuestionRequest, HttpServletRequest request) {
        Long memberId = Long.valueOf(String.valueOf(request.getAttribute("memberId")));

        return questionService.createQuestion(addQuestionRequest, memberId);
    }
}
