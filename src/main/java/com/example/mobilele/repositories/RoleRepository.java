package com.example.mobilele.repositories;

import com.example.mobilele.models.entities.RoleEntity;
import com.example.mobilele.models.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<RoleEntity,Long> {

    boolean existsByName(UserRole name);

    RoleEntity findByName(UserRole name);
}
