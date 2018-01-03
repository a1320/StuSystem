package com.gdglc.mybatis.dao;

import com.gdglc.mybatis.bean.Standard;
import com.gdglc.mybatis.bean.StandardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StandardMapper {
    long countByExample(StandardExample example);

    int deleteByExample(StandardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Standard record);

    int insertSelective(Standard record);

    List<Standard> selectByExample(StandardExample example);

    Standard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Standard record, @Param("example") StandardExample example);

    int updateByExample(@Param("record") Standard record, @Param("example") StandardExample example);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
}