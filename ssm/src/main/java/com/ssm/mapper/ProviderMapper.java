package com.ssm.mapper;

import com.ssm.bean.TProvider;

import java.util.List;

public interface ProviderMapper {

    /**
     * 全局查询
     * @return
     */
    public List<TProvider> getProviders();

    /**
     * 新增
     * @param provider
     * @return
     */
    public int addProviders(TProvider provider);

    /**
     * 单个删除
     * @param id
     * @return
     */
    public int deleteProvider(int id);

    /**
     * 个人信息
     * @param pid
     * @return
     */
    public TProvider getById(Integer pid);

    /**
     * 更新信息
     * @param provider
     * @return
     */
    public int updateProvider(TProvider provider);

    /**
     * 下拉框
     */
    public List<TProvider> getpor();
}
