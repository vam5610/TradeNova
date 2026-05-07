package com.TradeNova.repository;

import com.TradeNova.domain.WalletTransactionType;
import com.TradeNova.model.Wallet;
import com.TradeNova.model.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction,Long> {

    List<WalletTransaction> findByWalletOrderByDateDesc(Wallet wallet);

}

