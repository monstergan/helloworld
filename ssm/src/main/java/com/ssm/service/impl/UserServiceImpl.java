package com.ssm.service.impl;

import com.ssm.bean.TUser;
import com.ssm.mapper.UserMapper;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    //业务逻辑层调用Mapper
    @Autowired
    UserMapper um;

    @Override
    public List<TUser> getUsers() {
        return um.getUsers();
    }


    @Override
    public int addUser(TUser user) {
        return um.addUser(user);
    }

    @Override
    public int deleteuser(int id) {
        return um.deleteuser(id);
    }

    @Override
    public TUser login(TUser user) {
        return um.login(user);
    }

    @Override
    public TUser getById(Integer id) {
        return um.getById(id);
    }

    @Override
    public int deleteSome(Integer[] ids) {
        return um.deleteSome(ids);
    }

    @Override
    public int updateUser(TUser user) {
        return um.updateUser(user);
    }

    @Override
    public List<TUser> getUsersById(Integer[] ids) {
        return um.getUsersById(ids);
    }
}
