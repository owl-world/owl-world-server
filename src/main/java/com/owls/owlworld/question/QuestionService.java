package com.owls.owlworld.question;

import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.member.MemberService;
import com.owls.owlworld.university.UniversityDto;
import com.owls.owlworld.university.UniversityService;
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
