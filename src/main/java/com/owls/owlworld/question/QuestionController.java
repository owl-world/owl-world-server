package com.owls.owlworld.question;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("")
    public GetAllQuestionResponse getQuestions(
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "30") Integer size,
        @RequestParam String universityId) {
        return questionService.getQuestions(page, size, Long.valueOf(universityId));
    }

    @GetMapping("/{questionId}")
    public QuestionDto getQuestion(@PathVariable String questionId, HttpServletRequest request) {
        boolean isMember = request.getAttribute("memberId") != null;
        Long memberId = isMember ? Long.valueOf(String.valueOf(request.getAttribute("memberId"))) : null;

        return questionService.getQuestion(Long.valueOf(questionId), memberId);
    }

    @PostMapping("")
    public QuestionDto createQuestion(@RequestBody AddQuestionRequest addQuestionRequest, HttpServletRequest request) {
        boolean isMember = request.getAttribute("memberId") != null;
        Long memberId = isMember ? Long.valueOf(String.valueOf(request.getAttribute("memberId"))) : null;

        return questionService.createQuestion(addQuestionRequest, memberId);
    }

}
