package com.owls.owlworld.review;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {


    @Query(value = "SELECT university_id as UniversityId, "
        + "review_question_id as ReviewQuestionId, "
        + "AVG(score) as AvgScore "
        + "FROM owlworld.review "
        + "WHERE university_id = :universityId "
        + "GROUP BY university_id, review_question_id",
        nativeQuery = true)
    List<GetTotalScoreProjection> getTotalScoreByUniversityId(Long universityId);

}
