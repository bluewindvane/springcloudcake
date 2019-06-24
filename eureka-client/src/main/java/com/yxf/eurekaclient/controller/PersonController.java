package com.yxf.eurekaclient.controller;


import com.alibaba.fastjson.JSON;
import com.yxf.eurekaclient.entity.Person;
import com.yxf.eurekaclient.mapper.db2.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yxf
 * @since 2019-06-21
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/getPersonList")
    public String getPersonList() {
        String result = null;

        List<Person> personList = personMapper.getAll();

        result = JSON.toJSONString(personList);

        return result;
    }
}
