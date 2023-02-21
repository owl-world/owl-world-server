package com.owls.owlworld.university;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<UniversityEntity, Long> {

    UniversityEntity findByCode(String code);
}
