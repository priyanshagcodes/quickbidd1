package com.example.project.service;

import com.example.project.exception.InsufficientBidcoinsException;
import com.example.project.exception.UserNotFoundException;
import com.example.project.model.User;
import com.example.project.model.Wallet;
import com.example.project.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserService userService;

    public void addBidcoinsToWallet(Long userId, BigDecimal bidcoinsToAdd) {
        // Validate bidcoinsToAdd if needed

        // Retrieve the user's wallet
        Wallet wallet = getOrCreateWallet(userId);

        // Add Bidcoins to the wallet
        wallet.setBidcoinBalance(wallet.getBidcoinBalance().add(bidcoinsToAdd));
        walletRepository.save(wallet);
    }

    public int getWalletBalance(Long userId) {
        // Retrieve the user's wallet
        Wallet wallet = getOrCreateWallet(userId);

        return wallet.getBidcoinBalance().intValue();
    }

    public boolean withdrawBidcoin(Long userId, BigDecimal bidcoinsToWithdraw) {
        // Retrieve the user's wallet
        Wallet wallet = getOrCreateWallet(userId);

        // Check if the user has sufficient Bidcoins
        if (wallet.getBidcoinBalance().compareTo(bidcoinsToWithdraw) >= 0) {
            // Deduct Bidcoins from the wallet
            BigDecimal newBalance = wallet.getBidcoinBalance().subtract(bidcoinsToWithdraw);
            wallet.setBidcoinBalance(newBalance);
            walletRepository.save(wallet);
            return true;  // Withdrawal successful
        } else {
            return false; // Insufficient Bidcoins
        }
    }

    public void depositBidcoin(Long userId, BigDecimal bidcoinsToDeposit) {
        // Validate bidcoinsToDeposit if needed

        // Retrieve the user's wallet
        Wallet wallet = getOrCreateWallet(userId);

        // Deposit Bidcoins to the wallet
        wallet.setBidcoinBalance(wallet.getBidcoinBalance().add(bidcoinsToDeposit));
        walletRepository.save(wallet);
    }

    private Wallet getOrCreateWallet(Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return user.getWallet() != null ? user.getWallet() : createWallet(user);
        } else {
            // Handle user not found
            throw new UserNotFoundException("User not found with ID: " + userId);
        }
    }

    private Wallet createWallet(User user) {
        Wallet wallet = new Wallet(user, BigDecimal.ZERO);
        return walletRepository.save(wallet);
    }
}
