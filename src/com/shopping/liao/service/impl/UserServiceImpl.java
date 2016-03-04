package com.shopping.liao.service.impl;

import java.util.List;

import com.shopping.factory.ObjectFactory;
import com.shopping.liao.dao.UserDao;
import com.shopping.liao.dao.impl.UserDao4MySqlImpl;
import com.shopping.liao.exception.PasswordErrorException;
import com.shopping.liao.exception.UsernameNotFoundException;
import com.shopping.liao.pojo.User;
import com.shopping.liao.service.UserService;

public class UserServiceImpl implements UserService {

	private UserServiceImpl(){}
	private static UserDao userDao = (UserDao)ObjectFactory.getInstance("userDao");
	private static UserService userService = new UserServiceImpl();
	public static UserService getInstance(){
		return userService;
	}
	public User getUserByUid(int userid) {
		return userDao.getUserByUid(userid);
	}
	public void addUser(User user) {
		userDao.addUser(user);
		
	}
	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
		
	}
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}
	public User Login(String username, String password) {
		User user = userDao.getUserByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException();
		}
		if(!password.equals(user.getPassword()))
		{
			throw new PasswordErrorException();
		}
		return user;
	}
	public void alterUserByUsername(User user) {
		userDao.alterUserByUsername(user);	
	}
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	public void freezeUserById(int id, int grade) {
		userDao.freezeUserById(id, grade);
		
	}
	public void alterPassword(String password, int id) {
		userDao.alterPassword(password, id);
		
	}
	public double getConsumSum(int userid) {
		// TODO Auto-generated method stub
		return userDao.getConsumSum(userid);
	}

}
