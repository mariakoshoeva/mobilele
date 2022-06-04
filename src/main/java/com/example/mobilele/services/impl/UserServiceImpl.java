package com.example.mobilele.services.impl;

import com.example.mobilele.models.entities.UserEntity;
import com.example.mobilele.models.service.UserLoginServiceModel;
import com.example.mobilele.repositories.UserRepository;
import com.example.mobilele.services.UserService;
import com.example.mobilele.user.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
//    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        Optional<UserEntity> entity = userRepository.findByUserName(userLoginServiceModel.getUsername());
        if(entity.isPresent()){
            if(entity.get().getPassword().equals(userLoginServiceModel.getPassword())){
                UserEntity loggedInUser = entity.get();
                currentUser
                        .setUsername(loggedInUser.getUserName())
                        .setFirstName(loggedInUser.getFirstName())
                        .setLastName(loggedInUser.getLastName())
                        .setLoggedIn(true);
                return true;
            }
        }
        logout();
       return false;
    }

    @Override
    public void logout() {
        currentUser.setLoggedIn(false).setUsername(null).setFirstName(null).setLastName(null);
    }
}
