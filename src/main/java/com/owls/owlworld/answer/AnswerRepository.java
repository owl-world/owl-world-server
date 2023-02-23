package com.owls.owlworld.answer;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {

    int countByQuestionId(Long questionId);

    List<AnswerEntity> findAllByQuestionId(Long questionId);
}
