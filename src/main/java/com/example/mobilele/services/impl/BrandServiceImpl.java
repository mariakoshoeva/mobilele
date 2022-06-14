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

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public List<BrandView> getAllWithModels() {
       return null;
       //todo
    }
}
