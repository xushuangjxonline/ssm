package com.java.test.dao;

import com.java.test.entity.TestModel;

import java.util.List;

/**
 * @author xushuang
 * @date 2020/7/8 - 15:43
 */
public interface TestDao {

    /* 测试 获得表所有信息*/
    List<TestModel> getAll();
}
