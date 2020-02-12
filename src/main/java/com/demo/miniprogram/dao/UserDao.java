package com.demo.miniprogram.dao;

import com.demo.miniprogram.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    void insertUser(@Param("user") User user);
    String queryPasswordByName(@Param("username") String username);

}
