package com.owls.owlworld.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    MemberEntity findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);
}
