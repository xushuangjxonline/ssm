package com.java.test.service.impl;

import com.java.test.dao.TestDao;
import com.java.test.entity.TestModel;
import com.java.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xushuang
 * @date 2020/7/8 - 20:50
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao testDao;

    @Override
    public List<TestModel> getAll() {
        return testDao.getAll();
    }
}
