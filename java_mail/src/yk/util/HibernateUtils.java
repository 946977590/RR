package yk.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	static Configuration cfg=null;
	static SessionFactory sessionFactory=null;
	//静态代码实现
	static {
		//加载核心配置文件
		cfg=new Configuration();
		cfg.configure();
		sessionFactory =cfg.buildSessionFactory();
		
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
