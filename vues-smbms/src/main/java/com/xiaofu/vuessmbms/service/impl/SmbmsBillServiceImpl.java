package com.xiaofu.vuessmbms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaofu.vuessmbms.mapper.SmbmsBillMapper;
import com.xiaofu.vuessmbms.mapper.SmbmsUserMapper;
import com.xiaofu.vuessmbms.pojo.SmbmsBill;
import com.xiaofu.vuessmbms.service.SmbmsBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SmbmsBillServiceImpl implements SmbmsBillService {
    @Autowired
    private SmbmsBillMapper billMapper;
    @Override
    public List<SmbmsBill> getList() {
        return billMapper.getList();
    }

    @Override
    public PageInfo<SmbmsBill> getListBill(SmbmsBill bill, int pageindex, int pagesize) {
        PageHelper.startPage(pageindex,pagesize);
        List<SmbmsBill> list = billMapper.getListBill(bill);
        PageInfo<SmbmsBill> pageInfo = new PageInfo<SmbmsBill>(list);
        return pageInfo;
    }


    @Override
    public int updateBill(SmbmsBill bill) {
        bill.setModifyby(20L);
        bill.setModifydate(new Date());
        return billMapper.updateBill(bill);
    }

    @Override
    public int addBill(SmbmsBill bill) {
        bill.setProductdesc(bill.getProductname());
        bill.setCreatedby(1L);
        bill.setCreationdate(new Date());
        return billMapper.insert(bill);
    }
}
