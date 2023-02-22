package com.owls.owlworld.like;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {

    int countByTargetTypeAndTargetId(String targetType, Long targetId);

    boolean existsByTargetTypeAndTargetIdAndMemberId(String targetType, Long targetId, Long memberId);
}
