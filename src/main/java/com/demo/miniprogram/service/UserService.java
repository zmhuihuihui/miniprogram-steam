package com.demo.miniprogram.service;

import com.demo.miniprogram.entity.User;

public interface UserService {

    void insertUser(User user);
    String queryPassword(String username);
}
