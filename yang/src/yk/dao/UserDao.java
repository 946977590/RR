package yk.dao;

import yk.entity.User;

public interface UserDao {

	public  User login(User user);		//登陆方法

	public void register(User user);	//注册方法
	
}
