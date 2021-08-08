package com.Trend.OfferService.entity;

import java.util.List;

public class CartOfferList {
    List<PercentageDiscountInCartOffer> percentageDiscountInCartOffers;

    public CartOfferList(List<PercentageDiscountInCartOffer> percentageDiscountInCartOffers) {
        this.percentageDiscountInCartOffers = percentageDiscountInCartOffers;
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
