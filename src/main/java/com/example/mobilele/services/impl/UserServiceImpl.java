package com.example.mobilele.services.impl;

import com.example.mobilele.models.binding.UserRegisterBindingModel;
import com.example.mobilele.models.entities.RoleEntity;
import com.example.mobilele.models.entities.UserEntity;
import com.example.mobilele.models.service.UserLoginServiceModel;
import com.example.mobilele.repositories.RoleRepository;
import com.example.mobilele.repositories.UserRepository;
import com.example.mobilele.services.UserService;
import com.example.mobilele.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final RoleRepository roleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.roleRepository = roleRepository;
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        Optional<UserEntity> entity = userRepository.findByUserName(userLoginServiceModel.getUsername());
        if (entity.isPresent()) {
            boolean matches = passwordEncoder.matches(userLoginServiceModel.getPassword(), entity.get().getPassword());
            if (matches) {
                UserEntity loggedInUser = entity.get().setActive(true);
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
        userRepository.findByUserName(currentUser.getUsername()).get().setActive(false);
        currentUser.setLoggedIn(false).setUsername(null).setFirstName(null).setLastName(null);
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        RoleEntity role = roleRepository.findByName(userRegisterBindingModel.getRole());
        UserEntity userEntity = (UserEntity) new UserEntity()
                .setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()))
                .setUserName(userRegisterBindingModel.getUsername())
                .setFirstName(userRegisterBindingModel.getFirstName())
                .setLastName(userRegisterBindingModel.getLastName())
                .setRole(role)
                .setCreated(Instant.now())
                .setModified(Instant.now());


        userRepository.save(userEntity);
        return true;
    }
}
