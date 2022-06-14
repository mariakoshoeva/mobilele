package com.example.mobilele.services.impl;

import com.example.mobilele.models.binding.UserRegisterBindingModel;
import com.example.mobilele.models.entities.UserEntity;
import com.example.mobilele.models.mappers.UserMapper;
import com.example.mobilele.models.service.RoleService;
import com.example.mobilele.models.service.UserLoginServiceModel;
import com.example.mobilele.repositories.UserRepository;
import com.example.mobilele.services.UserService;
import com.example.mobilele.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final UserMapper userMapper;

    public UserServiceImpl(RoleService roleService, PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser, UserMapper userMapper) {
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.userMapper = userMapper;
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        Optional<UserEntity> entity = userRepository.findByUsername(userLoginServiceModel.getUsername());
        if (entity.isPresent()) {
            boolean matches = passwordEncoder.matches(userLoginServiceModel.getPassword(), entity.get().getPassword());
            if (matches) {
                UserEntity loggedInUser = entity.get().setActive(true);
                currentUser
                        .setUsername(loggedInUser.getUsername())
                        .setFirstName(loggedInUser.getFirstName())
                        .setLastName(loggedInUser.getLastName())
                        .setLoggedIn(true)
                        .setRole(loggedInUser.getRole());
                return true;
            }
        }
        return false;
    }

    @Override
    public void logout() {
        userRepository.findByUsername(currentUser.getUsername()).get().setActive(false);
        currentUser.setLoggedIn(false).setUsername(null).setFirstName(null).setLastName(null);
    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        UserEntity userEntity = userMapper.userRegisterBindingModelToUserEntity(userRegisterBindingModel);
        userEntity.setRole(roleService.find(userRegisterBindingModel.getRole()));
        userEntity.setCreated(Instant.now());
        userEntity.setModified(Instant.now());
        userEntity.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));


        userRepository.save(userEntity);
    }
}
