package com.Trend.BasketService.repository;

import com.Trend.BasketService.entity.Cart;
import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.ScanConsistency;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends CouchbaseRepository<Cart,Long> {
    @ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
    Optional<Cart> findById(Long id);
    @ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
    Cart save(Cart cart);
    @ScanConsistency(query = QueryScanConsistency.REQUEST_PLUS)
    void deleteById(Long id);

}
