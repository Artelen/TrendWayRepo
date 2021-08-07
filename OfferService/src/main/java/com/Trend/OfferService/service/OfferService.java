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
    public void deleteOfferById(String offerId)
    {
        cargoOfferRepository.deleteById(offerId);
        percentageDiscountInCartOfferRepository.deleteById(offerId);
    }
    public CargoOffer findCargoOfferById(String id)
    {
        return cargoOfferRepository.findById(id).orElseThrow(()->new RuntimeException("Cargo Offer not found id:"+id));
    }
    public PercentageDiscountInCartOffer findCartOffer(String id)
    {
        return percentageDiscountInCartOfferRepository.findById(id).orElseThrow(()->new RuntimeException("Cart Offer not found id:"+id));
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

    public void includeProductToCartOffer(String offerId, String productId)
    {
        PercentageDiscountInCartOffer cartOffer= percentageDiscountInCartOfferRepository.findById(offerId).orElseThrow(()->new RuntimeException("Offer could not be found, ID:"+offerId));
        cartOffer.addProduct(productId);
        percentageDiscountInCartOfferRepository.save(cartOffer);

    }
}
