package com.example.mobilele.repositories;

import com.example.mobilele.models.entities.ModelEntity;
import com.example.mobilele.models.entities.OfferEntity;
import com.example.mobilele.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OfferRepository extends JpaRepository<OfferEntity,Long> {
    List<OfferEntity> findAllByModelAndSeller(ModelEntity model, UserEntity seller);

}
