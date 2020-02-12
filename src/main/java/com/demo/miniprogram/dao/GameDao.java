package com.demo.miniprogram.dao;

import com.demo.miniprogram.entity.Game;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GameDao {

    List<Game> queryGame(@Param("gameCondition") Game gameCondition);

    List<Game> queryGameByHot(@Param("limit") int limit);

    List<Game> queryGameByDiscount(@Param("limit") int limit);

    List<Game> queryGameByDate(@Param("limit") int limit);
}
