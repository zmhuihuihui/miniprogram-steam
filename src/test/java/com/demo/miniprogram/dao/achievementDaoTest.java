package com.demo.miniprogram.dao;

import com.demo.miniprogram.entity.Achievement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class achievementDaoTest {

    @Autowired
    private AchievementDao achievementDao;

    @Test
    public void queryAchievementTest(){
        List<Achievement> achievementList = new ArrayList<>();
        achievementList = achievementDao.queryAchievementById(1);
        for(Achievement achievement : achievementList ){
            System.out.println(achievement.getGame().getName());
        }
    }
}
