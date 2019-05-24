package com.ssm.test;

import com.ssm.bean.TUser;
import com.ssm.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMybatis {

    @Autowired
    UserMapper um;

    @Test
    public void test1(){
        List<TUser> users = um.getUsers();
        for (TUser user : users) {
            System.out.println(user);
        }
    }
}
