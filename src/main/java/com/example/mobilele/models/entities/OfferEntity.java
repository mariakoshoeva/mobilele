package com.example.mobilele.models.entities;

import com.example.mobilele.models.enums.Engine;
import com.example.mobilele.models.enums.Transmission;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "offers")
public class OfferEntity  extends BaseEntity {

    @Column(columnDefinition = "Text")
    private String description;
    @Enumerated(value = EnumType.STRING)
    private Engine engine;
    @Column(name = "image_url",length = 1000)
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    @Enumerated(value = EnumType.STRING)
    private Transmission transmission;
    private int year;
    @ManyToOne
    private ModelEntity model;
    @ManyToOne
    private UserEntity seller;

    public OfferEntity() {
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public OfferEntity setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferEntity setYear(int year) {
        this.year = year;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OfferEntity setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfferEntity that)) return false;
        return getMileage() == that.getMileage() && getYear() == that.getYear() && Objects.equals(getDescription(), that.getDescription()) && getEngine() == that.getEngine() && Objects.equals(getImageUrl(), that.getImageUrl()) && Objects.equals(getPrice(), that.getPrice()) && getTransmission() == that.getTransmission() && Objects.equals(getModel(), that.getModel()) && Objects.equals(getSeller(), that.getSeller());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getEngine(), getImageUrl(), getMileage(), getPrice(), getTransmission(), getYear(), getModel(), getSeller());
    }
}
