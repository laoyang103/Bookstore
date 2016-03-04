package com.shopping.liao.dao;

import java.util.List;

import com.shopping.liao.pojo.Notice;

public interface NoticeDao {

	public Notice getNoticeById(int id);//通过id得到公告
	public List<Notice> getNotices();//获得所有公告
	public void deleteNoticeById(int id);//删除公告
	public void alterNotice(Notice notice);//修改公告
	public void addNotice(Notice notice);//添加公告
	
}
