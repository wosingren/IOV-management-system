package cn.itcast.dao;

import java.util.ArrayList;
import net.sf.json.JSONObject;

public interface UserDao {
    public JSONObject getGrade(String username,String password);
	public String getUserInfo();
	public String searchUserInfo(String username);
	public void deleteUserInfo(String[] delId);
	public void insertUserInfo(ArrayList<ArrayList<String>> results);
}
