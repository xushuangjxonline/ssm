package com.java.user.dao;

import com.java.user.entity.UserModel;
import org.apache.ibatis.annotations.Param;

/**
 * @author xushuang
 * @date 2020/7/9 - 16:03
 */

public interface UserDao {

    //根据username查询userModel
    UserModel selectUserModel(String username);

    //根据username 判断登录是否正确
    Integer  isAllowLogin(@Param("username")String username, @Param("password")String password);

    //根据原账号和原密码  修改密码
    void updateUserModelByUsername(@Param("username")String username,@Param("password")String password);

    //根据提示问题 判断答案是否正确
    Integer isUserAnswerRight(String username,String question);

    //找回密码前的判断 查询是否存在该账号
    Integer isHaveUsername(String username);

    //根据原账号和提示问题答案  修改密码
    void updateUserModelByquestionInfo(String username);

    //超管账号权限  添加新员工
    void insertUserModel(UserModel userModel);

    //根据username 删除普通员工账号
    void deleUserModelBy(String username);

    //普通员工 修改自己的密码提示
    void updateUserQuestion(UserModel userModel);

}
