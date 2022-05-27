package com.example.mobilele.models.dtos;

import com.example.mobilele.models.entities.BrandEntity;
import com.example.mobilele.models.enums.Category;
import com.google.gson.annotations.Expose;


import java.io.Serializable;
import java.time.Instant;

public class ModelSeedDto implements Serializable {
    @Expose
    private Instant created;
    @Expose
    private Instant modified;
    @Expose
    private String name;
    @Expose
    private Category category;
    @Expose
    private String imageUrl;
    @Expose
    private Integer endYear;
    @Expose
    private Integer startYear;
    @Expose
    private BrandEntity brand;

    public Instant getCreated() {
        return created;
    }

    public ModelSeedDto setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public ModelSeedDto setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public String getName() {
        return name;
    }

    public ModelSeedDto setName(String name) {
        this.name = name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ModelSeedDto setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelSeedDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelSeedDto setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelSeedDto setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelSeedDto setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }
}
