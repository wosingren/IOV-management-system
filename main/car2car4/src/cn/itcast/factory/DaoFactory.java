package cn.itcast.factory;

import java.io.IOException;
import java.util.Properties;

import cn.itcast.dao.DataDao;
import cn.itcast.dao.UserDao;

public class DaoFactory {
	    private static DataDao dataDao=null;
	    private static UserDao userDao=null;
	    private static DaoFactory instance=new DaoFactory();
	    private DaoFactory(){
	    	try {
	    	    Properties props=new Properties();    	
				props.load(DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties"));
				
				String dataClassName=props.getProperty("cn.itcast.dao.DataDao");
				String userClassName=props.getProperty("cn.itcast.dao.UserDao");
				Class clazz=Class.forName(dataClassName);
				Class clazz2=Class.forName(userClassName);
				dataDao=(DataDao)clazz.newInstance();
				userDao=(UserDao)clazz2.newInstance();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    
	    public static DaoFactory getInstance(){
	    	return instance;
	    }
	    
		public DataDao getDataDao(){			
			return dataDao;
		}
		
		public UserDao getUserDao(){
			return userDao;
		}
}
