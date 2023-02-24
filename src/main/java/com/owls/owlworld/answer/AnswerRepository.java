package com.owls.owlworld.answer;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {

    int countByQuestionId(Long questionId);

    List<AnswerEntity> findAllByQuestionId(Long questionId);

    boolean existsByQuestionIdAndIsAcceptedTrue(Long questionId);
}
