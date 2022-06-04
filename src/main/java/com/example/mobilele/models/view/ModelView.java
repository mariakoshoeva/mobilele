package com.example.mobilele.models.view;

import com.example.mobilele.models.enums.Category;

public class ModelView {
private  String name;
private Category category;
private Integer startYear;
private Integer endYear;
private String imageUrl;

    public String getName() {
        return name;
    }

    public ModelView setName(String name) {
        this.name = name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ModelView setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelView setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelView setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
