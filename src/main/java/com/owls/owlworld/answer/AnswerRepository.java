package com.owls.owlworld.answer;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {

    int countByQuestionId(Long questionId);

    List<AnswerEntity> findAllByQuestionId(Long questionId);

    boolean existsByQuestionIdAndAcceptedTrue(Long questionId);

    @Transactional
    @Modifying
    @Query("UPDATE answer SET is_accepted = true WHERE answer.id = :id")
    void acceptAnswer(Long id);
}
