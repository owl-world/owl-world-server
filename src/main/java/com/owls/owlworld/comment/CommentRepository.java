package com.owls.owlworld.comment;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    // 카운트
    int countByPostId(Long postId);

    List<CommentEntity> findAllByPostIdOrderByCreatedAtAsc(Long postId);

}
