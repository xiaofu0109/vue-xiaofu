package com.xiaofu.vuessmbms.service.impl;

import com.xiaofu.vuessmbms.mapper.SmbmsRoleMapper;
import com.xiaofu.vuessmbms.pojo.SmbmsRole;
import com.xiaofu.vuessmbms.pojo.SmbmsRoleExample;
import com.xiaofu.vuessmbms.service.SmbmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmbmsRoleServiceImpl implements SmbmsRoleService {

    @Autowired
    private SmbmsRoleMapper roleMapper;

    @Override
    public List<SmbmsRole> getList() {
        return roleMapper.selectByExample(new SmbmsRoleExample());
    }
}
