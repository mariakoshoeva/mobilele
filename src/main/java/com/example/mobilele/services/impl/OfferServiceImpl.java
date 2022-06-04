package com.example.mobilele.services.impl;

import com.example.mobilele.models.dtos.OfferSeedDto;
import com.example.mobilele.models.entities.*;
import com.example.mobilele.repositories.*;
import com.example.mobilele.services.OfferService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final RoleRepository roleRepository;
    private final BrandRepository branRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;

    public OfferServiceImpl(OfferRepository offerRepository, UserRepository userRepository,
                            ModelRepository modelRepository, RoleRepository roleRepository,
                            BrandRepository branRepository, ModelMapper modelMapper, Gson gson) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.roleRepository = roleRepository;
        this.branRepository = branRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedOffers() {
        if(offerRepository.count() > 0){
            return;
        }
        try {
            String readString = Files.readString(Path.of("src/main/resources/files/offers.txt"));
            OfferSeedDto[] offerSeedDtos = gson.fromJson(readString, OfferSeedDto[].class);
            List<OfferEntity> offerEntities = Arrays.stream(offerSeedDtos)
                    .map(dto -> modelMapper.map(dto, OfferEntity.class)).collect(Collectors.toList());
            for (OfferEntity offerEntity : offerEntities) {
                BrandEntity brand = offerEntity.getModel().getBrand();
                ModelEntity model = offerEntity.getModel();

                if (this.branRepository.existsByName(brand.getName())) {
                    model.setBrand(branRepository.findByName(brand.getName()));
                } else {
                    branRepository.save(brand);
                }
                if (this.modelRepository.existsByName(model.getName())) {
                    model = modelRepository.findByName(model.getName());
                    offerEntity.setModel(modelRepository.findByName(model.getName()));
                } else {
                    modelRepository.save(model);
                }

                RoleEntity role = offerEntity.getSeller().getRole();
                UserEntity seller = offerEntity.getSeller();
                if (this.roleRepository.existsByName(role.getName())) {
                    seller.setRole(roleRepository.findByName(role.getName()));
                } else {
                    roleRepository.save(role);
                }
                if (this.userRepository.existsByUserName(seller.getUserName())) {
                    seller = userRepository.findByUserName(seller.getUserName()).orElse(null);
                    assert seller != null;
                    offerEntity.setSeller(userRepository.findByUserName(seller.getUserName()).orElse(null));
                } else {
                    userRepository.save(seller);
                }
                List<OfferEntity> collect = offerRepository.findAllByModelAndSeller(model, seller)
                        .stream().filter(offer -> !offer.equals(offerEntity)).collect(Collectors.toList());
                if(collect.size() == 0){
                    offerRepository.save(offerEntity);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
