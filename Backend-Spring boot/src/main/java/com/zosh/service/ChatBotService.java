package com.TradeNova.service;

import com.TradeNova.model.CoinDTO;
import com.TradeNova.response.ApiResponse;

public interface ChatBotService {
    ApiResponse getCoinDetails(String coinName);

    CoinDTO getCoinByName(String coinName);

    String simpleChat(String prompt);
}

