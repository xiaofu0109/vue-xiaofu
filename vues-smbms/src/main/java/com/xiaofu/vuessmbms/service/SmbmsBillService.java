package com.xiaofu.vuessmbms.service;

import com.github.pagehelper.PageInfo;
import com.xiaofu.vuessmbms.pojo.SmbmsBill;

import java.util.List;

public interface SmbmsBillService {

    List<SmbmsBill> getList();

    PageInfo<SmbmsBill> getListBill(SmbmsBill bill, int pageindex, int pagesize);

    int updateBill(SmbmsBill bill);

    int addBill(SmbmsBill bill);
}
