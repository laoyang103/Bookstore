package com.shopping.liao.service;

import java.util.List;

import com.shopping.liao.pojo.User;

public interface UserService {
	public User getUserByUid(int userid);//通过id得到用户
	public void addUser(User user);//添加用户
	public void alterUserByUsername(User user);//通过用户名修改用户信息
	public void deleteUserById(int id);//删除用户
	public User getUserByUsername(String username);//通过用户名得到用户
	public User Login(String username,String password);//登录
	public List<User> getAllUsers();//得到所有用户
	public void freezeUserById(int id,int grade);//冻结用户
	public void alterPassword(String password, int id);//修改密码
	public double getConsumSum(int userid);//得到总消费额
}
