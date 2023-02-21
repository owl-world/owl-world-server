package com.owls.owlworld.university;

import java.time.LocalDate;

public class UniversityMajorDto {

    private Long id;
    private UniversityDto university;
    private String period;
    private String name;
    private String type;
    private int total;
    private float competitive;
    private LocalDate createdAt;

    public UniversityMajorDto(Long id, UniversityDto university, String period, String name, String type, int total, float competitive, LocalDate createdAt) {
        this.id = id;
        this.university = university;
        this.period = period;
        this.name = name;
        this.type = type;
        this.total = total;
        this.competitive = competitive;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UniversityDto getUniversity() {
        return university;
    }

    public void setUniversity(UniversityDto university) {
        this.university = university;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public float getCompetitive() {
        return competitive;
    }

    public void setCompetitive(float competitive) {
        this.competitive = competitive;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
