package com.example.mobilele.models.service;

import com.example.mobilele.models.entities.RoleEntity;
import com.example.mobilele.models.enums.UserRole;


public interface RoleService {
    RoleEntity find(UserRole userRole);
}
