package yk.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yk.dao.NewsDao;
import yk.entity.News;
import yk.entity.PageBean;
import yk.service.NewsService;

@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService {
	
	@Autowired  //注入
	private NewsDao newsDao;

	public List<News> findAllNews() {
		
		return newsDao.findAllNews();
	}

	public void addNews(News news) {
		newsDao.addNews(news);
	}

	public void delNews(News news) {
		newsDao.delNews(news);

	}

	public void updateNews(News news) {
		newsDao.updateNews(news);
	}

	public PageBean<News> findNewsByNewsId(int currentPage, int pageSize) {
		int count = newsDao.getNewsCount(); //求当前类别信息数量
		int totalPage = (int) Math.ceil(count*1.0/pageSize);//求总页数
		List<News> list = newsDao.findByNewsId(currentPage,pageSize); //求当前页的集合数据
		PageBean<News> pb = new PageBean<News>();
		pb.setCount(count);
		if(currentPage==0)currentPage=1;
		pb.setCurrentPage(currentPage);
		pb.setList(list);
		pb.setPageSize(pageSize);
		pb.setTotalPage(totalPage);
		return pb;
	}

	//根据newsId查询数据
	public News findNewsByNewsId(Integer newsId) {
		return newsDao.findNewsByNewsId(newsId);
	}

	@Override
	public List<News> findAllNews(String key) {
		// TODO Auto-generated method stub
		return newsDao.findAllNews(key);
	}

	@Override
	public PageBean<News> findNewsByKey(int currentPage, int pageSize, String key) {
		int count = newsDao.getNewsKeyCount(key); //求当前类别信息数量
		int totalPage = (int) Math.ceil(count*1.0/pageSize);//求总页数
		List<News> list = newsDao.findPageByKey(currentPage,pageSize,key); //求当前页的集合数据
		PageBean<News> pb = new PageBean<>();
		pb.setCount(count);
		if(currentPage==0)currentPage=1;
		pb.setCurrentPage(currentPage);
		pb.setList(list);
		pb.setPageSize(pageSize);
		pb.setTotalPage(totalPage);
		return pb;
	}


}
