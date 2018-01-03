package com.gdglc.mybatis.servlet.standard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 文件描述：处理删除多个对象
 */
@WebServlet(urlPatterns = { "/standard/DoDeleteServlet" }, name = "DoDeleteServlet1")
public class DoDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		String[] idStrs = request.getParameterValues("del");
		System.out.println("\n\n"+idStrs+"idStrs-----------------------------");
		Integer[] ids = null;
		if (idStrs != null && idStrs.length > 0) {
			ids = new Integer[idStrs.length];
			for (int i = 0; i < idStrs.length; i++) {
				ids[i] = Integer.parseInt(idStrs[i]);
			}
		}

		// 一次性删除多条数据的方法

		int success = 0;

		if (ids != null) {
			for (Integer id : ids) {
				if (id != null) {					
					success = PublicDemo.getStandardService().deleteByPrimaryKey(id);
				}
			}
		}

		HttpSession session = request.getSession();
		String path = request.getContextPath();
		
		if (success > 0) {
			session.setAttribute("message", "删除成功");
			response.sendRedirect(path + "/standard/DoSelectServlet");
		} else {
			session.setAttribute("message", "删除失败");
			response.sendRedirect(path + "/standard/add.jsp");
		}

		out.flush();
		out.close();
	}

}
