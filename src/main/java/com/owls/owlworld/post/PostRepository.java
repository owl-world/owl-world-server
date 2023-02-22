package com.owls.owlworld.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    boolean existsById(Long id);
}
