package com.demo.miniprogram.entity;


import java.util.Date;

public class Game {
    private Integer gameId;     //游戏id(主键)
    private String name;        //游戏名字
    private Integer price;      //游戏现价
    private Integer oldprice;   //游戏原价
    private Integer discount;   //游戏折扣（百分制，例如80%off）
    private Integer lowestPrice; //史低价格
    private Integer score;      //游戏评分
    private Integer priority;   //游戏热度(人数)
    private String imageUrl;    //游戏图片
    private String logoUrl;     //游戏logo
    private String introduction;     //游戏简介
    private String tag;         //游戏类型
    private Date releaseDate;   //发售时间

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOldprice() {
        return oldprice;
    }

    public void setOldprice(Integer oldprice) {
        this.oldprice = oldprice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }


    public Integer getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Integer lowestPrice) {
        this.lowestPrice = lowestPrice;
    }
}
