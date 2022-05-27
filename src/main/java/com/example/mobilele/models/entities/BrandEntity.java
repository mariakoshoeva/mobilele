package com.example.mobilele.models.entities;


import com.example.mobilele.utils.BrandEntityJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
@JsonAdapter(BrandEntityJsonAdapter.class)
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
