package com.demo.miniprogram.service.Impl;

import com.demo.miniprogram.dao.UserDao;
import com.demo.miniprogram.entity.User;
import com.demo.miniprogram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public String queryPassword(String username) {
        return userDao.queryPasswordByName(username);
    }
}
