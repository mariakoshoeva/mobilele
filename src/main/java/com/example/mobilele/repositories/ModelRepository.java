package com.example.mobilele.repositories;

import com.example.mobilele.models.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity,Long> {

    boolean existsByName(String name);
    ModelEntity findByName(String name);
}
