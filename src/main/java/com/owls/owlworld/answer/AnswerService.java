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
import javax.transaction.Transactional;
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

    @Transactional
    public AnswerDto addAnswer(AddAnswerRequest addAnswerRequest, Long memberId) {

        MemberDto memberDto = memberService.findById(memberId);

        QuestionEntity questionEntity = questionRepository.findById(addAnswerRequest.getQuestionId())
            .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0011));

        List<AnswerDto> answers = this.getAnswers(questionEntity.getId(), memberId);
        QuestionDto questionDto = questionEntity.toDto(memberDto, null, answers, answers.size());

        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setContent(addAnswerRequest.getContent());
        answerEntity.setQuestionId(questionDto.getId());
        answerEntity.setMemberId(memberDto.getId());
        answerEntity.setAccepted(false);

        AnswerEntity saved = answerRepository.save(answerEntity);
        return saved.toDto(questionDto, memberDto, 0, false);
    }

    public List<AnswerDto> getAnswers(Long questionId, Long memberId) {
        List<AnswerEntity> answerEntities = answerRepository.findAllByQuestionId(questionId);
        return answerEntities.stream()
            .map(answerEntity -> {
                MemberDto memberDto = memberService.findById(answerEntity.getMemberId());
                int likeCount = likeService.getLikeCount("answer", answerEntity.getId());
                boolean isLiked = memberId != null && likeService.isLiked("answer", answerEntity.getId(), memberId);
                return answerEntity.toDto(null, memberDto, likeCount, isLiked);
            }).collect(Collectors.toList());
    }

    public AnswerDto findById(Long id, Long memberId) {
        return answerRepository.findById(id)
            .map(answerEntity -> {

                MemberDto memberDto = new MemberDto(answerEntity.getMemberId());

                int likeCount = likeService.getLikeCount("answer", answerEntity.getId());

                boolean isLiked = memberId != null && likeService.isLiked("answer", answerEntity.getId(), memberId);

                QuestionDto questionDto = questionRepository.findById(answerEntity.getQuestionId())
                    .map(questionEntity -> questionEntity.toDto(memberDto, null, null, 0))
                    .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0011));

                return answerEntity.toDto(questionDto, memberDto, likeCount, isLiked);
            }).orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0012));
    }

    public int getAnswerCount(Long questionId) {
        return answerRepository.countByQuestionId(questionId);
    }

    @Transactional
    public AnswerDto acceptAnswer(Long answerId, Long memberId) {
        MemberDto memberDto = memberService.findById(memberId);
        AnswerDto answerDto = this.findById(answerId, memberId);

        // ????????? ???????????? ???????????? ????????? ??????

        MemberDto writer = answerDto.getQuestion().getMember();
        if (writer != null && !writer.getId().equals(memberId)) {
            throw new BusinessErrorException(ErrorCode.ERROR_0013);
        }

        // ????????? ????????? ????????? ?????? ??? ????????? ????????? ??????
        if (answerRepository.existsByQuestionIdAndIsAcceptedTrue(answerDto.getQuestion().getId())) {
            throw new BusinessErrorException(ErrorCode.ERROR_0014);
        }

        // ??????????????? ????????? ?????? ???????????????????????? ??????
        if (answerDto.isAccepted()) {
            throw new BusinessErrorException(ErrorCode.ERROR_0015);
        }

        // ?????? ????????????
        AnswerEntity answerEntity = answerRepository.findById(answerId)
            .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0012));
        answerEntity.setAccepted(true);
        answerRepository.save(answerEntity);

        // ?????? ?????? ??? ?????? ??????
        return this.findById(answerId, memberId);
    }
}
