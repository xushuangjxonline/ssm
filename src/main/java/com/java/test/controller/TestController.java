package com.java.test.controller;

import com.java.test.entity.TestModel;
import com.java.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xushuang
 * @date 2020/7/8 - 15:43
 */

@Controller
@RequestMapping("/test")
public class TestController {

    System.out.print("hello");
    System.out.print("hello123");


    @Autowired
    TestService testService;

    @RequestMapping
    @ResponseBody
    public Map<String,Object> test(){
        Map<String,Object> map = new HashMap<String, Object>();
        List<TestModel> list = testService.getAll();
        map.put("code",200);
        map.put("massgae","成功");
        map.put("testList",list);
        return map;
    }

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "user/index";

    }

}
