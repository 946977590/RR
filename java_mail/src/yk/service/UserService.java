package yk.service;

import yk.entity.User;

public interface UserService {
	
	User login(User user);
	public void register(User user);
	public void reset(User user);
	User findUserByusername(String username);
}
