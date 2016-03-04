package com.shopping.liao.service;

import java.util.List;

import com.shopping.liao.pojo.Notice;

public interface NoticeService {

	public List<Notice> getNotices();
	public void deleteNoticeById(int id);
	public void alterNotice(Notice notice);
	public Notice getNoticeById(int id);
	public void addNotice(Notice notice);
}
