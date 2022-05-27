package com.example.mobilele.repositories;

import com.example.mobilele.models.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Long> {
    boolean existsByName(String name);
    BrandEntity findByName(String name);
}
