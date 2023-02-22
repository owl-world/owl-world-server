package com.owls.owlworld.comment;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByPostIdOrderByCreatedAtDesc(Long postId);

}
