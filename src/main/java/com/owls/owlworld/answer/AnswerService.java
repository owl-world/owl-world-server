package com.owls.owlworld.answer;

import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.member.MemberService;
import com.owls.owlworld.question.QuestionDto;
import com.owls.owlworld.question.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final MemberService memberService;

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository, MemberService memberService) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.memberService = memberService;
    }

    public AnswerDto addAnswer(AddAnswerRequest addAnswerRequest, Long memberId) {

        MemberDto memberDto = memberService.findById(memberId);

        QuestionDto questionDto = questionRepository.findById(addAnswerRequest.getQuestionId())
            .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0011))
            .toDto(memberDto, null);

        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setContent(addAnswerRequest.getContent());
        answerEntity.setQuestionId(questionDto.getId());
        answerEntity.setMemberId(memberDto.getId());
        answerEntity.setAccepted(false);

        AnswerEntity saved = answerRepository.save(answerEntity);
        return saved.toDto(questionDto, memberDto);
    }
}
