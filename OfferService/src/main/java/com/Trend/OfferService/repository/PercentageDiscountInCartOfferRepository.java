package com.Trend.OfferService.repository;

import com.Trend.OfferService.entity.PercentageDiscountInCartOffer;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PercentageDiscountInCartOfferRepository extends CouchbaseRepository<PercentageDiscountInCartOffer,String> {
}
