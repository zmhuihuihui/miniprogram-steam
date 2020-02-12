package com.demo.miniprogram.dao;

import com.demo.miniprogram.entity.Achievement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementDao {

    List<Achievement> queryAchievementById(@Param("gameId") int gameId);
}
