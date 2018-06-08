package yk.daoimpl;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import yk.dao.UserDao;
import yk.entity.User;
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired // 注入
	private HibernateTemplate hibernateTemplate;
	
	public User login(User user) {
		// TODO Auto-generated method stub
		
		 return hibernateTemplate.get(User.class, user.getUsername());
		
	}

	public void register(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(user);
	}

	public void reset(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(user);
	}

	public User findUserByusername(String username) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(User.class, username);
	}
	
	
}
