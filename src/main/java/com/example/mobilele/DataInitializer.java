package com.example.mobilele;

import com.example.mobilele.services.ModelService;
import com.example.mobilele.services.OfferService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final ModelService modelService;
    private final OfferService offerService;

    public DataInitializer(ModelService modelService, OfferService offerService) {
        this.modelService = modelService;
        this.offerService = offerService;
    }

    public void seedDataBase() {
        this.offerService.seedOffers();
    }

    @Override
    public void run(String... args) {
        seedDataBase();
    }


}
