package com.message.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Printer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.message.model.Feel;
import com.message.model.Feel;
import com.message.model.Friendmap;
import com.message.model.User;
import com.message.service.FeelService;
import com.message.service.FriendService;
import com.message.service.MessageService;
import com.message.service.UserService;

@Controller
@RequestMapping("user")
public class FeelController {
	@Autowired
	private UserService userService;
	@Autowired
	private FeelService feelService;
	@Autowired
	MessageService messageService;
	@Autowired
	FriendService friendService;
	private final Log logger = LogFactory.getLog(getClass());
	/**
	 * @param receiveid
	 * @describe：查看自己的说说。  userid为说说者id。   currentPage目的为分页
	 */
@RequestMapping("/feelmy")
public ModelAndView showFeelMy(Integer userid,Integer currentPage,HttpSession session){
	ModelAndView mav=new ModelAndView();
	User host=(User)session.getAttribute("host");
	int totalfeels=feelService.feelCount(host.getUserid()); //获取自己的总说说条数和总留言条数，用于主页面说说和留言条数的显示
	if(currentPage==null) currentPage=1;  //如传来的值是空，则显示第一页
	PageInfo result=feelService.showFeels(userid,currentPage);//,查询userid为接收参数的所有说说信息
	List feels=result.getList();  //获取封装在PageInfo中查询出的分页结果集
	result.setList(null); //使得PageInfo结果集中的值为空，以便以下同过数据转换重新封装。如果不置空，则下面会继续在原来的集合上添加内容，以致重复。
	if(feels.size()<=0){   //说说是空的情况下，提示用户
		mav.addObject("feels",null );
		mav.addObject("showFeelback","说说板是空的，快去说说吧" );
	}
	List feelList=new ArrayList();  //用于存放Map集合。Map集合封存了说说者的信息和说说
	for(int i=0;i<feels.size();i++){
		Map feeluser=new HashMap<String, Object>(); //Map集合，封存说说者的信息和说说
		Feel feel=(Feel)feels.get(i);
		String timestring=1900+feel.getFeeltime().getYear()+"年"+(feel.getFeeltime().getMonth()+1)+"月"+feel.getFeeltime().getDate()+"日       "
				+feel.getFeeltime().getHours()+": "+feel.getFeeltime().getMinutes()+": "+feel.getFeeltime().getSeconds();
		feel.setTimestring(timestring);  //将时间格式改变成中国特色的时间格式
		User user1=userService.findUserById(feel.getUserid()); 
		feeluser.put("feel", feel); //说说者的说说
		feeluser.put("user", user1);  //说说者的信息
		feelList.add(feeluser);  //将单个说说者的map集合放置list中
	}
	result.setList(feelList);  //通过对查询结果的转换，重新封装PageInfo的查询结果list
	mav.addObject("allfeels",result);  
	mav.addObject("totalfeels",totalfeels);
	mav.addObject("view","feelmy");  //前端翻页时参数
	if(host.getUserid().equals(userid)){ //传入的id不同，转向的页面也不同
		logger.info(host.getQq()+"查看了自己的说说");
		mav.setViewName("feelmy");   //主人查看自己说说转到的页面
	}else{
		logger.info(host.getQq()+"查看了"+userService.findUserById(userid).getQq()+"的说说");
		mav.setViewName("feelother");  //主人查看自己好友说说转到的页面
	}
	return mav;
}
/**
	 * @param currentPage
	 * @describe：查看所有自己的好友的说说
 */
@RequestMapping("/feelallperson")
public ModelAndView showFeelAllperson(Integer currentPage,HttpSession session){
	ModelAndView mav=new ModelAndView();
	User host=(User)session.getAttribute("host");
	int totalmessages=messageService.messageCount(host.getUserid());
	int totalfeels=feelService.feelCount(host.getUserid()); //获取自己的总说说条数和总留言条数，用于主页面说说和留言条数的显示
	int totalfriends=friendService.selectCountFriend(host.getUserid());
	if(currentPage==null) currentPage=1;  //如传来的值是空，则显示第一页
	PageInfo result=feelService.showFeels(null,currentPage);//,查询userid为接收参数的所有说说信息
	List feels=result.getList();  //获取封装在PageInfo中查询出的分页结果集
	result.setList(null); //使得PageInfo结果集中的值为空，以便以下同过数据转换重新封装。如果不置空，则下面会继续在原来的集合上添加内容，以致重复。
	if(feels.size()<=0){   //说说是空的情况下，提示用户
		mav.addObject("feels",null );
		mav.addObject("showFeelback","说说板是空的，快去说说吧" );
	}
	List feelList=new ArrayList();  //用于存放Map集合。Map集合封存了说说者的信息和说说
	for(int i=0;i<feels.size();i++){
		Map feeluser=new HashMap<String, Object>(); //Map集合，封存说说者的信息和说说
		Feel feel=(Feel)feels.get(i);
		String timestring=1900+feel.getFeeltime().getYear()+"年"+(feel.getFeeltime().getMonth()+1)+"月"+feel.getFeeltime().getDate()+"日       "
				+feel.getFeeltime().getHours()+": "+feel.getFeeltime().getMinutes()+": "+feel.getFeeltime().getSeconds();
		feel.setTimestring(timestring);  //将时间格式改变成中国特色的时间格式
		User user1=userService.findUserById(feel.getUserid()); 
		feeluser.put("feel", feel); //说说者的说说
		feeluser.put("user", user1);  //说说者的信息
		feelList.add(feeluser);  //将单个说说者的map集合放置list中
	}
	result.setList(feelList);  //通过对查询结果的转换，重新封装PageInfo的查询结果list
	mav.addObject("allfeels",result);  
	session.setAttribute("totalfeels",totalfeels);
	session.setAttribute("totalmessages",totalmessages);
	session.setAttribute("totalfriends",totalfriends);
	mav.addObject("view","feelallperson");  //前端翻页时参数
	logger.info(host.getQq()+"已经进入了系统，当前是查看所有人的说说");
	mav.setViewName("feelallperson");
	return mav;
}

/**
 * 
	 * @param Feel
	 * @describe：发表说说。增加一条说说记录
 */
@RequestMapping("/publishFeel")
public ModelAndView publishFeel(Feel feel,HttpSession session){
	 User host=(User)session.getAttribute("host");
	 ModelAndView mav=new ModelAndView();
	 mav.setViewName("redirect:/user/feelmy?userid="+host.getUserid()); //重定向到查询留言界面
	 java.util.Date  date=new java.util.Date();
	 java.sql.Timestamp time=new java.sql.Timestamp(date.getTime()); //插入当前时间
	 feel.setUserid(host.getUserid());
	 feel.setFeeltime(time);
	 boolean leave_suc=feelService.publishFeel(feel);
	 if(leave_suc){
		 logger.info(host.getQq()+"发表了说说");
		 mav.addObject("publish_suc", "发表成功！");
	 }
	 else{
		 logger.info(host.getQq()+"发表说说失败。sql发生错误");
		 mav.addObject("publish_fail", "发表失败！");
	 }
	 return mav;
}
/**
	 * @param messageid
	 * @param receiveid
	 * @param currentPage
	 * @describe：传入的receiveid，currentPage两个参数是为了在重定向时传参之用
	 * 当删除成功 ，跳转到删除时所在查询界面。由于是分页，所以要把当前页currentPage和发表说说人userid传入
 */
@RequestMapping("/deleteFeel")
public ModelAndView deleteFeel(int feelid,Integer userid,Integer currentPage,HttpSession session ,HttpServletResponse response){
	User host=(User)session.getAttribute("host");
	ModelAndView mav=new ModelAndView();
	boolean delete_suc=feelService.deleteFeel(feelid);
	 if(delete_suc){
		 logger.info(host.getQq()+"删除了一条说说");
		 
		 mav.addObject("delete_suc", "删除成功！");
	 }
	 else{
		 mav.addObject("delete_fail", "删除失败！");
	 }
	 mav.setViewName("redirect:/user/feelmy?userid="+host.getUserid()+"&currentPage="+currentPage);
	 return mav;
}


}
