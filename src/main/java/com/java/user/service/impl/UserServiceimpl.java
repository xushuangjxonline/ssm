package com.java.user.service.impl;

import com.java.user.dao.UserDao;
import com.java.user.entity.UserModel;
import com.java.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xushuang
 * @date 2020/7/9 - 16:04
 */
@Service
public class UserServiceimpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Integer isAllowLogin(String username, String password) {
        return userDao.isAllowLogin(username,password);
    }

    @Override
    public Integer isHaveUsername(String username) {
        return userDao.isHaveUsername(username);
    }

    @Override
    public UserModel selectUserModel(String username) {
        return userDao.selectUserModel(username);
    }

    @Override
    public void updatePasswordByUsername(String username, String password) {
        userDao.updateUserModelByUsername(username,password);
    }
}
