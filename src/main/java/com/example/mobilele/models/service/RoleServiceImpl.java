package com.example.mobilele.models.service;

import com.example.mobilele.models.entities.RoleEntity;
import com.example.mobilele.models.enums.UserRole;
import com.example.mobilele.repositories.RoleRepository;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {
 private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleEntity find(UserRole userRole) {
        return this.roleRepository.findByName(userRole);
    }
}
