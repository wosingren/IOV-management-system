/**
 * 
 */
package com.guanli.operate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.guanli.entity.Yonghu;
/**
 * @author 123
 *
 */
public class YongHu {
	 public List readFirstYonghu(){
	        List<Yonghu> list =new ArrayList<Yonghu>();
	        Connection con=null;
	        PreparedStatement psmt=null;
	        ResultSet rs=null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        
	        try {
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/guanli","root","Qa111111");
	            String sql="select * from yonghu";
	            psmt=con.prepareStatement(sql);
	            rs=psmt.executeQuery();
	            
	            while(rs.next())
	            {
	                int xuhao=rs.getInt("xuhao");
	                String shenfen=rs.getString("shenfen");
	                String xingming=rs.getString("xingming");
	                String mima=rs.getString("mima");
	                Yonghu tl=new Yonghu(xuhao, shenfen, xingming, mima);
	                list.add(tl);
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally
	        {
	            try {
	                if(rs!=null)
	                {
	                    rs.close();
	                }
	                if(psmt!=null)
	                {
	                    psmt.close();
	                }
	                if(con!=null)
	                {
	                    con.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return list;
	    }


}
