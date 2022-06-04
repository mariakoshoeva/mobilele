package com.example.mobilele.repositories;

import com.example.mobilele.models.entities.BrandEntity;
import com.example.mobilele.models.view.BrandView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Long> {
    boolean existsByName(String name);
    BrandEntity findByName(String name);

    @Query("select distinct b from BrandEntity b join fetch b.models m")
    List<BrandEntity> getAllWhitTheirModels();

}
