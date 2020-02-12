package com.demo.miniprogram.dao;

import com.demo.miniprogram.entity.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class gameDaoTest {

    @Autowired
    private GameDao gameDao;

    @Test
    public void testQueryGame(){
        Game game = new Game();
        game.setGameId(2);
        List<Game> gameList = gameDao.queryGame(game);
        for(Game g : gameList){
            System.out.println(g.getPrice());
        }

    }
}
