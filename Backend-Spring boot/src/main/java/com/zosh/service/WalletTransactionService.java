package com.TradeNova.service;

import com.TradeNova.domain.WalletTransactionType;
import com.TradeNova.model.Wallet;
import com.TradeNova.model.WalletTransaction;

import java.util.List;

public interface WalletTransactionService {
    WalletTransaction createTransaction(Wallet wallet,
                                        WalletTransactionType type,
                                        String transferId,
                                        String purpose,
                                        Long amount
    );

    List<WalletTransaction> getTransactions(Wallet wallet, WalletTransactionType type);

}

