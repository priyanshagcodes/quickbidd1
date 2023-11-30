package com.example.project.controller;
import com.example.project.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    // Get wallet balance for a user
    @GetMapping("/balance")
    public ResponseEntity<BigDecimal> getWalletBalance(@RequestParam("userId") Long userId) {
        BigDecimal balance = BigDecimal.valueOf(walletService.getWalletBalance(userId));
        return ResponseEntity.ok(balance);
    }

    // Deposit Bidcoin to the wallet
    @PostMapping("/deposit")
    public ResponseEntity<Void> depositBidcoin(
            @RequestParam("userId") Long userId,
            @RequestParam("amount") BigDecimal amount
    ) {
        walletService.depositBidcoin(userId, amount);
        return ResponseEntity.ok().build();
    }

    // Withdraw Bidcoin from the wallet
    @PostMapping("/withdraw")
    public ResponseEntity<Void> withdrawBidcoin(
            @RequestParam("userId") Long userId,
            @RequestParam("amount") BigDecimal amount
    ) {
        boolean withdrawn = walletService.withdrawBidcoin(userId,amount);
        if (withdrawn) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

