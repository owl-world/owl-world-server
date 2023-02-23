package com.owls.owlworld.question;

import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.member.MemberService;
import com.owls.owlworld.post.GetAllPostResponse;
import com.owls.owlworld.post.PostEntity;
import com.owls.owlworld.university.UniversityDto;
import com.owls.owlworld.university.UniversityService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final MemberService memberService;
    private final UniversityService universityService;

    public QuestionService(QuestionRepository questionRepository, MemberService memberService, UniversityService universityService) {
        this.questionRepository = questionRepository;
        this.memberService = memberService;
        this.universityService = universityService;
    }

    public GetAllQuestionResponse getQuestions(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<QuestionEntity> result = questionRepository.findAll(pageRequest);

        List<QuestionEntity> content = result.getContent();

        return new GetAllQuestionResponse(
            result.getTotalPages(),
            result.getTotalElements(),
            content.stream()
                .map(questionEntity -> {
                    MemberDto memberDto = new MemberDto(questionEntity.getMemberId());
                    return questionEntity.toDto(memberDto, null);
                }).collect(Collectors.toList()));
    }

    public QuestionDto createQuestion(AddQuestionRequest addQuestionRequest, Long memberId) {
        MemberDto memberDto = memberService.findById(memberId);
        UniversityDto universityDto = universityService.getUniversityById(addQuestionRequest.getUniversityId());

        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setTitle(addQuestionRequest.getTitle());
        questionEntity.setContent(addQuestionRequest.getContent());
        questionEntity.setMemberId(memberDto.getId());
        questionEntity.setUniversityId(universityDto.getId());

        QuestionEntity saved = questionRepository.save(questionEntity);

        return saved.toDto(memberDto, universityDto);
    }
}
