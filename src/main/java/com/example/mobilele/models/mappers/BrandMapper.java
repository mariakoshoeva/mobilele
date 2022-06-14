package com.example.mobilele.models.mappers;

import com.example.mobilele.models.entities.BrandEntity;
import com.example.mobilele.models.view.BrandView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandView brandViewFromBrandEntity(BrandEntity brandEntity);
}
