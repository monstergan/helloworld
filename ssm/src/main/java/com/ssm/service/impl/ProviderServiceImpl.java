package com.ssm.service.impl;

import com.ssm.bean.TProvider;
import com.ssm.mapper.ProviderMapper;
import com.ssm.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    ProviderMapper pm;

    @Override
    public List<TProvider> getProviders() {
        return pm.getProviders();
    }

    @Override
    public int addProviders(TProvider provider) {
        return pm.addProviders(provider);
    }

    @Override
    public int deleteProvider(int id) {
        return pm.deleteProvider(id);
    }

    @Override
    public TProvider getById(Integer pid) {
        return pm.getById(pid);
    }

    @Override
    public int updateProvider(TProvider provider) {
        return pm.updateProvider(provider);
    }

    @Override
    public List<TProvider> getpro() {
        return pm.getpor();
    }
}
