package com.gdglc.mybatis.servlet.standard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gdglc.mybatis.bean.Standard;
import com.gdglc.mybatis.bean.StandardExample;
import com.gdglc.mybatis.bean.StandardExample.Criteria;
import com.gdglc.mybatis.utils.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 文件描述：处理查询操作的Servlet
 */
@WebServlet(urlPatterns = { "/standard/DoSelectServlet" }, name = "DoSelectServlet1")
public class DoSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 获取的是select里面的name的属性
		String zhname = (String) request.getParameter("zhname");


		/**
		 * 这样设置不行的，因为表单提交的不用转换。只能在tomcat里面设置了。 如何判断字符的编码格式？
		 */
		// if (null != petBreed) {
		// petBreed = new String(petBreed.getBytes("ISO8859-1"), "UTF-8");
		// }

		// 当前页数
		int currentPage = 1;
		//每页显示条数
		int rowPerPage=3;
		
		// 返回跳转到第几页(默认是第一页)
		String currentPageStr = request.getParameter("currentPage");

		if (null != currentPageStr && !"".equals(currentPageStr.trim())) {
			try {
				currentPage = Integer.parseInt(currentPageStr);
			} catch (Exception e) {
				e.printStackTrace();
				currentPage = 1;
			}
		}
		//分页对象
		PageHelper.startPage(currentPage,rowPerPage);			

		StandardExample example = new StandardExample();
		if (null != zhname && !"".equals(zhname)) {
			Criteria criteria = example.createCriteria();
			criteria.andZhnameLike("%"+ zhname +"%");		
		}
				
		List<Standard> standardList = new ArrayList<>();
		
		standardList = PublicDemo.getStandardService().selectByExample(example);
		
		//使用PageInfo对象可以得到分页的各项属性
		PageInfo<Standard> pageInfo = new PageInfo<>(standardList);	

		
		//转换日期的格式
		for (Standard standard : standardList) {			
			String releaseDate=Util.DateToString(standard.getReleaseDate());
			standard.setReleaseDate(Util.parseDate(releaseDate));
			String implDate=Util.DateToString(standard.getImplDate());
			standard.setReleaseDate(Util.parseDate(implDate));
					
		}

		request.setAttribute("standardList", standardList);
		request.setAttribute("pageInfo", pageInfo);
		

		// 在这里不要用重定向
		request.getRequestDispatcher("showList.jsp").forward(request, response);

	}

}
