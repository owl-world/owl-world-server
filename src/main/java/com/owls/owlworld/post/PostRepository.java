package com.owls.owlworld.post;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    @Query(value = "SELECT post_id "
        + "FROM ( "
        + "    SELECT post.id AS post_id, COUNT(`like`.target_id) AS like_count "
        + "    FROM post "
        + "    LEFT JOIN `like` ON post.id = `like`.target_id AND `like`.target_type = 'post' "
        + "    WHERE post.created_at >= DATE_SUB(NOW(), INTERVAL 100 HOUR) "
        + "    GROUP BY post.id "
        + "    ORDER BY like_count DESC "
        + "    LIMIT 3 "
        + ") AS top_posts", nativeQuery = true)
    List<Long> findTop3PostIdsInLast100Hours();

    boolean existsById(Long id);
}
