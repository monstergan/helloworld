package com.ssm.service;

import com.ssm.bean.TUser;

import java.util.List;

public interface UserService {

    public List<TUser> getUsers();

    public int addUser(TUser user);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int deleteuser(int id);

    /**
     * 登录
     *
     * @param user
     * @return
     */
    public TUser login(TUser user);

    public TUser getById(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int deleteSome(Integer[] ids);

    public int updateUser(TUser user);

    List<TUser> getUsersById(Integer[] ids);
}
