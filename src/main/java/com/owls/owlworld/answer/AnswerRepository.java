package com.owls.owlworld.answer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {

    int countByQuestionId(Long questionId);
}
