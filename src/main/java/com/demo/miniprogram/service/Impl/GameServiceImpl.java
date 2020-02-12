package com.demo.miniprogram.service.Impl;

import com.demo.miniprogram.dao.GameDao;
import com.demo.miniprogram.entity.Game;
import com.demo.miniprogram.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;

    @Override
    public List<Game> queryGame(Game gameCondition) {
        return gameDao.queryGame(gameCondition);
    }

    @Override
    public List<Game> queryGameByHot(int limit) {
        return gameDao.queryGameByHot(limit);
    }

    @Override
    public List<Game> queryGameByDiscount(int limit) {
        return gameDao.queryGameByDiscount(limit);
    }

    @Override
    public List<Game> queryGameByDate(int limit){
        return gameDao.queryGameByDate(limit);
    }
}
