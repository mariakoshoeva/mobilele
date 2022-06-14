package com.example.mobilele.services.impl;


import com.example.mobilele.models.mappers.BrandMapper;
import com.example.mobilele.models.view.BrandView;
import com.example.mobilele.repositories.BrandRepository;
import com.example.mobilele.services.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }


    @Override
    public List<BrandView> getAllWithModels() {
       return brandRepository.getAllWhitTheirModels()
               .stream()
               .map(brandMapper::brandViewFromBrandEntity)
               .collect(Collectors.toList());
    }
}
