package com.Trend.CartCalculaterService.entity;

import java.util.List;

public class CartOfferList {
    List<PercentageDiscountInCartOffer> percentageDiscountInCartOffers;

    public CartOfferList(List<PercentageDiscountInCartOffer> cartOffers) {
        this.percentageDiscountInCartOffers = cartOffers;
    }

    public CartOfferList() {
    }

    public List<PercentageDiscountInCartOffer> getPercentageDiscountInCartOffers() {
        return percentageDiscountInCartOffers;
    }

    public void setPercentageDiscountInCartOffers(List<PercentageDiscountInCartOffer> percentageDiscountInCartOffers) {
        this.percentageDiscountInCartOffers = percentageDiscountInCartOffers;
    }
}
