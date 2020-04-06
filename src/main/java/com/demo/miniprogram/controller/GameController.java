package com.demo.miniprogram.controller;

import com.demo.miniprogram.Util.HttpServletRequestUtil;
import com.demo.miniprogram.entity.Game;
import com.demo.miniprogram.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/list")
public class GameController {

    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public Map<String, Object> getGame(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        Game gameCondition = new Game();
        //String gameId = request.getParameter("gameId");
        //String name = request.getParameter("name");
        String gameId = HttpServletRequestUtil.getString(request, "gameId");
        String name = HttpServletRequestUtil.getString(request, "name");
        if (gameId != null && gameId.length() > 0) gameCondition.setGameId(Integer.parseInt(gameId));
        if (name != null && name.length() > 0) gameCondition.setName(name);
        try {
            List<Game> gameList = gameService.queryGame(gameCondition);
            model.put("gameList", gameList);
            model.put("msg", "查询游戏成功");
            logger.info("查询游戏成功");
        } catch (Exception e) {
            model.put("msg", "查询游戏失败," + e.getMessage());
            logger.error("查询游戏失败");
        }
        return model;
    }

    @RequestMapping(value = "/hot/games", method = RequestMethod.GET)
    public Map<String, Object> getHotGame(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        int limit = 99;
        //String limitStr = request.getParameter("limit");
        String limitStr = HttpServletRequestUtil.getString(request, "limit");
        if (limitStr != null) limit = Integer.parseInt(limitStr);
        try {
            List<Game> gameList = gameService.queryGameByHot(limit);
            model.put("gameList", gameList);
            model.put("msg", "按热门查询游戏成功");
            logger.info("按热门查询游戏成功");
        } catch (Exception e) {
            model.put("msg", "按热门查询游戏失败," + e.getMessage());
            logger.error("按热门查询游戏失败");
        }
        return model;
    }

    @RequestMapping(value = "/specials/games", method = RequestMethod.GET)
    public Map<String, Object> getSpecialsGame(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        int limit = 99;
        //String limitStr = request.getParameter("limit");
        String limitStr = HttpServletRequestUtil.getString(request, "limit");
        if (limitStr != null) limit = Integer.parseInt(limitStr);
        try {
            List<Game> gameList = gameService.queryGameByDiscount(limit);
            model.put("gameList", gameList);
            model.put("msg", "按折扣查询游戏成功");
            logger.info("按折扣查询游戏成功");
        } catch (Exception e) {
            model.put("msg", "按折扣查询游戏失败," + e.getMessage());
            logger.error("按折扣查询游戏失败");
        }
        return model;
    }

    @RequestMapping(value = "/release/games", method = RequestMethod.GET)
    public Map<String, Object> getReleaseGame(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        int limit = 99;
        //String limitStr = request.getParameter("limit");
        String limitStr = HttpServletRequestUtil.getString(request, "limit");
        if (limitStr != null) limit = Integer.parseInt(limitStr);
        try {
            List<Game> gameList = gameService.queryGameByDate(limit);
            model.put("gameList", gameList);
            model.put("msg", "按日期查询游戏成功");
            logger.info("按日期查询游戏成功");
        } catch (Exception e) {
            model.put("msg", "按日期查询游戏失败," + e.getMessage());
            logger.error("按日期查询游戏失败");
        }
        return model;
    }

}
