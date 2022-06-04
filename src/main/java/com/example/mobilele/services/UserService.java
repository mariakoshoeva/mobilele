package com.example.mobilele.services;


import com.example.mobilele.models.service.UserLoginServiceModel;

public interface UserService {
    boolean login(UserLoginServiceModel userLoginServiceModel);
    void logout();
}
