package com.xiaofu.vuessmbms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaofu.vuessmbms.mapper.SmbmsUserMapper;
import com.xiaofu.vuessmbms.pojo.SmbmsUser;
import com.xiaofu.vuessmbms.pojo.SmbmsUserExample;
import com.xiaofu.vuessmbms.service.SmbmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SmbmsUserServiceImpl implements SmbmsUserService {

    @Autowired
    private SmbmsUserMapper userMapper;

    @Override
    public List<SmbmsUser> getLogin(SmbmsUser smbmsUser) {
        SmbmsUserExample example = new SmbmsUserExample();
        example.createCriteria().andUsercodeEqualTo(smbmsUser.getUsercode())
                .andUserpasswordEqualTo(smbmsUser.getUserpassword());
        return userMapper.selectByExample(example);
    }

    @Override
    public PageInfo<SmbmsUser> getList(SmbmsUser user, int pageindex, int pagesize) {
        PageHelper.startPage(pageindex,pagesize);
        List<SmbmsUser> list = userMapper.getList(user);
        return new PageInfo<SmbmsUser>(list);
    }

    @Override
    public int addUser(SmbmsUser user) {
        user.setCreatedby(1L);
        user.setCreationdate(new Date());
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(SmbmsUser user) {
        user.setModifyby(1L);
        user.setModifydate(new Date());
        return userMapper.updateUser(user);
    }
}
