package com.gdglc.mybatis.service.standard;

import java.util.List;
import com.gdglc.mybatis.bean.Standard;
import com.gdglc.mybatis.bean.StandardExample;

public interface StandardService {
	
	/**
	 * 按对象删除
	 */
    public int deleteByExample(StandardExample example);

    /**
	 * 按ID删除
	 */
    public int deleteByPrimaryKey(Integer id);

    /**
	 * 插入对象
	 */
    public int insert(Standard record);

    /**
	 * 按条件查询对象集合
	 */
    public List<Standard> selectByExample(StandardExample example);

    /**
	 * 按ID查询一个对象
	 */
    public Standard selectByPrimaryKey(Integer id);

    /**
	 * 更新一个对象
	 */
    public int updateByPrimaryKeySelective(Standard record);

   

}
