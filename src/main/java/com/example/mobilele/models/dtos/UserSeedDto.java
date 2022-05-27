package com.example.mobilele.models.dtos;

import com.example.mobilele.models.entities.RoleEntity;
import com.google.gson.annotations.Expose;

import java.time.Instant;

public class UserSeedDto {
    @Expose
    private Instant created;
    @Expose
    private Instant modified;
    @Expose
    private String firstName;
    @Expose
    private String imageUrl;
    @Expose
    private Boolean isActive;
    @Expose
    private String lastName;
    @Expose
    private String password;
    @Expose
    private String userName;
    @Expose
    private RoleEntity role;

    public Instant getCreated() {
        return created;
    }

    public UserSeedDto setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public UserSeedDto setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserSeedDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserSeedDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public UserSeedDto setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserSeedDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserSeedDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserSeedDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public RoleEntity getRole() {
        return role;
    }

    public UserSeedDto setRole(RoleEntity role) {
        this.role = role;
        return this;
    }
}
