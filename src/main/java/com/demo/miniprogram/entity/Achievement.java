package com.demo.miniprogram.entity;

import java.io.Serializable;

public class Achievement implements Serializable {
    private Integer achievementId;   //主键
    private String achievementName;  //成就名字
    private String imageUrl;         //成就图片
    private String profile;          //成就详情
    private float getPercent;      //成就完成百分比（百分制）
    private Game game;    //成就所属游戏（数据库存gameId ，外键）


    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public float getGetPercent() {
        return getPercent;
    }

    public void setGetPercent(float getPercent) {
        this.getPercent = getPercent;
    }
}
