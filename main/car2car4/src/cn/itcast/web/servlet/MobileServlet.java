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

public class MobileServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		df.format(new Date()).toString();
		String queryType=request.getParameter("queryType");
        String carid=request.getParameter("carid");
        String start_time_raw=request.getParameter("start_time");
        String end_time_raw=request.getParameter("end_time");
        String start_time=df.format(new Date()).toString()+" "+start_time_raw+":00";
        String end_time=df.format(new Date()).toString()+" "+end_time_raw+":00";
        
        //start_time.
		Enumeration e=request.getParameterNames();
		System.out.println(e.toString());
		for(Enumeration v=e;e.hasMoreElements();){
			System.out.println("-----------");
			System.out.println(v.nextElement());
		}
		System.out.println("queryType="+queryType);
		System.out.println("carid="+carid);
		System.out.println("start_time="+start_time);
		System.out.println("end_time="+end_time);
		//queryType的值如果为1，就返回全部车辆最新的位置信息
		//如果值为2，返回指定车牌号的车辆的最新位置
		//如果值为3，就返回一段时间指定车辆的全部信息
		if(queryType.equals("1")){
			DataDao ud=DaoFactory.getInstance().getDataDao();
			String json=ud.PrintAllDataMobile();
			System.out.println(json);
			out.write(json);
		}else if(queryType.equals("2")){
			DataDao ud=DaoFactory.getInstance().getDataDao();
			String json=ud.PrintGivenCarDataMobile(carid);
			//String json1=json.substring(1, json.length()-1);
			System.out.println(json);
			out.write(json);
		}else{
			DataDao ud=DaoFactory.getInstance().getDataDao();
			String json=ud.PrintTraceMobile(start_time, end_time, carid);
			System.out.println(json);
			out.write(json);
		}
	}

}
