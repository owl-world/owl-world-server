package com.owls.owlworld.review;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/question")
    public List<ReviewQuestionDto> getAllReviewQuestions() {
        return reviewService.getAllReviewQuestions();
    }

    @GetMapping("/score/{universityId}")
    public GetTotalScoresResponse getTotalScoreByUniversityId(@PathVariable String universityId) {
        return reviewService.getTotalScoreByUniversityId(Long.valueOf(universityId));
    }

    @PostMapping("/score")
    public List<GetTotalScoresResponse> getTotalScoresByUniversityIds(@RequestBody GetTotalScoresRequest getTotalScoresRequest) {
        return reviewService.getTotalScoresByUniversityIds(getTotalScoresRequest);
    }

    @PostMapping("/score/all")
    public List<GetTotalScoresResponse> getTotalScoresByUniversityIds() {
        return reviewService.getTotalScoresAllUniversity();
    }

    @PostMapping("")
    public List<Integer> addReview(@RequestBody AddReviewRequest addReviewRequest, HttpServletRequest request) {
        Long memberId = Long.valueOf(String.valueOf(request.getAttribute("memberId")));

        return reviewService.addReview(addReviewRequest, memberId);
    }

}
