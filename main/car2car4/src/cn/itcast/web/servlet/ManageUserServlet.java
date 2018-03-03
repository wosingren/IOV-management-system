package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.dao.UserDao;
import cn.itcast.factory.DaoFactory;
import net.sf.json.JSONObject;


public class ManageUserServlet extends HttpServlet { 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpServletRequest hrequest=(HttpServletRequest)request;
//		HttpSession session = hrequest.getSession();
		
		Enumeration e=request.getParameterNames();
		for(Enumeration v=e;e.hasMoreElements();){
			System.out.println("-----------");
			System.out.println(v.nextElement());
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String jsondata ;
		String searchUserInformation;
		String item=request.getParameter("item");
		String[] delId=request.getParameterValues("delId[]");
		System.out.println("item="+item);
		String username=request.getParameter("username");
		System.out.println("username="+username);
			
		UserDao ud=DaoFactory.getInstance().getUserDao();
		
		//select all the usrInfo in database named usr
		if(item.equals("1")){
			jsondata=ud.getUserInfo();
			out.write(jsondata.toString());
		}
		
		//delete the select username in database named usr
		if(delId!=null && item.equals("3")){
			for(int i=0;i<delId.length;i++)
				System.out.println("delId="+delId[i]);
			//ud.deleteUserInfo(delId);
		}
		//search the Info of the username
		if(username!=null && item.equals("2")){
			searchUserInformation=ud.searchUserInfo(username);
			//if the search result is null
//			if(searchUserInformation==null){
//				String warnword="there is no sach a user named "+ username;
//				out.write(warnword);
//			}
			out.write(searchUserInformation.toString());
		}
	}
}
