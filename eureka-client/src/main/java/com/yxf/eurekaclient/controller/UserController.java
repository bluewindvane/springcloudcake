package com.yxf.eurekaclient.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.netflix.discovery.converters.Auto;
import com.yxf.eurekaclient.entity.User;
import com.yxf.eurekaclient.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yxf
 * @since 2019-06-20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getUserList")
    public String getUserList() {
        String result = null;
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss SSS");
        System.out.println(df.format(new Date()));
        List<User> users = userMapper.getUserListWithPage(0,100000);
        System.out.println(df.format(new Date()));

        result = JSON.toJSONString(users);
        System.out.println(df.format(new Date()));
        return result;
    }

    @PostMapping("/insertUserInfoWithTest")
    public void insertUserInfoWithTest(Integer a) {
        for (int i = 0; i < a; i++) {
            User user = new User();
            user.setAge(new Random().nextInt(100));
            user.setName(UUID.randomUUID().toString());
            user.setRemark(String.valueOf(System.currentTimeMillis()));
            user.setSex(String.valueOf(new Random().nextInt(2)));
            Integer insertCount = userMapper.insert(user);
            System.out.println(i);
        }
    }



}


