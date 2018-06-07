package yk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import yk.entity.Member;
import yk.entity.MemberCategory;
import yk.entity.News;
import yk.entity.PageBean;
import yk.service.MemberService;
@ParentPackage("struts-default")
@Namespace("/")
@Controller("memberAction")  //创建对象
@Scope("prototype")    //多实例方式创建对象
public class MemberAction extends ActionSupport implements ModelDriven<Member>{
	private Member member=new Member();
	private HttpServletResponse http_response;
	private HttpServletRequest http_request; 	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	@Autowired  //注入
	private MemberService memberService;
	private List<Member> listmember=null;
	
	public List<Member> getListMember() {
		return listmember;
	}
	public void setListMember(List<Member> listMember) {
		this.listmember = listMember;
	}

	@Action(value="addMember",results={@Result(name="addMember",location="/listmember",type = "redirect")})
	public String addMember() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		
		try {
			//System.out.println(member.getMemName());
			memberService.addMember(member);
		}catch(Exception e){
			e.printStackTrace();
		}	
		return "addMember";
	}
	
	
	public void addMember2() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		
		try {
			//System.out.println(member.getMemName());
			memberService.addMember(member);
			http_response.setContentType("text/html;charset=utf-8");

			http_response.getWriter().write("success");
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	
	// 到添加页面
	/*@Action(value="toAddPage",results={@Result(name="toAddPage",location="/admin/member/add.jsp")})
	public String toAddPage() {
		return "toAddPage";
	}
	*/
	//1 定义list变量,get方法


	//客户列表
	@Action(value="listmember",results={@Result(name="listmember",location="/admin/member/memberList.jsp")})
	public String listmember() {
		//调用service
		//返回数据放到值栈的list里面  
		listmember = memberService.findAll();
		//System.out.println(list.get(0).getMemAdress());
		pb2=memberService.findMemberByPage(currentPage, pageSize);
		setPb(pb2);
		ActionContext.getContext().getContextMap().put("listmember",listmember);
		//private MemberCategory memberCategory;
		return "listmember";
	}
	
	@Action(value="updatesubmit",results={@Result(name="success",location="/admin/member/list.jsp")})
	public String editsubmit() {
		try {
			memberService.updateMember(member);
		}catch(Exception e){
			e.printStackTrace();
		}	
		return "success";
	}
	private int currentPage=1; //当前页
	private int pageSize = 3;//默认每页显示条数

	private PageBean<Member> pb2;  // ${pb}
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
	public PageBean<Member> getPb2() {
		return pb2;
	}
	public void setPb(PageBean<Member> pb2) {
		this.pb2 = pb2;
		
	}
	
	public Member getModel() {
		return member;
	}

}
