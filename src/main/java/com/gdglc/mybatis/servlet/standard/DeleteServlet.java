package com.gdglc.mybatis.servlet.standard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 删除一个对象
 */
@WebServlet(urlPatterns = { "/standard/DeleteServlet" }, name = "DeleteServlet1")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
		//设置编码格式，解决post的乱码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取请求参数
		String idStr = request.getParameter("id");
		//封装业务方法参数
		Integer id = Integer.parseInt(idStr);
		
		System.out.println(id);	
		
		try {
			
			PublicDemo.getStandardService().deleteByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		//根据调用结果确定跳转页面（页面的地址＋跳转的方式）
		response.sendRedirect(path + "/DoSelectServlet");
	}

}
