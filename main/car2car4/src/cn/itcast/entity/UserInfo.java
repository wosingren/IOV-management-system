package cn.itcast.entity;

public class UserInfo {
	private String username;
	private String password;
	private String grade;
	private String devId;
	public UserInfo(String username, String password, String grade, String devId) {
		super();
		this.username = username;
		this.password = password;
		this.grade = grade;
		this.devId = devId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDevId() {
		return devId;
	}
	public void setDevId(String devId) {
		this.devId = devId;
	}
}
