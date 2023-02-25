package com.owls.owlworld.question;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

    Page<QuestionEntity> findAllByUniversityId(Long universityId, Pageable pageable);

    Page<QuestionEntity> findByContentContaining(String keyword, Pageable pageable);
}
