package com.example.mobilele.models.dtos;

import com.example.mobilele.models.entities.ModelEntity;
import com.example.mobilele.models.entities.UserEntity;
import com.example.mobilele.models.enums.Engine;
import com.example.mobilele.models.enums.Transmission;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

public class OfferSeedDto implements Serializable {
    @Expose
    private Instant created;
    @Expose
    private Instant modified;
    @Expose
    private String description;
    @Expose
    private Engine engine;
    @Expose
    private String imageUrl;
    @Expose
    private Integer mileage;
    @Expose
    private BigDecimal price;
    @Expose
    private Transmission transmission;
    @Expose
    private Integer year;
    @Expose
    private ModelSeedDto model;
    @Expose
    private UserSeedDto seller;

    public OfferSeedDto() {
    }

    public Instant getCreated() {
        return created;
    }

    public OfferSeedDto setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public OfferSeedDto setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferSeedDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public OfferSeedDto setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSeedDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferSeedDto setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferSeedDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferSeedDto setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferSeedDto setYear(Integer year) {
        this.year = year;
        return this;
    }

    public UserSeedDto getSeller() {
        return seller;
    }

    public OfferSeedDto setSeller(UserSeedDto seller) {
        this.seller = seller;
        return this;
    }

    public ModelSeedDto getModel() {
        return model;
    }

    public OfferSeedDto setModel(ModelSeedDto model) {
        this.model = model;
        return this;
    }
}
