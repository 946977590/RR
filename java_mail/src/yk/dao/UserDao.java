package yk.dao;

import yk.entity.User;

public interface UserDao {

	public  User login(User user);

	public void register(User user);

	public void reset(User user);
	
	User findUserByusername(String username);
}
