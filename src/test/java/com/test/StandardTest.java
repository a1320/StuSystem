package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.gdglc.mybatis.bean.Standard;
import com.gdglc.mybatis.bean.StandardExample;
import com.gdglc.mybatis.bean.StandardExample.Criteria;
import com.gdglc.mybatis.dao.StandardMapper;
import com.gdglc.mybatis.servlet.standard.PublicDemo;

public class StandardTest {
	
	
	/**
	 * 查询所有信息
	 */
	@Test
	public void testMyBatis() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config2.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		System.out.println(openSession);
		try {
			StandardMapper mapper = openSession.getMapper(com.gdglc.mybatis.dao.StandardMapper.class);
			List<Standard> list = mapper.selectByExample(null);
			for (Standard standard : list) {
				System.out.println("id:" + standard.getId() + "\t" + "名称：" + standard.getZhname()+standard.getVersion()+standard.getKeys());
			}
		} finally {
			openSession.close();
		}
	}
	
	/**
	 * 测试Standard
	 */
	@Test
	public void StandardTest() {

		StandardExample example = new StandardExample();		
		Criteria criteria = example.createCriteria();
		criteria.andZhnameLike("%玩具%");
		

		List<Standard> standardList = new ArrayList<>();

		standardList = PublicDemo.getStandardService().selectByExample(example);
		
		for (Standard standard : standardList) {
			System.out.println("------------"+standard.getZhname());
			
		}

		
	}


}
