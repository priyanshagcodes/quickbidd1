package com.example.project.repository;

import com.example.project.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {

    List<Bid> findByProductIdOrderByBidTimeDesc(Long productId);
}



