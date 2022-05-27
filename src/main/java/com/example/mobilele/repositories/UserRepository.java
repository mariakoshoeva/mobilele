package com.example.mobilele.repositories;

import com.example.mobilele.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    boolean existsByUserName(String userName);
    UserEntity findByUserName(String userName);
}
