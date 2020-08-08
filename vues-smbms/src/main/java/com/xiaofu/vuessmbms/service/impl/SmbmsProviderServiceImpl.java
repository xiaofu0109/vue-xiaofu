package com.xiaofu.vuessmbms.service.impl;

import com.xiaofu.vuessmbms.mapper.SmbmsProviderMapper;
import com.xiaofu.vuessmbms.pojo.SmbmsProvider;
import com.xiaofu.vuessmbms.pojo.SmbmsProviderExample;
import com.xiaofu.vuessmbms.service.SmbmsProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmbmsProviderServiceImpl implements SmbmsProviderService {

    @Autowired
    private SmbmsProviderMapper providerMapper;

    @Override
    public List<SmbmsProvider> getList() {
        return providerMapper.selectByExample(new SmbmsProviderExample());
    }
}
