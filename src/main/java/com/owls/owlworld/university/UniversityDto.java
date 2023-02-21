package com.owls.owlworld.university;

import java.time.LocalDateTime;

public class UniversityDto {
    private Long id;
    private String name;
    private String code;
    private String logo;
    private LocalDateTime createdAt;

    public UniversityDto(Long id, String name, String code, String logo, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.logo = logo;
        this.createdAt = createdAt;
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
}
