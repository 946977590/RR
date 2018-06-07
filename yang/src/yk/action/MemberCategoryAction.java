package yk.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import yk.entity.MemberCategory;
import yk.service.MemberCategoryService;

@ParentPackage("struts-default")
@Namespace("/")
@Controller("memberCategoryAction")  //创建对象
@Scope("prototype")    //多实例方式创建对象
//使用模型驱动获取表单数据
public class MemberCategoryAction extends ActionSupport implements ModelDriven<MemberCategory>{

	private MemberCategory memberCategory=new MemberCategory();


	public MemberCategory getMemberCategory() {
		return memberCategory;
	}
	public void setMemberCategory(MemberCategory memberCategory) {
		this.memberCategory = memberCategory;
	}

	@Autowired  //注入
	private MemberCategoryService memberCategoryService;
	private List<MemberCategory> listMemberCategory=null;
	
	public List<MemberCategory> getListMemberCategory() {
		return listMemberCategory;
	}
	public void setListMemberCategory(List<MemberCategory> listMemberCategory) {
		this.listMemberCategory = listMemberCategory;
	}
	
	@Action(value="addMemberCategory",results={@Result(name="addMemberCategory",location="/listMemberCategory",type = "redirect")})
	public String addMemberCategory() {
		//调用service的方法添加到数据库
		//System.out.println("xxxx");
		try {
			//System.out.println(member.getMemName());
			memberCategoryService.addMemCategory(memberCategory);
		}catch(Exception e){
			e.printStackTrace();
		}	
		return "addMemberCategory";
	}
	
	//会员种类列表
		@Action(value="listMemberCategory",results={@Result(name="listMemberCategory",location="/admin/member/memberCategoryList.jsp")})
		public String listMemberCategory() {
			//调用service
			//返回数据放到值栈的listMemberCategory里面  
		try {
			listMemberCategory = memberCategoryService.findAllMemCategory();
			/*ValueStack stack = ActionContext.getContext().getValueStack(); 
			stack.set("MemberCategoryList",listMemberCategory);*/
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");//告知浏览器使用什么编码解析文本
		}catch(Exception e){
			e.printStackTrace();
		}	
		return "listMemberCategory";
	}
		
	public MemberCategory getModel() {
		return memberCategory;
	}

}
