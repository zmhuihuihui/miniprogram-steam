package com.demo.miniprogram.service;

import com.demo.miniprogram.entity.Game;

import java.util.List;


public interface GameService {

    List<Game> queryGame(Game gameCondition);
    List<Game> queryGameByHot(int limit);
    List<Game> queryGameByDiscount(int limit);
    List<Game> queryGameByDate(int limit);
}
