package com.owls.owlworld.review;

import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.member.MemberService;
import com.owls.owlworld.university.UniversityDto;
import com.owls.owlworld.university.UniversityService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewQuestionRepository reviewQuestionRepository;
    private final MemberService memberService;
    private final UniversityService universityService;

    public ReviewService(ReviewRepository reviewRepository, ReviewQuestionRepository reviewQuestionRepository, MemberService memberService, UniversityService universityService) {
        this.reviewRepository = reviewRepository;
        this.reviewQuestionRepository = reviewQuestionRepository;
        this.memberService = memberService;
        this.universityService = universityService;
    }

    public List<ReviewQuestionDto> getAllReviewQuestions() {
        return reviewQuestionRepository.findAll()
            .stream()
            .map(ReviewQuestionEntity::toDto)
            .collect(Collectors.toList());
    }

    public GetToalScoresResponse getTotalScoreByUniversityId(Long universityId) {
        UniversityDto universityDto = universityService.getUniversityById(universityId);
        if (universityDto == null) {
            throw new BusinessErrorException(ErrorCode.ERROR_0003);
        }

        List<GetTotalScoreProjection> totalScoreProjections = reviewRepository.getTotalScoreByUniversityId(universityId);

        // 초기에 0으로 전부 세팅
        List<Integer> scores = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));

        for (int i = 0; i < totalScoreProjections.size(); i++) {
            GetTotalScoreProjection totalScoreProjection = totalScoreProjections.get(i);

            Integer integerAvg = (int) Math.round(totalScoreProjection.getAvgScore());
            int index = (int) (totalScoreProjection.getReviewQuestionId() - 1);
            scores.set(index, integerAvg);
        }

        GetToalScoresResponse getToalScoresResponse = new GetToalScoresResponse();
        getToalScoresResponse.setTotalScores(scores);
        getToalScoresResponse.setUniversityDto(universityDto);

        return getToalScoresResponse;
    }

    public List<GetToalScoresResponse> getTotalScoresByUniversityIds(GetTotalScoresRequest getTotalScoresRequest) {
        return getTotalScoresRequest.getUniversityIds()
            .stream()
            .map(this::getTotalScoreByUniversityId)
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
