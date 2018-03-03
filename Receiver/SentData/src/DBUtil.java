import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * ���ݿ����Ӹ�����
 * @author John Kwok
 *
 */
public class DBUtil {
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/cartocar";
//	   static final String DB_URL = "jdbc:mysql://localhost/car";

	   //  Database credentials
	   static final String USER = "root";
//	   static final String PASS = "root";
	   static final String PASS = "123456";
	/*
	 * close
	 */
	public void closeConn(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	/*
	 *open connection
	 */
	public Connection openConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}

