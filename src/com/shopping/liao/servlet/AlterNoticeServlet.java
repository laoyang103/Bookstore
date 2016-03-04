package com.shopping.liao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.liao.pojo.Notice;
import com.shopping.liao.service.impl.NoticeServiceImpl;

public class AlterNoticeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pdate = request.getParameter("pdate");
		String edate = request.getParameter("edate");
		PrintWriter out = response.getWriter();
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse(pdate);
			Date date2 = sdf.parse(edate);
			Timestamp ts1=new Timestamp(date1.getTime());
			Timestamp ts2=new Timestamp(date2.getTime());
			
			Notice notice = new Notice();
			notice.setId(id);
			notice.setTitle(title);
			notice.setContent(content);
			notice.setPdate(ts1);
			notice.setEdate(ts2);
			NoticeServiceImpl.getInstance().alterNotice(notice);
			out.print("修改公告成功！");
		}
		catch(Exception e){
			out.print("添加修改失败，请重新再试！");
		}
		out.flush();
		out.close();
	}

	

}
