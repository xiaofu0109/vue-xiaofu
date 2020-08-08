package com.xiaofu.vuessmbms.mapper;

import com.xiaofu.vuessmbms.pojo.SmbmsProvider;
import com.xiaofu.vuessmbms.pojo.SmbmsProviderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmbmsProviderMapper {
    long countByExample(SmbmsProviderExample example);

    int deleteByExample(SmbmsProviderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmbmsProvider record);

    int insertSelective(SmbmsProvider record);

    List<SmbmsProvider> selectByExample(SmbmsProviderExample example);

    SmbmsProvider selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmbmsProvider record, @Param("example") SmbmsProviderExample example);

    int updateByExample(@Param("record") SmbmsProvider record, @Param("example") SmbmsProviderExample example);

    int updateByPrimaryKeySelective(SmbmsProvider record);

    int updateByPrimaryKey(SmbmsProvider record);
}