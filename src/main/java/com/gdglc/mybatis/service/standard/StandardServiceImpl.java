package com.gdglc.mybatis.service.standard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gdglc.mybatis.bean.Standard;
import com.gdglc.mybatis.bean.StandardExample;
import com.gdglc.mybatis.dao.StandardMapper;

@Transactional
@Service("StandardService")
public class StandardServiceImpl implements StandardService {
	
	/**
	 * 接口对象
	 */
	@Autowired
	private StandardMapper standardMapper;

	@Override
	public int deleteByExample(StandardExample example) {
		try {
			return standardMapper.deleteByExample(example);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		try {
			return standardMapper.deleteByPrimaryKey(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int insert(Standard record) {
		try {
			return standardMapper.insert(record);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Standard> selectByExample(StandardExample example) {
		try {
			return standardMapper.selectByExample(example);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Standard selectByPrimaryKey(Integer id) {
		try {
			return standardMapper.selectByPrimaryKey(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int updateByPrimaryKeySelective(Standard record) {
		try {
			return standardMapper.updateByPrimaryKeySelective(record);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
