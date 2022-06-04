package com.example.mobilele.models.service;

import com.example.mobilele.models.binding.UserLoginBindingModel;

public class UserLoginServiceModel {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public UserLoginServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
