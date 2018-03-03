package cn.itcast.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	   private static Properties props=null;
	   static{
		   props=new Properties();
		   try {
			props.load(JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
		   } catch (IOException e) {	
			e.printStackTrace();
		   }
		   
		   try {
			Class.forName(props.getProperty("driverClassName"));
		   } catch (ClassNotFoundException e) {
			e.printStackTrace();
		   }
	   }
       public static Connection getConnection(){
    	   String url=props.getProperty("url_new");
    	   String username=props.getProperty("username");
    	   String password=props.getProperty("password");
    	   
    	   try {
    		   return DriverManager.getConnection(url, username, password);
		   } catch (SQLException e) {	
			   e.printStackTrace();
		   }
    	   
    	   return null;
       }
       
       public static void closeConnection(Connection con){
    	   try {
			    con.close();
		   } catch (SQLException e) {
			    e.printStackTrace();
		   }
       }
}
