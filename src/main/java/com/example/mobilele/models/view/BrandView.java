package com.example.mobilele.models.view;

import java.util.List;

public class BrandView {
    private String name;
    private List<ModelView> models;

    public String getName() {
        return name;
    }

    public BrandView setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelView> getModels() {
        return models;
    }

    public BrandView setModels(List<ModelView> models) {
        this.models = models;
        return this;
    }
}
