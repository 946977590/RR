package yk.dao;

import java.util.List;

import yk.entity.News;


public interface NewsDao {

	List<News> findAllNews();

	void addNews(News news);

	void delNews(News news);

	void updateNews(News news);

	int getNewsCount();

	List<News> findByNewsId(int currentPage, int pageSize);

	//根据newsId查询数据
	News findNewsByNewsId(Integer newsId);
	
	List<News> findPageByKey(int currentPage, int pageSize,String key);
	
	int getNewsKeyCount(String key);
	List<News> findAllNews(String key);
}
