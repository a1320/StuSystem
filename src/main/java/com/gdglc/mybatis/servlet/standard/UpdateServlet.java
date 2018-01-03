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


/**
 * 更新宠物
 */
@WebServlet(urlPatterns = { "/standard/UpdateServlet" }, name = "UpdateServlet1")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String path = request.getContextPath();				
		
		//获取请求参数
		String idStr = request.getParameter("id");
		//封装业务方法参数
		Integer id = Integer.parseInt(idStr);
		
		String stdNum = request.getParameter("stdNum");

		String zhname = request.getParameter("zhname");

		String version = request.getParameter("version");

		String keys = request.getParameter("keys");

		String releaseDateStr = request.getParameter("releaseDate");
		Date releaseDate = Util.parseDate(releaseDateStr);

		String implDateStr = request.getParameter("implDate");
		Date implDate = Util.parseDate(implDateStr);

		String packagePath = request.getParameter("packagePath");

		Standard standard = new Standard(id, stdNum, zhname, version, keys, releaseDate, implDate, packagePath);
		
		//更新宠物信息
		int result = PublicDemo.getStandardService().updateByPrimaryKeySelective(standard);
		
		HttpSession session = request.getSession();		
		if(result>0){
			session.setAttribute("message", "更新成功");
			response.sendRedirect(path+"/DoSelectServlet");
		}else{
			session.setAttribute("message", "更新失败");		
			//使用转发
			//request.getRequestDispatcher("update.jsp").forward(request, response);	
			
			response.sendRedirect(path+"/update.jsp?id="+id);
		}
	}

}
