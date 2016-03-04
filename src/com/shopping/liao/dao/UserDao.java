package com.shopping.liao.dao;

import java.util.List;

import com.shopping.liao.pojo.User;

public interface UserDao {

	public User getUserByUid(int userid);//通过传入userid得到返回User类
	public void addUser(User user);//增加用户
	public void alterUserByUsername(User user);//修改资料
	public void alterPassword(String password,int id);//修改密码
	public void deleteUserById(int id);//删除用户
	public User getUserByUsername(String username);
	public List<User> getAllUsers();
	public void freezeUserById(int id,int grade);//冻结帐号
	public double getConsumSum(int userid);
}
