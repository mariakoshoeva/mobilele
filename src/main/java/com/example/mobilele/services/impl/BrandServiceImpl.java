package com.example.mobilele.services.impl;

import com.example.mobilele.models.entities.BrandEntity;
import com.example.mobilele.models.view.BrandView;
import com.example.mobilele.repositories.BrandRepository;
import com.example.mobilele.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<BrandView> getAllWithModels() {
        return this.brandRepository.getAllWhitTheirModels()
                .stream()
                .map(brandEntity -> modelMapper.map(brandEntity,BrandView.class))
                .collect(Collectors.toList());
    }
}
