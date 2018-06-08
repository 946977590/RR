package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Alarm;
import utils.HibernateUtils;

public class DateTest {
	public static void main(String[] args){
		addtest();
		
	}
	
	
	public static  void addtest(){

		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		
//		第三步 使用SessionFactory创建session对象
		// 类似于连接
		Session session = sessionFactory.openSession();
		
//		第四步 开启事务
		Transaction tx = session.beginTransaction();
		Alarm alarm = new Alarm();
		alarm.setAlarm_describe("关于警报1的描述");
		alarm.setAlarm_name("警报1");
		alarm.setAlarm_pc("ip：163.185.1.6");
		alarm.setAlarm_type("事件警报");
		alarm.setAlarm_user("用户1");
		alarm.setAlarm_way("邮箱通知");
		alarm.setMainframe_id("主机1");
		session.save(alarm);
		System.out.println("adddd");
		tx.commit();

//		第七步 关闭资源
		session.close();
		sessionFactory.close();
		}
}
