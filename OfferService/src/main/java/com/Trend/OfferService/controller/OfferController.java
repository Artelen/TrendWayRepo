package com.Trend.OfferService.controller;

import com.Trend.OfferService.entity.CargoOffer;
import com.Trend.OfferService.entity.PercentageDiscountInCartOffer;
import com.Trend.OfferService.service.OfferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("offer")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/findCargoOfferById")
    public CargoOffer findCargoOfferById(@RequestParam String id){
        System.out.println(String.format("OfferController :: findById :: CargoOfferId = %s",id));
        return this.offerService.findCargoOfferById(id);
    }
    @GetMapping("/findCartOfferById")
    public PercentageDiscountInCartOffer findCartOfferById(@RequestParam String id){
        System.out.println(String.format("OfferController :: findById :: CartOfferId = %s",id));
        return this.offerService.findCartOffer(id);
    }
    @GetMapping("/CargoOffers")
    public List<CargoOffer> findAllCargoOffers() {
        return offerService.findAllCargoOffers();
    }
    @GetMapping("/CartOffers")
    public List<PercentageDiscountInCartOffer> findAllCartOffers() {
        return offerService.findAllPercentageDiscountInCartOffers();
    }

    @PostMapping("/createCargoOffer")
    public CargoOffer createOffer(@RequestBody CargoOffer cargoOffer){
        System.out.println("OfferController :: createCargoOffer :: "+cargoOffer.toString());
        return this.offerService.create(cargoOffer);
    }

    @PostMapping("/createCartOffer")
    public PercentageDiscountInCartOffer createOffer(@RequestBody PercentageDiscountInCartOffer cartOffer){
        System.out.println("OfferController :: createCartOffer :: "+cartOffer.toString());
        return this.offerService.create(cartOffer);
    }

    @PostMapping("/delete")
    public  void deleteById(@RequestParam String id)
    {
        System.out.println(String.format("OfferController :: deleteById :: OfferId = %s",id));
        offerService.deleteOfferById(id);
    }

    @PostMapping("/includeProduct")
    public void includeProductToCartOffer(@RequestParam String offerId,@RequestParam String productId)
    {
        offerService.includeProductToCartOffer(offerId,productId);
    }

}
