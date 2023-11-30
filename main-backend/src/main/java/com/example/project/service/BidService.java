package com.example.project.service;

import com.example.project.model.Bid;
import com.example.project.model.Product;
import com.example.project.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private ProductService productService;

    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    public Optional<Bid> getBidById(Long bidId) {
        return bidRepository.findById(bidId);
    }

    public List<Bid> getBidsForProduct(Long productId) {
        return bidRepository.findByProductIdOrderByBidTimeDesc(productId);
    }

    public Bid placeBid(Long productId, String bidder, double amount) {
        Product product = productService.getProductById(productId);

        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }

        // Check if the bid is within the auction time
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(product.getStartTime()) || now.isAfter(product.getEndTime())) {
            throw new IllegalStateException("Auction is not active");
        }

        Bid newBid = new Bid();
        newBid.setProduct(product);
        newBid.setBidder(bidder);
        newBid.setAmount(amount);
        newBid.setBidTime(now);

        bidRepository.save(newBid);

        // Update the winner bid if the new bid is the highest
        if (product.getWinnerBid() == null || amount > product.getWinnerBid().getAmount()) {
            product.setWinnerBid(newBid);
            productService.saveProduct(product);
        }

        return newBid;
    }

    public void saveBid(Bid bid) {
        bidRepository.save(bid);
    }

    public void deleteBid(Long bidId) {
        bidRepository.deleteById(bidId);
    }
}
