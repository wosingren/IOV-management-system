package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.itcast.dao.DataDao;
import cn.itcast.factory.DaoFactory;

public class WebServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int flag =1;
		out.write(flag);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		df.format(new Date()).toString();
		Enumeration e=request.getParameterNames();
		System.out.println(e.toString());
		for(Enumeration v=e;e.hasMoreElements();){
			System.out.println("-----------");
			System.out.println(v.nextElement());
		}
		
		String time1_row=request.getParameter("timestart");
		String time2_row=request.getParameter("timeend");
		System.out.println(time1_row);
		System.out.println(time2_row);
		String time1=df.format(new Date()).toString()+" "+time1_row+":00";
        String time2=df.format(new Date()).toString()+" "+time2_row+":00";
        System.out.println(time1);
		System.out.println(time2);
		
		DataDao ud=DaoFactory.getInstance().getDataDao();
		String json=ud.PrintAllData(time1,time2);
		System.out.println(json);
		
		out.write(json);		
		
	}

}