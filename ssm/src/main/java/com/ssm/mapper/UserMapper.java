package com.ssm.mapper;

import com.ssm.bean.TUser;

import java.util.List;

public interface UserMapper {

    /**
     * 查询所有
     * @return
     */
    public List<TUser> getUsers();

    /**
     * 新增
     * @param user
     * @return
     */
    public int addUser(TUser user);

    /**
     * 删除
     * @param id
     * @return
     */
    public int deleteuser(int id);

    /**
     * 登录
     * @param user
     * @return
     */
    public TUser login(TUser user);

    /**
     * 个人信息
     * @param id
     * @return
     */
    public TUser getById(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int deleteSome(Integer[] ids);

    /**
     * 更新
     * @param user
     * @return
     */
    public int updateUser(TUser user);

    List<TUser> getUsersById(Integer[] ids);
}
