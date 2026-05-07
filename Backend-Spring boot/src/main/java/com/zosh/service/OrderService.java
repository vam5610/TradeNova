package com.TradeNova.service;

import com.TradeNova.domain.OrderType;
import com.TradeNova.model.Coin;
import com.TradeNova.model.Order;
import com.TradeNova.model.OrderItem;
import com.TradeNova.model.User;
import com.TradeNova.request.CreateOrderRequest;


import java.util.List;

public interface OrderService {

    Order createOrder(User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long orderId);

    List<Order> getAllOrdersForUser(Long userId, String orderType,String assetSymbol);

    void cancelOrder(Long orderId);

//    Order buyAsset(CreateOrderRequest req, Long userId, String jwt) throws Exception;

    Order processOrder(Coin coin, double quantity, OrderType orderType, User user) throws Exception;

//    Order sellAsset(CreateOrderRequest req,Long userId,String jwt) throws Exception;


}

