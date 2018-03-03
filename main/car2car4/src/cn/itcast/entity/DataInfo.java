package cn.itcast.entity;

public class DataInfo {
	  private String devID;
	  private String time;
      private String GPS_longitude;
	  private String GPS_latitude;
	  private String state;
	  private String cellID;
	  private String carNum;
	  private String warn;
	  //devID,time,GPS_lontitude,GPS_latitude,
	public DataInfo(String devID, String time, String state, String GPS_lontitude,
			String GPS_latitude,String cellID, String carNum, String warn) {
		super();
		this.devID = devID;
		this.time = time;
		this.state = state;
		this.GPS_longitude = GPS_lontitude;
		this.GPS_latitude = GPS_latitude;
		this.cellID = cellID;
		this.carNum = carNum;
		this.warn = warn;
		
	}

	public String getCellID() {
		return cellID;
	}
	
	public void setCellID(String cellID) {
		this.cellID = cellID;
	}
	
	public String getCarNum() {
		return carNum;
	}
	
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	
	public String getWarn() {
		return warn;
	}
	
	public void setWarn(String warn) {
		this.warn = warn;
	}
	public String getdevID() {
		return devID;
	}

	public void setdevID(String devID) {
		this.devID = devID;
	}

	public String gettime() {
		return time;
	}

	public void settime(String time) {
		this.time = time;
	}

	public String getGPS_lontitude() {
		return GPS_longitude;
	}

	public void setGPS_lontitude(String GPS_lontitude) {
		this.GPS_longitude = GPS_lontitude;
	} 
	
	public String getGPS_latitude() {
		return GPS_latitude;
	}

	public void setGPS_latitude(String GPS_latitude) {
		this.GPS_latitude = GPS_latitude;
	}  
	
	public String getstate() {
		return state;
	}

	public void setstate(String state) {
		this.state = state;
	}   
      
}
