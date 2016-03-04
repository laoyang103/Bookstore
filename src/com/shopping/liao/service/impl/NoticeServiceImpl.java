package com.shopping.liao.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.shopping.empory.service.impl.ProductServiceImpl;
import com.shopping.factory.ObjectFactory;
import com.shopping.liao.dao.NoticeDao;
import com.shopping.liao.pojo.Notice;
import com.shopping.liao.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	private NoticeServiceImpl(){}
	private static NoticeDao noticeDao = (NoticeDao)ObjectFactory.getInstance("noticeDao");
	private static NoticeService noticeService = new NoticeServiceImpl();
	public static NoticeService getInstance(){
		return noticeService;
	}
	public List<Notice> getNotices() {
		return noticeDao.getNotices();
	}
	public void deleteNoticeById(int id) {
		//日志
		Logger logger = Logger.getLogger(NoticeServiceImpl.class);
		logger.warn("notice "+getNoticeById(id).getTitle()+" is deleted.");
		noticeDao.deleteNoticeById(id);
		
	}
	public void alterNotice(Notice notice) {
		noticeDao.alterNotice(notice);
		
	}
	public Notice getNoticeById(int id) {
		 return noticeDao.getNoticeById(id);
	}
	public void addNotice(Notice notice) {
		noticeDao.addNotice(notice);
		
	}

}
