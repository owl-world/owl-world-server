package com.owls.owlworld.university;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "university")
public class UniversityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "code", length = 10, nullable = false, unique = true)
    private String code;

    @Column(name = "logo", length = 1000, nullable = false)
    private String logo;

    @Column(name = "created_at", nullable = false, columnDefinition = "datetime default current_timestamp()")
    private LocalDateTime createdAt;

    public UniversityEntity(Long id, String name, String code, String logo, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.logo = logo;
        this.createdAt = createdAt;
    }

    public UniversityEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UniversityDto toDto() {
        return new UniversityDto(id, name, code, logo, createdAt);
    }
}