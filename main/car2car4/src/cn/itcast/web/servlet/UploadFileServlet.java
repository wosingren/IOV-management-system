package cn.itcast.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import cn.itcast.dao.UserDao;
import cn.itcast.factory.DaoFactory;
import cn.itcast.service.UploadFileService;;

public class UploadFileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//要执行文件上传操作
		//判断表单是否支持文件上传，enctype="multipart/form-data"
		boolean ism =ServletFileUpload.isMultipartContent(request);
		if(!ism){
			throw new RuntimeException("your form is not multipart/form-data");
		}
		//创建一个DiskFileItemfactory工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//创建一个ServletFileUpload核心对象（表单解析器）
		ServletFileUpload sfu = new ServletFileUpload(factory);
		//解析request对象，得到一个表单项集合
		try {
			List<FileItem> fileItems = sfu.parseRequest(request);
			//遍历表单项数据
			for(FileItem fileitem:fileItems){
				if(fileitem.isFormField()){
					//普通表单项
					processFormField(fileitem);
				}else{
					//上传表单项
					processUploadField(fileitem);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		//解析excel文件
		try {
			UploadFileService ufs = new UploadFileService();
			ArrayList<ArrayList<String>> results = ufs.f2m();
			UserDao ud=DaoFactory.getInstance().getUserDao();
			ud.insertUserInfo(results);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//上传表单项
	private void processUploadField(FileItem fileitem) {
		//得到上传的名字
		String filename= fileitem.getName();
		//得到文件流
		try {
			//得到文件输入流
			InputStream is = fileitem.getInputStream();
			//创建存盘路径
			String directoryRealPath=this.getServletContext().getRealPath("/upload");
			System.out.println(directoryRealPath);
			File storeDirectory= new File(directoryRealPath);
			//创建指定目录
			if(!storeDirectory.exists()){
				storeDirectory.mkdirs();
			}
			//在storeDirectory下，创建完整目录下的文件
			File file=new File(storeDirectory,filename);
			//通过文件输出流将上传的文件保存到磁盘
			FileOutputStream fos=new FileOutputStream(file);
			
			int len=0;
			byte[] b=new byte[1024];
			while((len=is.read(b))!=-1){
				fos.write(b, 0, len);
			}
			fos.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//普通表单项
	private void processFormField(FileItem fileitem) {
		String fieldname=fileitem.getFieldName();//字段名
		String fieldvalue=fileitem.getString();//字段值
		System.out.println(fieldname+"="+fieldvalue);
	}
}
