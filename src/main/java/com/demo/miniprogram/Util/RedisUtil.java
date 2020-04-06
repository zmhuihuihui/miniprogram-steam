package com.demo.miniprogram.Util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Scope("singleton")
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,String> template;

    /********* String *********/


    //读取string缓存
    public String get(final String key){
        return template.opsForValue().get(key);
    }

    //存入string缓存
    public Boolean set(final String key,String value){
        boolean result = false;
        try {
            template.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    //更新string缓存
    public boolean update(final String key, String value) {
        boolean result = false;
        try {
            template.opsForValue().getAndSet(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //删除缓存
    public boolean delete(final String key) {
        boolean result = false;
        try {
            template.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //存活时间
    public boolean expire(String key,long time){
        try {
            if(time>0){
                template.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //获取过期时间
    public long getExpire(String key){
        return template.getExpire(key,TimeUnit.SECONDS);
    }

    //判断key是否存在
    public boolean hasKey(String key){
        try {
            return template.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /******** List *******/


    //获取list缓存的内容
    public List<String> lGet(String key, long start, long end){
        try {
            return template.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //获取list缓存的长度
    public long lGetListSize(String key){
        try {
            return template.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //通过索引 获取list中的值
    public Object lGetIndex(String key,long index){
        try {
            return template.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //将list放入缓存
    public boolean lSet(String key, String value) {
        try {
            template.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //根据索引修改list中的某条数据
    public boolean lUpdateIndex(String key, long index,String value) {
        try {
            template.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
