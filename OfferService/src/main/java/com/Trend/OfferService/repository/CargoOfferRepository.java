package com.Trend.OfferService.repository;

import com.Trend.OfferService.entity.CargoOffer;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoOfferRepository extends CouchbaseRepository<CargoOffer,String> {
}
