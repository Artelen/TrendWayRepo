package com.Trend.OfferService.service;

import com.Trend.OfferService.entity.CargoOffer;
import com.Trend.OfferService.entity.PercentageDiscountInCartOffer;
import com.Trend.OfferService.repository.CargoOfferRepository;
import com.Trend.OfferService.repository.PercentageDiscountInCartOfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    private final CargoOfferRepository cargoOfferRepository;
    private final PercentageDiscountInCartOfferRepository percentageDiscountInCartOfferRepository;

    public OfferService(CargoOfferRepository cargoOfferRepository, PercentageDiscountInCartOfferRepository percentageDiscountInCartOfferRepository) {
        this.cargoOfferRepository = cargoOfferRepository;
        this.percentageDiscountInCartOfferRepository = percentageDiscountInCartOfferRepository;
    }

    public CargoOffer create(CargoOffer cargoOffer)
    {
        return cargoOfferRepository.save(cargoOffer);
    }
    public PercentageDiscountInCartOffer create(PercentageDiscountInCartOffer percentageDiscountInCartOffer)
    {
        return percentageDiscountInCartOfferRepository.save(percentageDiscountInCartOffer);
    }
    public List<CargoOffer> findAllCargoOffers() {

        return this.cargoOfferRepository.findAll();
    }
    public List<PercentageDiscountInCartOffer> findAllPercentageDiscountInCartOffers() {
        return this.percentageDiscountInCartOfferRepository.findAll();
    }
}
