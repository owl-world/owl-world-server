package com.owls.owlworld.question;

import com.owls.owlworld.answer.AnswerDto;
import com.owls.owlworld.answer.AnswerService;
import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.member.MemberService;
import com.owls.owlworld.university.UniversityDto;
import com.owls.owlworld.university.UniversityService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final MemberService memberService;
    private final UniversityService universityService;
    private final AnswerService answerService;

    public QuestionService(QuestionRepository questionRepository, MemberService memberService, UniversityService universityService, AnswerService answerService) {
        this.questionRepository = questionRepository;
        this.memberService = memberService;
        this.universityService = universityService;
        this.answerService = answerService;
    }

    public GetAllQuestionResponse getQuestions(Integer page, Integer size, Long universityId) {

        Pageable pageRequest = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<QuestionEntity> result = questionRepository.findAllByUniversityId(universityId, pageRequest);

        List<QuestionEntity> content = result.getContent();

        return new GetAllQuestionResponse(
            result.getTotalPages(),
            result.getTotalElements(),
            content.stream()
                .map(questionEntity -> {
                    MemberDto memberDto = questionEntity.getMemberId() == null ? null : memberService.findById(questionEntity.getMemberId());
                    int answerCount = answerService.getAnswerCount(questionEntity.getId());
                    return questionEntity.toDto(memberDto, null, null, answerCount);
                }).collect(Collectors.toList()));
    }

    public QuestionDto createQuestion(AddQuestionRequest addQuestionRequest, Long memberId) {
        MemberDto memberDto = memberId == null ? null : memberService.findById(memberId);
        UniversityDto universityDto = universityService.getUniversityById(addQuestionRequest.getUniversityId());

        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setContent(addQuestionRequest.getContent());
        questionEntity.setMemberId(null);
        questionEntity.setUniversityId(universityDto.getId());

        QuestionEntity saved = questionRepository.save(questionEntity);

        return saved.toDto(memberDto, universityDto, new ArrayList<>(), 0);
    }

    public QuestionDto getQuestion(Long questionId, Long memberId) {

        QuestionEntity questionEntity = questionRepository.findById(questionId).orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0011));

        MemberDto questionWriter = questionEntity.getMemberId() == null ? null : memberService.findById(questionEntity.getMemberId());
        List<AnswerDto> answers = answerService.getAnswers(questionEntity.getId(), memberId);

        UniversityDto universityDto = universityService.getUniversityById(questionEntity.getUniversityId());
        return questionEntity.toDto(questionWriter, universityDto, answers, answers.size());
    }

    public GetAllQuestionResponse getQuestionsByKeyword(Integer page, Integer size, String keyword) {
        Pageable pageRequest = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<QuestionEntity> result = questionRepository.findByContentContaining(keyword, pageRequest);

        List<QuestionEntity> content = result.getContent();

        return new GetAllQuestionResponse(
            result.getTotalPages(),
            result.getTotalElements(),
            content.stream()
                .map(questionEntity -> {
                    MemberDto memberDto = questionEntity.getMemberId() == null ? null : memberService.findById(questionEntity.getMemberId());
                    int answerCount = answerService.getAnswerCount(questionEntity.getId());
                    UniversityDto universityDto = universityService.getUniversityById(questionEntity.getUniversityId());
                    return questionEntity.toDto(memberDto, universityDto, null, answerCount);
                }).collect(Collectors.toList()));
    }
}
