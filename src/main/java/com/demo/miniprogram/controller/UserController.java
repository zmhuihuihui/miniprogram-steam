package com.demo.miniprogram.controller;


import com.demo.miniprogram.entity.User;
import com.demo.miniprogram.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/info")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map<String,Object> registerUser(@RequestBody User user){
        Map<String,Object> model = new HashMap<>();
        if(user.getUsername() !=null && user.getPassword() !=null){
            try{
                if(userService.queryPassword(user.getUsername()) == null) {
                    userService.insertUser(user);
                    model.put("success", true);
                    model.put("msg", "注册成功");
                    logger.info("注册成功");
                }else{
                    model.put("success", false);
                    model.put("msg", "该用户名已被注册");
                    logger.info("该用户名已被注册");
                }
            }catch (Exception e){
                model.put("success",false);
                model.put("msg","注册失败,"+e.getMessage());
                logger.error("注册失败");
            }

        }else {
            model.put("success",false);
            model.put("msg","用户名或密码不能为空");
            logger.info("用户名或密码不能为空");
        }
        return model;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(@RequestBody User user){
        Map<String,Object> model = new HashMap<>();
        if(user.getUsername() != null && user.getPassword()!=null){
            try {
                String password = userService.queryPassword(user.getUsername());
                if (password != null && password.equals(user.getPassword())) {
                    model.put("success", true);
                    model.put("msg", "登陆成功");
                    logger.info("登陆成功");
                } else {
                    model.put("success", false);
                    model.put("msg", "用户名或密码错误");
                    logger.info("用户名或密码错误");
                }
            }catch (Exception e){
                model.put("success",false);
                model.put("msg","登陆失败,"+e.getMessage());
                logger.error("登陆失败");
            }

        }else{
            model.put("success",false);
            model.put("msg","用户名或密码不能为空");
            logger.info("用户名或密码不能为空");
        }
        return model;
    }

}
