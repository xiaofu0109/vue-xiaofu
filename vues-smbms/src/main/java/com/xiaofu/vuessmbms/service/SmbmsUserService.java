package com.xiaofu.vuessmbms.service;

import com.github.pagehelper.PageInfo;
import com.xiaofu.vuessmbms.pojo.SmbmsUser;

import java.util.List;

public interface SmbmsUserService {

    List<SmbmsUser> getLogin(SmbmsUser smbmsUser);

    PageInfo<SmbmsUser> getList(SmbmsUser user, int pageindex, int pagesize);

}
