package yk.service;

import java.util.List;



import yk.entity.News;
import yk.entity.PageBean;

public interface NewsService {

	List<News> findAllNews();

	void addNews(News news);

	void delNews(News news);

	void updateNews(News news);

	PageBean<News> findNewsByNewsId(int currentPage, int pageSize);

	//根据newsId查询数据
	News findNewsByNewsId(Integer newsId);
	
	List<News> findAllNews(String key);
	PageBean<News> findNewsByKey(int currentPage, int pageSize,String key);
}
