package com.demo.miniprogram.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.demo.miniprogram.Util.RedisUtil;
import com.demo.miniprogram.dao.GameDao;
import com.demo.miniprogram.entity.Game;
import com.demo.miniprogram.exception.LimitException;
import com.demo.miniprogram.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Game> queryGame(Game gameCondition) {
        List<Game> list = new ArrayList<>();
        if(gameCondition.getGameId() != null && redisUtil.hasKey(String.valueOf(gameCondition.getGameId()))){
            String JsonObj = redisUtil.get(String.valueOf(gameCondition.getGameId()));
            Game game = JSONArray.parseObject(JsonObj,Game.class);
            list.add(game);
        }
        else if(gameCondition.getName() != null && redisUtil.hasKey(gameCondition.getName())){
            String JsonObj = redisUtil.get(gameCondition.getName());
            Game game = JSONArray.parseObject(JsonObj,Game.class);
            list.add(game);

        }else{
            list = gameDao.queryGame(gameCondition);
            for(Game game : list){
                String JsonObj = JSON.toJSON(game).toString();
                redisUtil.set(game.getName(),JsonObj);
                redisUtil.expire(game.getName(),1800);
                redisUtil.set(String.valueOf(game.getGameId()),JsonObj);
                redisUtil.expire(game.getName(),1800);
            }

        }
        return list;
    }

    @Override
    public List<Game> queryGameByHot(int limit) {
        if(limit < 0) throw new LimitException("limit参数错误！");
        return gameDao.queryGameByHot(limit);
    }

    @Override
    public List<Game> queryGameByDiscount(int limit) {
        if(limit < 0) throw new LimitException("limit参数错误！");
        return gameDao.queryGameByDiscount(limit);
    }

    @Override
    public List<Game> queryGameByDate(int limit){
        if(limit < 0) throw new LimitException("limit参数错误！");
        return gameDao.queryGameByDate(limit);
    }
}
