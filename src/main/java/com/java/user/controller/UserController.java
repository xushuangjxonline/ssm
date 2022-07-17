package com.java.user.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.java.common.base.bean.Message;
import com.java.user.entity.UserModel;
import com.java.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author xushuang
 * @date 2020/7/9 - 16:03
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //跳转登录页面的方法
    @RequestMapping(value = "/homePage",method = RequestMethod.GET)
    public String homePage(){
        return "user/homePage";
    }

    //登陆的方法
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    @ResponseBody
    public Message doLogin(@RequestBody Object param,
                                HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse){
        UserModel userModel = new UserModel();
        String v = JSON.toJSONString(param);
        JSONObject jsonObject = JSONObject.parseObject(v);
        if(userService.isAllowLogin(jsonObject.getString("username").trim(),
                jsonObject.getString("password").trim())>0){
            userModel = userService.selectUserModel(jsonObject.getString("username").trim());
            httpServletRequest.getSession().setAttribute("userModel",userModel);
            return Message.success().add("isAllow",1);
        }else {
            return Message.success().add("isAllow",0);
        }
    }

    //跳转登陆页面
    @RequestMapping(value="/jumpMainPage",method = RequestMethod.GET)
    public String jumpMainPage(){
        return "main/list";
    }

    //跳转找回密码的页面,输入账号的页面
    @RequestMapping(value = "/jumpFindPassword",method = RequestMethod.GET)
    public String jumpFindPassword(){
        return "user/checkUsername";
    }

    //查找输入的账号是否存在的方法
    @RequestMapping(value = "/isHaveUsername",method = RequestMethod.GET)
    @ResponseBody
    public Message isHaveUsername(String username){
        return Message.success().add("username",userService.isHaveUsername(username));
    }

    //跳转回答账号提示的页面
    @RequestMapping(value = "/jumpAnswerPage",method = RequestMethod.GET)
    public ModelAndView jumpAnswerPage(String username){
        UserModel userModel = new UserModel();
        ModelAndView modelAndView = new ModelAndView();
        //查询该username的bean 返回给页面
        userModel = userService.selectUserModel(username);
        modelAndView.addObject("userModel",userModel);
        modelAndView.setViewName("user/answerPage");
        return modelAndView;
    }

    @RequestMapping(value = "/jumpUpdatePassword",method = RequestMethod.GET)
    public ModelAndView jumpUpdatePassword(String username){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username",username);
        modelAndView.setViewName("user/updatePasswordPage");
        return modelAndView;
    }

    @RequestMapping(value = "/doPasswordUpdate",method = RequestMethod.POST)
    @ResponseBody
    public Message doUpdate(@RequestBody Object param){
        String sb = JSON.toJSONString(param);
        JSONObject jsonObject = JSONObject.parseObject(sb);
        userService.updatePasswordByUsername(jsonObject.getString("username"),jsonObject.getString("password"));
        return Message.success();
    }


}
