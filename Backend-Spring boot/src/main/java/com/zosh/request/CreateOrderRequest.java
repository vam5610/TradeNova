package com.TradeNova.request;

import com.TradeNova.domain.OrderType;

import com.TradeNova.model.Coin;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class CreateOrderRequest {
    private String coinId;
    private double quantity;
    private OrderType orderType;
}

