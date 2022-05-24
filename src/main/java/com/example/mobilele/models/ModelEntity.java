package com.example.mobilele.models;

import com.example.mobilele.models.enums.Category;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity  extends BaseEntity{
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @Column(length = 512)
    private String imageUrl;
    @Column(name = "end_year")
    private int endYear;
    @Column(name = "start_year")
    private int startYear;
    @ManyToOne
    private BrandEntity brand;

    public ModelEntity() {
    }

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ModelEntity setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getEndYear() {
        return endYear;
    }

    public ModelEntity setEndYear(int endYear) {
        this.endYear = endYear;
        return this;
    }

    public int getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }
}
