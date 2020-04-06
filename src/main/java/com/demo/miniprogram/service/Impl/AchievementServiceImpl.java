package com.demo.miniprogram.service.Impl;

import com.demo.miniprogram.dao.AchievementDao;
import com.demo.miniprogram.entity.Achievement;
import com.demo.miniprogram.exception.GameIdException;
import com.demo.miniprogram.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementDao achievementDao;

    @Override
    public List<Achievement> queryAchievementList(int gameId) {
        if( gameId < 0) throw new GameIdException("游戏Id不存在！");
        return achievementDao.queryAchievementById(gameId);
    }
}
