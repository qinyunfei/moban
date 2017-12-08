package sgg.qin.web.controller.systems;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sgg.qin.domain.systems.SysUser;
import sgg.qin.util.DateUtil;
import sgg.qin.util.PageData;
import sgg.qin.web.controller.base.BaseController;
@Controller
public class LoginController extends BaseController{
	

	/*
	 * 该方法并不是登陆流程
	 * 而是如果登陆发生错误会来到该方法进行处理
	 * 登陆过程正常是不会来到该方法的
	 */
	@RequestMapping(value = "/login")
	public String showLoginForm(HttpServletRequest req, Model model) {
		//使用shiro的
		Subject currentUser = SecurityUtils.getSubject();
		//判断是否认证成功
		if (!currentUser.isAuthenticated()) {
			//获取异常类名
			String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
			String error = null;
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				error = "帐号/密码错误";
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				error = "帐号/密码错误";
			}else if(LockedAccountException.class.getName().equals(exceptionClassName)){
				error = "该帐号被锁定";
			}else if (exceptionClassName != null) {
				error = "其他错误：请联系管理员" ;
			}
			model.addAttribute("error", error);
			return "login";
		}
		SysUser tuser=(SysUser)currentUser.getPrincipal();
		System.out.println("asass"+tuser);
		return "index";
	}
	
	


}
