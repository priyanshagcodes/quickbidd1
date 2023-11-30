package com.example.project.controller;

import com.example.project.model.Bid;
import com.example.project.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @GetMapping("/all")
    public ResponseEntity<List<Bid>> getAllBids() {
        List<Bid> allBids = bidService.getAllBids();
        return new ResponseEntity<>(allBids, HttpStatus.OK);
    }

    @GetMapping("/{bidId}")
    public ResponseEntity<Bid> getBidById(@PathVariable Long bidId) {
        Optional<Bid> bid = bidService.getBidById(bidId);

        return bid.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Bid>> getBidsForProduct(@PathVariable Long productId) {
        List<Bid> bidsForProduct = bidService.getBidsForProduct(productId);
        return new ResponseEntity<>(bidsForProduct, HttpStatus.OK);
    }

    @PostMapping("/place-bid/{productId}/{bidder}/{amount}")
    public ResponseEntity<String> placeBid(
            @PathVariable Long productId,
            @PathVariable String bidder,
            @PathVariable double amount) {
        try {
            bidService.placeBid(productId, bidder, amount);
            return new ResponseEntity<>("Bid placed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to place bid", HttpStatus.BAD_REQUEST);
        }
    }

}
