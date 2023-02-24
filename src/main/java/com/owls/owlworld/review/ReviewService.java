package com.owls.owlworld.review;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewQuestionRepository reviewQuestionRepository;

    public ReviewService(ReviewQuestionRepository reviewQuestionRepository) {
        this.reviewQuestionRepository = reviewQuestionRepository;
    }

    public List<ReviewQuestionDto> getAllReviewQuestions() {
        return reviewQuestionRepository.findAll()
            .stream()
            .map(ReviewQuestionEntity::toDto)
            .collect(Collectors.toList());
    }

}
