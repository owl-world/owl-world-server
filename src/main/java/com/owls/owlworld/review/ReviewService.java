package com.owls.owlworld.review;

import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.member.MemberService;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewQuestionRepository reviewQuestionRepository;
    private final MemberService memberService;

    public ReviewService(ReviewRepository reviewRepository, ReviewQuestionRepository reviewQuestionRepository, MemberService memberService) {
        this.reviewRepository = reviewRepository;
        this.reviewQuestionRepository = reviewQuestionRepository;
        this.memberService = memberService;
    }

    public List<ReviewQuestionDto> getAllReviewQuestions() {
        return reviewQuestionRepository.findAll()
            .stream()
            .map(ReviewQuestionEntity::toDto)
            .collect(Collectors.toList());
    }

    @Transactional
    public List<Integer> addReview(AddReviewRequest addReviewRequest, Long memberId) {
        List<Integer> scores = addReviewRequest.getScores();

        List<Integer> overScores = scores.stream().filter(score -> score > 5).collect(Collectors.toList());
        if (overScores.size() > 0) {
            throw new BusinessErrorException(ErrorCode.ERROR_0017);
        }

        List<ReviewQuestionDto> reviewQuestions = getAllReviewQuestions();
        if (scores.size() != reviewQuestions.size()) {
            throw new BusinessErrorException(ErrorCode.ERROR_0016);
        }

        MemberDto memberDto = memberService.findById(memberId);

        List<ReviewEntity> reviewEntities = scores.stream()
            .map(score -> {
                ReviewEntity reviewEntity = new ReviewEntity();
                reviewEntity.setMemberId(memberDto.getId());
                reviewEntity.setUniversityId(memberDto.getUniversityMajorDto().getUniversity().getId());
                reviewEntity.setScore(score);
                reviewEntity.setReviewQuestionId(reviewQuestions.get(scores.indexOf(score)).getId());
                return reviewEntity;
            })
            .filter(reviewEntity -> reviewEntity.getScore() > 0)
            .collect(Collectors.toList());

        return reviewRepository.saveAll(reviewEntities)
            .stream()
            .map(ReviewEntity::getScore)
            .collect(Collectors.toList());
    }

}
