package com.gdglc.mybatis.utils;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;

public class Util {
	
	/**
	 * 返回指定格式的字符串
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String StringConvert(String str) throws Exception {
		return new String(str.getBytes("ISO8859-1"), "UTF-8");
		// GBK GB2312 GB18030 Big5 utf-8
	}

	/**
	 * 将日期格式转化为字符串
	 * 
	 * @param date
	 * @return date
	 */
	public static String DateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 将字符串转化为日期格式
	 * 
	 * @param str
	 * @return str
	 * @throws Exception
	 */
	public static Date parseDate(String dateStr){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date parse = format.parse(dateStr);
			Date date = new Date(parse.getTime());
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 返回当天日期
	 */
	public static String getDateTime() {
		String nowTime=null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			nowTime = format.format(new java.util.Date()).toString();
			return nowTime;
		} catch (Exception e) {
			e.printStackTrace();
			return nowTime;
		}		
	}

}
