package yk.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yk.dao.UserDao;
import yk.entity.User;
import yk.service.*;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired // 注入
	private UserDao userDao;

	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user) ;
	}

	public void register(User user) {
		// TODO Auto-generated method stub
		System.out.println("注册执行");
		userDao.register(user);
	}

	public void reset(User user) {
		// TODO Auto-generated method stub
		userDao.reset(user);
	}

	public User findUserByusername(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserByusername(username);
	}

}
