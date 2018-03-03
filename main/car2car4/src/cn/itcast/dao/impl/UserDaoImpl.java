package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;
import net.sf.json.JSONObject;
import cn.itcast.dao.UserDao;
import cn.itcast.entity.UserInfo;
import cn.itcast.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
	/*
	 * 查询用户等级
	 */
	@Override
	public JSONObject getGrade(String username, String password) {
		Connection con=JdbcUtils.getConnection();
		JSONObject jsondata = new JSONObject();
		try {
			String sql="SELECT * FROM usr where username='"+username+"'";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name=rs.getString(1);
		    	String pass=rs.getString(2);
		    	String grade=rs.getString(3);
		    	String devId=rs.getString(4);
		    	System.out.println("this is grade"+grade);
		    	System.out.println("this is devId"+devId);
		    	jsondata.put("grade", grade);
	        	jsondata.put("devId", devId);
		        if ( username.equals(name)&&password.equals(pass)){
		        	return jsondata;
		        }else{	
		        	return jsondata;
		        }
			}
		    } catch (SQLException e) {
						e.printStackTrace();
		    }finally{
			      JdbcUtils.closeConnection(con);
		    }
    	return jsondata;
	}
	/*
	 * 得到全部用户的信息
	 */
	@Override
	public String getUserInfo() {
		Gson gson=new Gson();
		List<UserInfo> list_data_info=new LinkedList<UserInfo>();
		Connection con=JdbcUtils.getConnection();
		try {
			String sql=" SELECT * from usr";
			PreparedStatement pstmt=con.prepareStatement(sql);			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String username=rs.getString(1);
				String password=rs.getString(2);
				String grade=rs.getString(3);
				String devId=rs.getString(4);
				UserInfo ui=new UserInfo(username,password,grade,devId);
	            list_data_info.add(ui);  	
			}
			return gson.toJson(list_data_info);
		
		    } catch (SQLException e) {
						e.printStackTrace();
		    }finally{
			      JdbcUtils.closeConnection(con);
		    }
		return gson.toJson(list_data_info);
	}
	/*
	 * 查找某用户的信息
	 */
	@Override
	public String searchUserInfo(String username) {
		Gson gson=new Gson();
		List<UserInfo> list_data_info=new LinkedList<UserInfo>();
		Connection con=JdbcUtils.getConnection();
		try {
			String sql=" SELECT * from usr where username='"+username+"'";
			PreparedStatement pstmt=con.prepareStatement(sql);			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				username=rs.getString(1);
				String password=rs.getString(2);
				String grade=rs.getString(3);
				String devId=rs.getString(4);
				UserInfo ui=new UserInfo(username,password,grade,devId);
	            list_data_info.add(ui);  	
			}
			return gson.toJson(list_data_info);
		
		    } catch (SQLException e) {
						e.printStackTrace();
		    }finally{
			      JdbcUtils.closeConnection(con);
		    }
		return gson.toJson(list_data_info);
	}
	/*
	 * 删除一组用户信息
	 */
	@Override
	public void deleteUserInfo(String[] usernames) {
		Connection con=JdbcUtils.getConnection();
		try {
			for(String un: usernames){
				String sql="delete FROM usr where username='"+un+"'";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.executeUpdate();
			}
	    } catch (SQLException e) {
					e.printStackTrace();
	    } finally{
		      JdbcUtils.closeConnection(con);
	    }
	}
	/*
	 * 插入一组用户信息
	 */
	@Override
	public void insertUserInfo(ArrayList<ArrayList<String>> results) {
		Connection con=JdbcUtils.getConnection();
		String username;
		String password;
		String devId;
		String grade;
		try {
			for(ArrayList<String> row:results){
				username=row.get(0);
				password=row.get(1);
				devId=row.get(2);
				grade=row.get(3);
				String sql=" INSERT INTO usr VALUES('"+ username+"','"+ password+"','"+ grade+"','"+devId +"')";
				PreparedStatement pstmt;
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
