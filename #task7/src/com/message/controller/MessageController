package com.message.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.message.model.Message;
import com.message.model.User;
import com.message.service.MessageService;
import com.message.service.UserService;

@Controller
@RequestMapping("user")
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	private final Log logger = LogFactory.getLog(getClass());
	
		/**
		 * @param receiveid
		 * @describe：查看留言。  receiveid为被留言者id。   currentPage目的为分页
		 */
	@RequestMapping("/showMessages")
	public ModelAndView showMessages(Integer receiveid,Integer currentPage,HttpSession session){
		ModelAndView mav=new ModelAndView();
		User host=(User)session.getAttribute("host");
		int totalmessages=messageService.messageCount(receiveid); //获取在没有分页情况下所有记录条数，用于前端获取留言总楼层数
		if(currentPage==null) currentPage=1;  //如传来的值是空，则显示第一页
		PageInfo result=messageService.showMessages(receiveid,currentPage);//,查询receiceid为接收参数的所有留言信息
		List messages=result.getList();  //获取封装在PageInfo中查询出的分页结果集
		result.setList(null); //使得PageInfo结果集中的值为空，以便以下同过数据转换重新封装。如果不置空，则下面会继续在原来的集合上添加内容，以致重复。
		if(messages.size()<=0){   //留言是空的情况下，提示用户
			mav.addObject("messages",null );
			mav.addObject("showMessageback","留言板是空的，快去留言吧" );
		}
		List messageList=new ArrayList();  //用于存放Map集合。Map集合封存了留言者的信息和留言
		for(int i=0;i<messages.size();i++){
			Map messageuser=new HashMap<String, Object>(); //Map集合，封存留言者的信息和留言
			Message message=(Message)messages.get(i);
			String timestring=1900+message.getMessagetime().getYear()+"年"+(message.getMessagetime().getMonth()+1)+"月"+message.getMessagetime().getDate()+"日       "
					+message.getMessagetime().getHours()+": "+message.getMessagetime().getMinutes()+": "+message.getMessagetime().getSeconds();
			message.setTimestring(timestring);  //将时间格式改变成中国特色的时间格式
			User user1=userService.findUserById(message.getSenderid()); //查询留言者的信息
			messageuser.put("message", message); //留言者的留言
			messageuser.put("user", user1);  //留言者的信息
			messageList.add(messageuser);  //将单个留言者的map集合放置list中
		}
		result.setList(messageList);  //通过对查询结果的转换，重新封装PageInfo的查询结果list
		mav.addObject("allmessages",result);  
		mav.addObject("totalmessages",totalmessages);
		mav.addObject("receiver", userService.findUserById(receiveid));  //将被留言者的id传到前台接收
		if(host.getUserid().equals(receiveid)){ //传入的id不同，转向的页面也不同
			logger.info(host.getQq()+"查看了自己的留言");
			mav.setViewName("message");   //主人查看自己的留言转到的页面
		}else{
			logger.info(host.getQq()+"查看了好友"+userService.findUserById(receiveid).getQq()+"+的留言");
			mav.setViewName("messageother");  //主人查看自己好友留言转到的页面
		}
		return mav;
	}
	/**
	 * 
		 * @param message
		 * @describe：留言。增加一条留言记录
	 */
	@RequestMapping("/leaveMessage")
	public ModelAndView leaveMessage(Message message){
		 ModelAndView mav=new ModelAndView();
		 mav.setViewName("redirect:/user/showMessages?receiveid="+message.getReceiveid()); //重定向到查询留言界面
		 java.util.Date  date=new java.util.Date();
		 java.sql.Timestamp time=new java.sql.Timestamp(date.getTime()); //插入当前时间
		 message.setMessagetime(time);
		 message.setParentmessageid(0);  //设置信息父id为0，表示不为回复内容
		 boolean leave_suc=messageService.leaveMessage(message);
		 if(leave_suc){
			 mav.addObject("leave_suc", "留言成功！");
		 }
		 else{
			 mav.addObject("leave_fail", "留言失败！");
		 }
		 return mav;
	}
	/**
		 * @param messageid
		 * @param receiveid
		 * @param currentPage
		 * @describe：传入的receiveid，currentPage两个参数是为了在重定向时传参之用
		 * 当删除成功 ，跳转到删除时所在查询界面。由于是分页，所以要把当前页currentPage和被留言人receiveid传入
	 */
	@RequestMapping("/deleteMessage")
	public ModelAndView deleteMessage(int messageid,Integer receiveid,Integer currentPage,HttpSession session ){
		ModelAndView mav=new ModelAndView();
		User host=(User)session.getAttribute("host");
		boolean delete_suc=messageService.deleteMessage(messageid);
		 if(delete_suc){
			 logger.info(host.getQq()+"删除了一条留言");
			 mav.addObject("delete_suc", "删除成功！");
		 }
		 else{
			 mav.addObject("delete_fail", "删除失败！");
		 }
		 mav.setViewName("redirect:/user/showMessages?receiveid="+receiveid+"&currentPage="+currentPage);
		 return mav;
	}
	
  
}
