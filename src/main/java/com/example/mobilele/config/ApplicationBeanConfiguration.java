package com.example.mobilele.config;

import com.example.mobilele.models.dtos.ModelSeedDto;
import com.example.mobilele.models.entities.BrandEntity;
import com.example.mobilele.models.entities.ModelEntity;
import com.example.mobilele.utils.BrandEntityJsonAdapter;
import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {
         return Converters.registerInstant(new GsonBuilder())
                 .registerTypeAdapter(BrandEntity.class, new BrandEntityJsonAdapter())
                .serializeNulls()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();

    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<ModelEntity, ModelSeedDto> typeMap = modelMapper.createTypeMap(ModelEntity.class, ModelSeedDto.class);

        typeMap.addMappings(mapping -> mapping.when(Conditions.isNull()).skip(ModelEntity::getEndYear,ModelSeedDto::setEndYear));

        return modelMapper;
    }
}
