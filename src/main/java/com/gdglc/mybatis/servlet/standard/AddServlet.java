package com.gdglc.mybatis.servlet.standard;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gdglc.mybatis.bean.Standard;
import com.gdglc.mybatis.utils.Util;


@WebServlet(urlPatterns = { "/standard/AddServlet"}, name = "AddServlet1")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String path = request.getContextPath();

		//标准号
		String stdNum = request.getParameter("stdNum");

		//中文名称
		String zhname = request.getParameter("zhname");

		//版本
		String version = request.getParameter("version");

		//关键字
		String keys = request.getParameter("keys");
		String releaseDateStr = request.getParameter("releaseDate");
		Date releaseDate = Util.parseDate(releaseDateStr);

		//发布日期
		String implDateStr = request.getParameter("implDate");
		Date implDate = Util.parseDate(implDateStr);

		//实施日期
		String packagePath = request.getParameter("packagePath");
		packagePath="d:/stusystem";

		Standard standard = new Standard(null, stdNum, zhname, version, keys, releaseDate, implDate, packagePath);

		// 增加标准
		System.out.println(standard +"-------------------------------------------");
		
		
		int result = PublicDemo.getStandardService().insert(standard);

		HttpSession session = request.getSession();
		
		if (result > 0) {
			session.setAttribute("message", "添加成功");
			response.sendRedirect(path + "/standard/DoSelectServlet");
		} else {
			session.setAttribute("message", "添加失败");
			response.sendRedirect(path + "/standard/add.jsp");
		}
		
	}

}
