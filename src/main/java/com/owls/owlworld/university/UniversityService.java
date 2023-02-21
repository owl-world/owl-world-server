package com.owls.owlworld.university;

import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;
    private final UniversityMajorRepository universityMajorRepository;

    public UniversityService(UniversityRepository universityRepository, UniversityMajorRepository universityMajorRepository) {
        this.universityRepository = universityRepository;
        this.universityMajorRepository = universityMajorRepository;
    }

    public List<UniversityDto> getAllUniversities() {
        return universityRepository.findAll()
            .stream()
            .map(universityEntity -> new UniversityDto(universityEntity.getId(), universityEntity.getName(),
                universityEntity.getCode(), universityEntity.getLogo(), universityEntity.getCreatedAt()))
            .collect(Collectors.toList());
    }

    public UniversityMajorDto getMajorById(Long majorId) {
        UniversityMajorEntity universityMajorEntity = universityMajorRepository.findById(majorId)
            .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0003));

        UniversityDto universityEntity = universityRepository.findById((long) universityMajorEntity.getUniversityId())
            .orElseThrow(() -> new BusinessErrorException(ErrorCode.ERROR_0003))
            .toDto();

        return universityMajorEntity.toDto(universityEntity);
    }

    public List<UniversityMajorDto> getMajors(String code) {
        UniversityEntity universityEntity = universityRepository.findByCode(code);
        if (universityEntity == null) {
            throw new BusinessErrorException(ErrorCode.ERROR_0003);
        }

        UniversityDto universityDto = new UniversityDto(universityEntity.getId(), universityEntity.getName(),
            universityEntity.getCode(), universityEntity.getLogo(), universityEntity.getCreatedAt());

        return universityMajorRepository.findByUniversityId(universityEntity.getId())
            .stream()
            .map(universityMajorEntity -> new UniversityMajorDto(
                universityMajorEntity.getId(),
                universityDto,
                universityMajorEntity.getPeriod(),
                universityMajorEntity.getName(),
                universityMajorEntity.getType(),
                universityMajorEntity.getTotal(),
                universityMajorEntity.getCompetitive(),
                universityMajorEntity.getCreatedAt()))
            .collect(Collectors.toList());
    }
}
