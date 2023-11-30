package com.example.project.repository;

import com.example.project.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    // Additional custom queries can be added here if needed
    Wallet findByUserId(Long userId);
}

