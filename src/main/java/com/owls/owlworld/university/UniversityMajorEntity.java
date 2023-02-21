package com.owls.owlworld.university;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "university_major")
public class UniversityMajorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "university_id", nullable = false)
    private int universityId;

    @Column(name = "period", length = 10, nullable = false)
    private String period;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "type", length = 100, nullable = false)
    private String type;

    @Column(name = "total", nullable = false)
    private int total;

    @Column(name = "competitive", nullable = false)
    private float competitive;

    @Column(name = "created_at", nullable = false, columnDefinition = "date default current_timestamp()")
    private LocalDate createdAt;

    public UniversityMajorEntity(Long id, int universityId, String period, String name, String type, int total, float competitive, LocalDate createdAt) {
        this.id = id;
        this.universityId = universityId;
        this.period = period;
        this.name = name;
        this.type = type;
        this.total = total;
        this.competitive = competitive;
        this.createdAt = createdAt;
    }

    public UniversityMajorEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
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

    public UniversityMajorDto toDto(UniversityDto universityDto) {
        return new UniversityMajorDto(id, universityDto, period, name, type, total, competitive, createdAt);
    }
}
