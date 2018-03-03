package cn.itcast.dao;

public interface DataDao {
		public String PrintAllData(String time_start,String end_start);
		public String PrintAllDataMobile();
		public String PrintGivenCarDataMobile(String carid);
		public String PrintTraceMobile(String start_time,String end_time,String carid);
}
