package com.Trend.BasketService.repository;

import com.Trend.BasketService.entity.Cart;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CouchbaseRepository<Cart,Long> {
}
