package com.xiaofu.vuessmbms.mapper;

import com.xiaofu.vuessmbms.pojo.SmbmsAddress;
import com.xiaofu.vuessmbms.pojo.SmbmsAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmbmsAddressMapper {
    long countByExample(SmbmsAddressExample example);

    int deleteByExample(SmbmsAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmbmsAddress record);

    int insertSelective(SmbmsAddress record);

    List<SmbmsAddress> selectByExample(SmbmsAddressExample example);

    SmbmsAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmbmsAddress record, @Param("example") SmbmsAddressExample example);

    int updateByExample(@Param("record") SmbmsAddress record, @Param("example") SmbmsAddressExample example);

    int updateByPrimaryKeySelective(SmbmsAddress record);

    int updateByPrimaryKey(SmbmsAddress record);


    //测试
    List<SmbmsAddress> queryTest(@Param("aa") String aa, @Param("bb") String bb);
}