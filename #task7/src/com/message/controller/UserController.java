package com.message.controller;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.message.mapper.FriendmapMapper;
import com.message.model.Friendmap;
import com.message.model.FriendmapExample;
import com.message.model.FriendmapExample.Criteria;
import com.message.model.User;
import com.message.service.FriendService;
import com.message.service.UserService;
import com.message.util.DigestUtil;
import com.sun.mail.smtp.DigestMD5;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private FriendService friendService;
	@Autowired
	private FriendmapMapper friendmap;
	private final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping("/login")
	public String tologin(){
		return "login";
	}
	/**
	 * @param qq
	 * @param password
	 * @return ModelAndView 
	 * @describe：使用MD5算法对密码进行加密，登陆验证
	 */
	@RequestMapping("/loginvalid")
	public ModelAndView loginvalid(User user,HttpSession session) throws NoSuchAlgorithmException{
		User host=userService.findUserByQq(user.getQq());  //通过qq查询是否存在此用户
		ModelAndView mav=new ModelAndView();  //实例化一个ModelAndView对象
		mav.setViewName("login");    // 初始化逻辑视图为login.jsp
		if(host!=null){
			//将前端传来的值通过MD5加密进行对比
			boolean suc=host.getPassword().equals(DigestUtil.getMD5(user.getPassword().getBytes()));
			if(suc){
				mav.addObject("login_suc", "登陆成功");
				session.setAttribute("host", host);  //将用户信息存入session
				 java.util.Date  date=new java.util.Date();
				 java.sql.Timestamp time=new java.sql.Timestamp(date.getTime()); //插入当前时间
				 User user1=new User();
				 user1.setLastvisit(time);   
				 userService.updateUser(user1);  //设置用户的最后一次登录时间
				 logger.info("QQ号码为："+host.getQq()+"的用户登陆系统");
				mav.setViewName("redirect:/user/feelallperson");   //若登陆成功，转到主页面
			}
			else{
				mav.addObject("login_fail", "密码错误");
			}
		}
		else{
			mav.addObject("login_fail", "账号不存在");
		}
		return mav;
	}
   
  /**
  	 * @param userid
  	 * @return  返回所查询的用户信息
  	 * @describe：通过前端传来的userid,查询其好友的用户信息
   */
	@RequestMapping("/showinfor")
	public ModelAndView showinfo(@RequestParam(value="friendid")int userid,HttpSession session){
		ModelAndView mav=new ModelAndView();
		User user=userService.findUserById(userid);  //获取好友的用户信息
		String birthdayString=1900+user.getBirthday().getYear()+"年"+(user.getBirthday().getMonth()+1)+"月"+user.getBirthday().getDate()+"日    ";
		user.setBirthdayString(birthdayString);  //将时间格式改变成中国特色的时间格式
		User host=(User)session.getAttribute("host");  //获取自己的用户信息，用于查找自己和好友的联系
		FriendmapExample example=new FriendmapExample();  
		Criteria criteria=example.createCriteria();  
		criteria.andUseridEqualTo(userid);
		criteria.andFriendidEqualTo(host.getUserid()); //当自己为被请求人时的好友对
		
		Criteria criteria2=example.createCriteria();  
		criteria2.andFriendidEqualTo(userid);  
		criteria2.andUseridEqualTo(host.getUserid());  //当自己为请求人时的好友对
		example.or(criteria2);    //做or查询
		 //or语句。相当于select  state from friendmap WHERE ( userid = '5'  ) or( friendid = '5'  )   
		int state=friendmap.selectStateByExample(example);
		Friendmap friendm=(Friendmap)friendmap.selectByExample(example).get(0);
		String addfriendtimeString=1900+friendm.getAddtime().getYear()+"年"+(friendm.getAddtime().getMonth()+1)+"月"+friendm.getAddtime().getDate()+"日       "
				+friendm.getAddtime().getHours()+": "+friendm.getAddtime().getMinutes()+": "+friendm.getAddtime().getSeconds();
		mav.addObject("state", state);  //设置状态信息，用于在前端判断对不同的好友拥有的不同的权限
		mav.addObject("user", user);
		mav.addObject("addfriendtimeString",addfriendtimeString);
		mav.setViewName("friendinfo");
		//日志管理
		logger.info("QQ号码为："+host.getQq()+"的用户查看了好友"+user.getQq()+"的基本信息");
		return mav;
	}
	/* 
 	 * @param userid
 	 * @return  返回所查询的自己的用户信息
 	 * @describe：通过前端传来的userid,查询自己的基本信息
  */
	@RequestMapping("/showhostinfor")
	public ModelAndView showinfo(HttpSession session){
		User host=(User)session.getAttribute("host");
		ModelAndView mav=new ModelAndView();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		  String birthdayString = formatter.format(host.getBirthday());
		host.setBirthdayString(birthdayString);  //将时间格式改变成中国特色的时间格式
		String lastvisitString=1900+host.getLastvisit().getYear()+"年"+(host.getLastvisit().getMonth()+1)+"月"+host.getLastvisit().getDate()+"日       "
				+host.getLastvisit().getHours()+": "+host.getLastvisit().getMinutes()+": "+host.getLastvisit().getSeconds();
		
		host.setLastvisitString(lastvisitString);  //将时间格式改变成中国特色的时间格式
		mav.addObject("host", host);
		mav.setViewName("index");
		logger.info("QQ号码为："+host.getQq()+"的用户查看了自己的基本信息");
		return mav;
	}
	
	/**
		 * @param selectcontent ：查询内容
		 * @param selectmethod ：查询方式
		 * @param currentPage
		 * @describe： 查找好友，通过昵称和qq号码查询。
	 */
	@RequestMapping("/findFriend")
	public ModelAndView findFriend(String selectcontent,String selectmethod,Integer currentPage,HttpSession session ){
		ModelAndView mav=new ModelAndView();
		User host=(User)session.getAttribute("host");
		if(selectcontent!=null&&selectmethod!=null){   //查询内容和方法都不为空的情况下
			logger.info("QQ号码为："+host.getQq()+"的用户通过用户名查找了："+selectmethod+"的用户");
			if(currentPage==null) currentPage=1;  //如传来的值是空，则显示第一页
			PageInfo result;  
			if(selectmethod.equals("username")){
				 result=userService.findUserByQqOrUsername(selectcontent, null, currentPage);  //接收好友结果分页信息
			}else{
				logger.info("QQ号码为："+host.getQq()+"的用户查看了自己的基本信息");
				 result=userService.findUserByQqOrUsername(null,selectcontent, currentPage);//接收好友结果分页信息
			}
			mav.addObject("friendresult", result);
			if(result.getList().size()<=0){
				mav.addObject("resultisnull", "没有查询到此用户！");
				logger.info("QQ号码为："+host.getQq()+"的用户通过用户名查找了昵称为："+selectmethod+"的好友。结果：未查找到");
			}
		}
		mav.setViewName("askforfriend");
		return mav;
	}
	
	@RequestMapping("/logOut")
	public String logOut(HttpSession session){
		User host=(User)session.getAttribute("host");
		logger.info("QQ号码为："+host.getQq()+"的用户通过退出了系统");
		session.invalidate();  //将存在session中所有信息抹去
		return "redirect:/user/login";
	}
	@RequestMapping("/tomodifyInfor")
	public String tomidifyInfor(){
		return "modifyInfor";
	}
	
}
