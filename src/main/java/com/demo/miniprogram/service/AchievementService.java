package com.demo.miniprogram.service;

import com.demo.miniprogram.entity.Achievement;

import java.util.List;

public interface AchievementService {

    List<Achievement> queryAchievementList(int gameId);
}
