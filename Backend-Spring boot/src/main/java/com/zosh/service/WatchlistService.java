package com.TradeNova.service;

import com.TradeNova.model.Coin;
import com.TradeNova.model.User;
import com.TradeNova.model.Watchlist;

public interface WatchlistService {

    Watchlist findUserWatchlist(Long userId) throws Exception;

    Watchlist createWatchList(User user);

    Watchlist findById(Long id) throws Exception;

    Coin addItemToWatchlist(Coin coin,User user) throws Exception;
}

