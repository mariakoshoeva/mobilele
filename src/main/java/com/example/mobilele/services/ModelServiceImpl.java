package com.example.mobilele.services;

import com.example.mobilele.models.dtos.ModelSeedDto;
import com.example.mobilele.models.entities.ModelEntity;
import com.example.mobilele.repositories.ModelRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, Gson gson, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedModel() {
//        if (this.modelRepository.count() > 0) {
//            return;
//        }
//        List<ModelSeedDto> modelSeedDtos = this.modelRepository.findAll()
//                .stream().map(e -> modelMapper.map(e, ModelSeedDto.class))
//                .collect(Collectors.toList());
//        String s = gson.toJson(modelSeedDtos);
//
//        try {
//            Files.writeString(Path.of("src/main/resources/files/models.txt"),s);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            String s = Files.readString(Path.of("src/main/resources/files/models.txt"));
//            ModelSeedDto[] modelSeedDto = gson.fromJson(s, ModelSeedDto[].class);
//            System.out.println();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
