package com.gdglc.mybatis.servlet.standard;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gdglc.mybatis.service.standard.StandardService;


public class PublicDemo {
	
	public  static StandardService  getStandardService() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
		// providerService是业务类供应商接口
		StandardService petService = (StandardService) ctx.getBean("StandardService");
		return petService;
	}

}
