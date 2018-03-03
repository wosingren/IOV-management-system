/**
 * 
 */
package com.guanli.entity;
import java.sql.Date;
/**
 * 数据库的实体类，对应guanli数据库的yonghu表
 *
 */
public class Yonghu {

	/**
	 * @param args
	 */
	    private int xuhao;   
	    private String shenfen;
	    private String xingming;
	    private String mima;
	    
	    public int getXuhao() {
	        return xuhao;
	    }
	    public void setXuhao(int xuhao) {
	        this.xuhao = xuhao;
	    }
	    public String getShenfen() {
	        return shenfen;
	    }
	    public void setShenfen(String shenfen) {
	        this.shenfen = shenfen;
	    }
	    public String getXingming() {
	        return xingming;
	    }
	    public void setXingming(String xingming) {
	        this.xingming = xingming;
	    }
	    public String getMima() {
	        return mima;
	    }
	    public void setMima(String mima) {
	        this.mima = mima;
	    }
	    public Yonghu(int xuhao, String shenfen, String xingming, String mima) {
	        super();
	        this.xuhao = xuhao;
	        this.shenfen = shenfen;
	        this.xingming = xingming;
	        this.mima = mima;
	    }

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
