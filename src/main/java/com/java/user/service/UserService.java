package com.java.user.service;

import com.java.user.entity.UserModel;

/**
 * @author xushuang
 * @date 2020/7/9 - 16:04
 */
public interface UserService {

    //判断登陆的方法
    Integer isAllowLogin(String username,String password);

    //找回密码前的判断 查询是否存在该账号
    Integer isHaveUsername(String username);

    //查询userModel
    UserModel selectUserModel(String username);

    //根据账号修改密码
    void updatePasswordByUsername(String username,String password);
}
