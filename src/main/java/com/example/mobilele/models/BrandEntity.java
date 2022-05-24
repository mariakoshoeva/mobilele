package com.example.mobilele.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {
    @Column(unique = true,nullable = false)
    private String name;

    public BrandEntity() {
    }

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }
}
