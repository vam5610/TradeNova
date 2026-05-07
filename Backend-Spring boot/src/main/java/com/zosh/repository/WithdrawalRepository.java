package com.TradeNova.repository;

import com.TradeNova.domain.WithdrawalStatus;
import com.TradeNova.model.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WithdrawalRepository extends JpaRepository<Withdrawal,Long> {
    List<Withdrawal> findByUserId(Long userId);
}

