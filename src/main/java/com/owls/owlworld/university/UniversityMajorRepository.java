package com.owls.owlworld.university;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityMajorRepository extends JpaRepository<UniversityMajorEntity, Long> {

    List<UniversityMajorEntity> findByUniversityIdAndPeriod(Long universityId, String period);

}
