package yk.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import yk.dao.NewsDao;
import yk.entity.News;
import yk.util.HibernateUtils;

@Repository("newsDao")
public class NewsDaoImpl implements NewsDao {

	@Autowired //按类型注入
	private HibernateTemplate hibernateTemplate;

	public List<News> findAllNews() {
		// TODO Auto-generated method stub
		return (List<News>) hibernateTemplate.find("from News");    //hibernateTemplate
		/*SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//得到sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//得到session
			session = sessionFactory.openSession();
			//开启事务
			tx = session.beginTransaction();
			
			//查询所有记录
			Criteria criteria = session.createCriteria(News.class);
//			criteria.add(Restrictions.eq(propertyName, value))
			List<News> list = criteria.list();

			//提交事务
			tx.commit();
			return list;
		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			//sessionFactory不需要关闭
//			sessionFactory.close();
		}
		return null;*/
	}

	public void addNews(News news) {
		hibernateTemplate.save(news);
		
	}

	public void delNews(News news) {
		hibernateTemplate.delete(news);
		
	}

	public void updateNews(News news) {
		hibernateTemplate.update(news);
		
	}

	public int getNewsCount() {
		String sql = "select count(*) from News where 1=1";
		List list1 = new ArrayList<>();	
		List<Long> list = (List<Long>) hibernateTemplate.find(sql, list1.toArray());		
		return list.get(0).intValue();	//强转long型为int型
	}

	@SuppressWarnings("unchecked")
	public List<News> findByNewsId(int currentPage, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class);
		criteria.addOrder(Order.asc("publishTime"));	//按照发布时间排序
		return (List<News>) hibernateTemplate.findByCriteria(criteria , (currentPage-1)*pageSize, pageSize);
	}																	//定义分页的页面数据展示效果

	//根据newsId查询数据
	public News findNewsByNewsId(Integer newsId) {
		return hibernateTemplate.get(News.class, newsId);
	}

	@Override
	public List<News> findPageByKey(int currentPage, int pageSize, String key) {
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class);
		if(key !=null && key.length()>0){
			criteria.add(Restrictions.like("title", "%"+key+"%"));  
		}
		criteria.addOrder(Order.desc("publishTime"));
		return (List<News>) hibernateTemplate.findByCriteria(criteria , (currentPage-1)*pageSize, pageSize);
	}

	@Override
	public int getNewsKeyCount(String key) {
		String sql = "select count(*) from News where 1=1";
		List list2 = new ArrayList<>();
		if(key !=null && key.length()>0){
			sql+=" and title like '%"+key+"%'";
		}
		List<Long> list = (List<Long>) hibernateTemplate.find(sql, list2.toArray());		
		return list.get(0).intValue();
	}

	@Override
	public List<News> findAllNews(String key) {
		DetachedCriteria criteria = DetachedCriteria.forClass(News.class);
		if(key !=null && key.length()>0){
		criteria.add(Restrictions.like("title", "%"+key+"%"));  
		}
		criteria.addOrder(Order.desc("publishTime"));
		return (List<News>) hibernateTemplate.findByCriteria(criteria);
	}
	
}
