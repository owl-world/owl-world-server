package com.owls.owlworld.answer;

import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import com.owls.owlworld.like.LikeService;
import com.owls.owlworld.member.MemberDto;
import com.owls.owlworld.member.MemberService;
import com.owls.owlworld.question.QuestionDto;
import com.owls.owlworld.question.QuestionEntity;
import com.owls.owlworld.question.QuestionRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final MemberService memberService;
    private final LikeService likeService;

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository, MemberService memberService, LikeService likeService) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.memberService = memberService;
        this.likeService = likeService;
    }

    public AnswerDto addAnswer(AddAnswerRequest addAnswerRequest, Long memberId) {

        MemberDto memberDto = memberService.findById(memberId);

        QuestionEntity questionEntity = questionRepository.findById(addAnswerRequest.getQuestionId())
            .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0011));

        List<AnswerDto> answers = this.getAnswers(questionEntity.getId());
        QuestionDto questionDto = questionEntity.toDto(memberDto, null, answers, answers.size());

        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setContent(addAnswerRequest.getContent());
        answerEntity.setQuestionId(questionDto.getId());
        answerEntity.setMemberId(memberDto.getId());
        answerEntity.setAccepted(false);

        AnswerEntity saved = answerRepository.save(answerEntity);
        return saved.toDto(questionDto, memberDto, 0);
    }

    public List<AnswerDto> getAnswers(Long questionId) {
        List<AnswerEntity> answerEntities = answerRepository.findAllByQuestionId(questionId);
        return answerEntities.stream()
            .map(answerEntity -> {
                MemberDto memberDto = new MemberDto(answerEntity.getMemberId());
                int likeCount = likeService.getLikeCount("answer", answerEntity.getId());
                return answerEntity.toDto(null, memberDto, likeCount);
            }).collect(Collectors.toList());
    }

    // 답변개수
    public int getAnswerCount(Long questionId) {
        return answerRepository.countByQuestionId(questionId);
    }
}
