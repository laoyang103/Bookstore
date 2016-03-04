package com.shopping.empory.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;


public class UploadServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SmartUpload smartUpload = new SmartUpload();
		//初始化
		smartUpload.initialize(this.getServletConfig(), request, response);
		//设置编码
		smartUpload.setCharSet("UTF-8");
		try {
			//保存在内存中
			smartUpload.upload();
			
			Request req = smartUpload.getRequest();
			String name = req.getParameter("name");
			File file = smartUpload.getFiles().getFile(0);
			String ext = file.getFileExt();
			//System.out.println(name);			//smartUpload.save("f:\\");
			file.saveAs("D:\\Tomcat\\apache-tomcat-7.0.26\\webapps\\"+getAppName(request, response)+"\\images\\goods\\"+name+"."+ext);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getAppName(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = req.getRequestURI();
		String servletPath = req.getServletPath();
		String appName = requestURI.substring(1, requestURI.length()-servletPath.length());
		return appName;
	}

}
