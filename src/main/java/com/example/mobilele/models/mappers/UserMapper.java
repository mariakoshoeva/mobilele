package com.example.mobilele.models.mappers;

import com.example.mobilele.models.binding.UserRegisterBindingModel;
import com.example.mobilele.models.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "active",constant = "true")
    UserEntity userRegisterBindingModelToUserEntity(UserRegisterBindingModel userRegisterBindingModel);
}
