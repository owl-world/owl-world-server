package com.owls.owlworld.university;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/university")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/{code}/major")
    public List<UniversityMajorDto> getMajors(@PathVariable String code) {
        return universityService.getMajors(code);
    }

    @GetMapping("/all")
    public List<UniversityDto> getAllUniversities() {
        return universityService.getAllUniversities();
    }

}
