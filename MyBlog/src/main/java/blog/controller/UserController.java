package blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import blog.entity.Article;
import blog.entity.ArticleType;
import blog.entity.PageBean;
import blog.entity.User;
import blog.service.UserService;


@Controller
public class UserController {
	
	@Resource //依赖注入
    private UserService userService;
	
	@RequestMapping(value="/login")
	public String Login(){
		return "admin/login";
	}
	
	/**
	 * 判断登录
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/doLogin",method = RequestMethod.POST)
	public String doLogin(User user,HttpServletRequest req){
		HttpSession session=req.getSession();
		User existUser = userService.login(user);
		System.out.println("博客主页登录成功");
		if(existUser!=null){
			session.setAttribute("username",existUser.getUsername());
			return "admin/background";
		}
		return "redirect:login";
	}
	
	/**
	 * 退出登录
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/SignOut")
	public String SignOut(HttpServletRequest req){
		HttpSession session=req.getSession(false);
		session.removeAttribute("username");
		return "redirect:login";
	}
	
	/**
	 * 修改个人联系信息
	 * @return
	 */
	@RequestMapping(value = "/doModify")
	public String modify(ModelMap map){
		User user = userService.findUser(1);
		map.put("user", user);
		System.out.println("user,查找成功");
		return "admin/dataModify";
	}
	/**
	 * 修改普通资料
	 * @param user
	 * @return
	 */
	@RequestMapping(value= "/updateUser")
	public String updateUserdata(User user){
		User u = userService.findUser(user.getId());
		userService.updateUser(u);
		return "admin/dataModify";
	}
	
	
	/**
	 * 查询个人联系信息
	 * @return
	 */
	@RequestMapping(value = "/doUser/{role}/{path}")
	public String doUser(@PathVariable String role,@PathVariable String path,ModelMap map){
		User user = userService.findUser(1);
		userService.updateUserPassword(user);
		map.put("user", user);
		System.out.println("user,更新密码成功");
		return role+"/"+path;
	}
	/**
	 * 修改账号密码
	 * @param user
	 * @return
	 */
	@RequestMapping(value= "/updateUserPassword")
	public String updateUserP(User user){	
		userService.updateUserPassword(user);
		System.out.print("密码更新成功");
		return "admin/userModify";
	}

	/**
	 * 页面跳转前台
	 * @return
	 */
	@RequestMapping(value = "/doHome")
	public String doHome(){
		return "blog/home";
	}
	@RequestMapping(value = "/doArticle")
	public String doArticle(){
		System.out.println("article登录成功");
		return "blog/article";
	}
	
//	@RequestMapping(value = "/doDemo")
//	public String doDemo(){
//		System.out.println("demo登录成功");
//		return "blog/demo";
//	}
}


