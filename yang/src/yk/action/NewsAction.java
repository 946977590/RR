 package yk.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import yk.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import yk.entity.News;
import yk.service.NewsService;

@ParentPackage("struts-default")
@Namespace("/")
@Controller("newsAction")  //创建对象
@Scope("prototype")    //多实例方式创建对象
public class NewsAction extends ActionSupport implements ModelDriven<News>{
	private Date date=new Date();
	private News news=new News();
	private String key;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}

	@Autowired  //注入
	private NewsService newsService;
	private List<News> list=null;
	public List<News> getList() {
		return list;
	}
	public void setList(List<News> list) {
		this.list = list;
	}
	
	//新闻添加
	@Action(value="addNews",results={@Result(name="addNews",location="/newslist",type = "redirect")})
	public String addNews() {
		//调用service的方法添加到数据库
		System.out.println("11");
		try {
			news.setPublishTime(date);
			System.out.println(news.getAuthor());
			newsService.addNews(news);
		}catch(Exception e){
			e.printStackTrace();
		}	
		return "addNews";
		
	}
	
	//新闻列表
		@Action(value="newslist",results={@Result(name="newslist",location="/admin/news/newsList.jsp")})
		public String newslist() {
			//调用service
			//返回数据放到值栈的list里面  
			//list = newsService.findAllNews();

			//System.out.println(list.get(0).getTitle());
			pb = newsService.findNewsByNewsId(currentPage, pageSize);
			this.setPb(pb);
			/*HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");//告知浏览器使用什么编码解析文本
*/			return "newslist";
		}
		

		//根据newsId查询指定信息对象跳转到更新页面
		@Action(value="editnews",results={@Result(name="editNews",location="/admin/news/newsEdit.jsp")})
		public String editInfo(){
			news = newsService.findNewsByNewsId(news.getNewsId());
			this.setNews(news);
			return "editNews";
		}
		
		
	//新闻更新
		@Action(value="updateNewssubmit",results={@Result(name="success",location="/newslist",type = "redirect")})
		public String editsubmit() {
			try {
				news.setPublishTime(date);
				newsService.updateNews(news);
			}catch(Exception e){
				e.printStackTrace();
			}	
			return "success";
		}
		
	//新闻删除
		@Action(value="deletenews",results={@Result(name="success",location="/newslist",type = "redirect")})
			public String deletenews() {
				try {
					newsService.delNews(news);
				}catch(Exception e){
					e.printStackTrace();
				}	
				return "success";
			}
		
	//查询分页信息数据
		/*	@Action(value="findNewsBynewsId",results={@Result(name="findNewsBynewsId",location="/newslist")})
			public String findNewsBynewsId(){
				pb = newsService.findNewsByNewsId(currentPage, pageSize);
				this.setPb(pb);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=UTF-8");//告知浏览器使用什么编码解析文本
				return "findNewsBynewsId";
			}	*/
			
		private int currentPage=1; //当前页
		private int pageSize = 3;//默认每页显示条数

		private PageBean<News> pb;  // ${pb}
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}	
		public PageBean<News> getPb() {
			return pb;
		}
		public void setPb(PageBean<News> pb) {
			this.pb = pb;
			
		}
	
		//根据关键字查询分页信息数据
				@Action(value="findNewsKeyByPage",results={@Result(name="findNewsKeyByPage",location="/admin/news/newsList.jsp")})
				public String findNewsKeyByPage(){
					if(key !=null){
						key=key.trim();
					}
					pb=newsService.findNewsByKey(currentPage, pageSize, key);
					this.setPb(pb);	
					return "findNewsKeyByPage";
				}
		
				
				//搜索
				@Action(value="Findss",results={@Result(name="Findss",location="/newslist")})
				public String Findss(){
					
					try {
						key = new String(key.getBytes("iso-8859-1"),"utf-8");
						pb = newsService.findNewsByKey(currentPage, pageSize, key);
						/*list = newsService.findAllNews(key);
						ActionContext.getContext().getContextMap().put("listkeynews",list);	*/
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return "Findss";
				}
				
	public News getModel() {
		// TODO Auto-generated method stub
		return news;
	}

}
