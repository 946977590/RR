package yk.action;

import yk.entity.User;
import yk.mail.Mail2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import yk.service.UserService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
@Namespace("/")
@Controller("loginAction") // 创建对象
@Scope("prototype") // 多实例方式创建对象
public class LoginAction extends ActionSupport implements ModelDriven<User> {

	
	@Action(value = "fasong", results = { @Result(name = "success", location = "/findpassword2.jsp")}
	)
	public void sendEmail() {
		String receiveEmailAccount = "946977590@qq.com";// 用户邮箱
		try {
			String verifyCode = Mail2.sendEmail(receiveEmailAccount, "陌陌");
			HttpServletResponse httpServletResponse = ServletActionContext.getResponse();
			httpServletResponse.getWriter().write("{\"verifyCode\":\"" + verifyCode + "\"}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private User user = new User();

	public void setUser(User user) {
		this.user = user;
	}
	// String form_username=this.user.getUsername();
	// String form_password=this.user.getPassword();
	// System.out.println(user2); //测试输出表单password

	private UserService userService;

	// 后台查询信息类别数据
	@Action(value = "login", results = { @Result(name = "success", location = "/welcome.jsp"),
			@Result(name = "fail", location = "/login.jsp") })
	public String login() {
	
		String page = "fail";
		User user = null;
		
		// System.out.println(this.getModel().getUsername() + "--" +
		// this.getModel().getPassword());
		// System.out.println(userService);
		// System.out.println(this.getModel().getUsername()+"--"+this.getModel().getPassword());
		// System.out.println(this.getModel());
		user = userService.login(this.getModel());
		if (user != null) {

			if (user.getPassword().equals(this.getModel().getPassword())) {
				page = "success";
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				if (session.getAttribute("userName") != null) {
					session.removeAttribute("userName");
				}
				session.setAttribute("userName", user.getUsername());
			} else {
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("msg", "用户名或密码错误!");
			}
		} else {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("msg", "用户名或密码错误!");
		}
		System.out.println(this.getModel());
		return page;

	}

	@Action(value = "register", results = { @Result(name = "success", location = "/login.jsp"),
			@Result(name = "error", location = "/reg.jsp") })
	public String register() {

		User existUser = userService.login(this.getModel()); // 创建existUser对象？拿表单提交的name数据
		System.out.println(existUser); // 去数据库对比，看能否产生existUser对象
		if (existUser != null) {
			return "error";
		} else {
			userService.register(user);
			return "success";
		}
	}

	@Action(value = "reset", results = { @Result(name = "success", location = "/login.jsp"),
			@Result(name = "error", location = "/findpassword.jsp") })
	public String reset() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();// 去数据库对比，看能否产生existUser对象
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String username = request.getParameter("username");
		User resetuser = userService.findUserByusername(username);
		if (resetuser != null) {
			if (resetuser.getPassword().equals(oldpassword)) {
				resetuser.setPassword(newpassword);
				userService.reset(resetuser);
				return "success";
			} else {
				System.out.println("输入旧密码错误");
				return "error";
			}
		} else {
			System.out.println("您输入的用户不存在");
			return "error";
		}
	}
	

	@Action(value = "reset2", results = { @Result(name = "success", location = "/login.jsp"),
			@Result(name = "error", location = "/findpassword2.jsp") })
	public String reset2() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String newpassword = request.getParameter("newpassword");
		String username = request.getParameter("username");
		User resetuser = userService.findUserByusername(username);
		System.out.println(newpassword+username+resetuser);
		if (resetuser != null) {
				resetuser.setPassword(newpassword);
				userService.reset(resetuser);
				return "success";
			}
		else {
			System.out.println("您输入的用户不存在");
			return "error";
		}
		
		
		
		/*HttpServletRequest request = ServletActionContext.getRequest();
		String verifyCode2 = request.getParameter("verifyCode");
		String newpassword = request.getParameter("newpassword");
		String username = request.getParameter("username");
		User resetuser = userService.findUserByusername(username);
		
		if (resetuser != null) {
			HttpServletResponse httpServletResponse = ServletActionContext.getResponse();
			if (httpServletResponse.equals(verifyCode2)) {
				resetuser.setPassword(newpassword);
				userService.reset(resetuser);

				return "success";
			} else {
				System.out.println("验证码错误");
				return "error";
			}
		} else {
			System.out.println("您输入的用户不存在");
			return "error";
		}*/

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
