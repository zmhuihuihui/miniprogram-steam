package com.demo.miniprogram.controller;


import com.demo.miniprogram.entity.Achievement;
import com.demo.miniprogram.service.AchievementService;
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
public class AchievementController {

    private static final Logger logger = LoggerFactory.getLogger(AchievementController.class);


    @Autowired
    private AchievementService achievementService;

    @RequestMapping(value = "/achievements",method = RequestMethod.GET)
    public Map<String,Object> getAchievements(HttpServletRequest request){
        Map<String,Object> model = new HashMap<>();
        String gameId = request.getParameter("gameId");
        if(gameId != null){
            try {
                List<Achievement> achievementList = achievementService.queryAchievementList(Integer.parseInt(gameId));
                model.put("achievementList",achievementList);
                model.put("msg","查询成就成功");
                logger.info("查询成就成功");
            }catch (Exception e){
                model.put("msg","gameId参数错误,查询成就失败,"+e.getMessage());
                logger.error("gameId参数错误,查询成就失败");
            }
        }else{
            model.put("msg","gameId为空，查询成就失败");
            logger.error("gameId为空，查询成就失败");
        }
        return model;
    }

}
