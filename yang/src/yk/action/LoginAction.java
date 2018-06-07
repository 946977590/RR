package yk.action;

import yk.entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;

import yk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
@Namespace("/")
@Controller("loginAction") // 创建对象
@Scope("prototype") // 多实例方式创建对象
public class LoginAction extends ActionSupport implements ModelDriven<User> {

	private User user=new User();
	public void setUser(User user) {
		this.user = user;
	}
	//String form_username=this.user.getUsername();
	//String form_password=this.user.getPassword();
	//System.out.println(user2);  //测试输出表单password
	@Autowired // 注入
	private UserService userService;

	// 后台查询信息类别数据
	@Action(value = "login", results = { @Result(name = "success", location = "/admin/left.jsp"),
			@Result(name = "fail", location = "/login.jsp") })
	public String login() {
		String page = "fail";
		User user22 = null;
		//System.out.println(this.getModel().getUsername() + "--" + this.getModel().getPassword());
		//System.out.println(userService);
		//System.out.println(this.getModel().getUsername()+"--"+this.getModel().getPassword());
		//System.out.println(this.getModel());
		user22 = userService.login(this.getModel());
		if (user22 != null) {
			
			if (user22.getPassword().equals(user.getPassword())) {
				page = "success";
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				if (session.getAttribute("userName") != null) {
					session.removeAttribute("userName");
				}
				session.setAttribute("userName", user22.getUsername());	
			} else {
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("msg", "用户名或密码错误!");
			}
		} else {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("msg", "用户名或密码错误!");
		}
		System.out.println(this.getModel().getUsername());
		return page;
		
	}
	
	
	@Action(value="register",results={
			@Result(name="success",location="/login.jsp"),
			@Result(name="error",location="/reg.jsp")
			})
	public String register(){
		
        User existUser=userService.login(this.getModel()); //创建existUser对象？拿表单提交的name数据
        System.out.println(existUser);					//去数据库对比，看能否产生existUser对象
        if(existUser!=null){
        	return "error";
        }else{
       userService.register(user);
		return "success";
        }
	}

	@Action(value = "logout")
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("userName") != null) {
			session.removeAttribute("userName");
		}

		HttpServletResponse response = (HttpServletResponse) ServletActionContext.getResponse();
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("<script language=javascript>");
		out.print("top.location.href='" + request.getContextPath() + "/login.jsp'");
		out.print("</script>");

		return null;
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	

}
