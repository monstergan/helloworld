package com.ssm.service;

import com.ssm.bean.TProvider;

import java.util.List;

public interface ProviderService {

    public List<TProvider> getProviders();

    /**
     * 新增
     * @param provider
     * @return
     */
    public int addProviders(TProvider provider);

    /**
     * 单删
     * @param id
     * @return
     */
    public int deleteProvider(int id);

    /**
     * 单个信息
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
     * @return
     */
    public List<TProvider> getpro();
}
