package com.Trend.CartCalculaterService.entity;

import java.util.List;

public class CargoOfferList {
    List<CargoOffer> cargoOffers;

    public CargoOfferList(List<CargoOffer> cargoOffers) {
        this.cargoOffers = cargoOffers;
    }

    public CargoOfferList() {
    }

    public List<CargoOffer> getCargoOffers() {
        return cargoOffers;
    }

    public void setCargoOffers(List<CargoOffer> cargoOffers) {
        this.cargoOffers = cargoOffers;
    }
}
