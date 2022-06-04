package com.example.mobilele.repositories;

import com.example.mobilele.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    boolean existsByUserName(String userName);
    Optional<UserEntity> findByUserName(String userName);
}
