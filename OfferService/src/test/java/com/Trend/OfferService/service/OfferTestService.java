package com.Trend.OfferService.service;

import com.Trend.OfferService.entity.CargoOffer;
import com.Trend.OfferService.entity.PercentageDiscountInCartOffer;
import com.Trend.OfferService.repository.CargoOfferRepository;
import com.Trend.OfferService.repository.PercentageDiscountInCartOfferRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OfferTestService {
    private final OfferService offerService;
    private final CargoOfferRepository cargoOfferRepository;
    private final PercentageDiscountInCartOfferRepository percentageDiscountInCartOfferRepository;

    @Autowired
    public OfferTestService(OfferService offerService, CargoOfferRepository cargoOfferRepository, PercentageDiscountInCartOfferRepository percentageDiscountInCartOfferRepository) {
        this.offerService = offerService;
        this.cargoOfferRepository = cargoOfferRepository;
        this.percentageDiscountInCartOfferRepository = percentageDiscountInCartOfferRepository;
    }

    @Test
    public void createCargoOffer() throws InterruptedException
    {
        CargoOffer cargoOffer =new CargoOffer("A",15,100,50);
        CargoOffer cargoOfferReturned= offerService.create(cargoOffer);
        assertEquals("A", cargoOfferReturned.getCargoName());
    }
    @Test
    public void createPercentageDiscountOffer() throws InterruptedException
    {
        Set<String> products=new HashSet<>();
        products.add("p1");
        PercentageDiscountInCartOffer percentageDiscountInCartOffer=new PercentageDiscountInCartOffer(20,products);
        PercentageDiscountInCartOffer percentageDiscountInCartOfferReturned= offerService.create(percentageDiscountInCartOffer);
        assertEquals(true, percentageDiscountInCartOfferReturned.getIncludedProducts().contains("p1"));
    }

}
