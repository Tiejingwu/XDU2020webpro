package com.message.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.message.model.Friendmap;
import com.message.model.User;
import com.message.service.FriendService;
import com.message.service.UserService;

@Controller
@RequestMapping("user")
public class FriendController {
	@Autowired
	private FriendService friendService;
	@Autowired
	private UserService userService;
	private final Log logger = LogFactory.getLog(getClass());

	/**
	 * 
	 * @param session
	 * @describe：
	 * @return 返回各种状态的好友分组
	 * 显示我的好友列表中的全部好友
	 * 因为数据库设计方式原因，把请求人的id置为userid,被请求人的id置为friendid，所以，当自己被请求时，则会将自己的id置为friendid位置
	 * 在数据库friendmap 表中，状态为1的情况下，在一条好友映射对中，userid,friendid只要出现自己的id号码，
	 * 即认为这个好友映射对 中的另一个id为自己好友id。
	 * 如：userid为自己的id号码，则friendid则是自己的好友的id号码。这种情况说明自己为请求人添加好友
	 * 还如：friendid为自己的id号码，则userid 为好友的id号码。这种情况说明自己为被请求人添加好友
	 * -1:黑名单  0：等待 1：正常好友 
	 */

	@RequestMapping("/showFriends")
	public ModelAndView showFriends(HttpSession session){
		ModelAndView mav=new ModelAndView();
		User host=(User)session.getAttribute("host");  //从session中获取主人的用户信息
		int hostid=host.getUserid();                   //获取主人userid
		List sendfriends= friendService.findFriendMapSend(hostid,1);      //查询出主人为好友请求者的state 为1即正常好友对
		List receivefriends=friendService.findFriendMapReceive(hostid,1); //查询出主人为好友被请求者的state 为1即正常好友对

		List sendblackfriends= friendService.findFriendMapSend(hostid,-1);     //查询出主人为好友请求者state 为-1即黑名单好友对
		List receiveblackfriends=friendService.findFriendMapReceive(hostid,-1);//查询出主人为好友被请求者的state 为-1即黑名单好友对

		List receivewaitfriends=friendService.findFriendMapReceive(hostid,0);//查询出state 为0即自己为被请求方的等待确认接收的用户的好友对
		List allfriendlist=new ArrayList();   
		List blackList=new ArrayList();
		List waitList=new ArrayList();
		allfriendlist=this.collectFriend(sendfriends, receivefriends);//由于查询由两部分构成，故合并。
		blackList=this.collectFriend(sendblackfriends, receiveblackfriends);  //将两部分合并
		waitList=this.collectFriend(null, receivewaitfriends); //等待状态
		mav.addObject("blackList", blackList);   //将结果集放置于model中
		mav.addObject("allfriendlist", allfriendlist);
		mav.addObject("waitList", waitList);
		mav.setViewName("showfriends");
		logger.info(host.getQq()+"查看所有好友");
		return mav;
	}


	/**
	 * @param sendfriends
	 * @param receivefriends
	 * @return 将两种状态的好友合并
	 * @describe： 传入host为请求者时的好友对和别请求者时的好友对，获取其中好友的id，通过id获取好友信息
	 * 将所有的好友信息存入要返回的List列表中
	 */
	public List collectFriend(List sendfriends,List receivefriends){
		List allfriendlist=new ArrayList();
		//将两个列表中的信息提取到一个集合中来
		if(sendfriends!=null){
			for(int i=0;i<sendfriends.size();i++){
				Friendmap friendmap=(Friendmap)sendfriends.get(i);//获取一条好友映射对
				User user1= userService.findUserById(friendmap.getFriendid());//获取这条好友映射对的friendid，即被请求者的用户id
				allfriendlist.add(user1); //放置这个请求者的信息
			}
		}
		if(receivefriends!=null){
			for(int i=0;i<receivefriends.size();i++){
				Friendmap friendmap=(Friendmap)receivefriends.get(i);//获取一条好友映射对
				User user2= userService.findUserById(friendmap.getUserid());//获取这条好友映射对的userid，即被请求者的用户id
				allfriendlist.add(user2); //放置这个被请求者的信息
			}
		}
		return allfriendlist;
	}

	/**
	 * @param friendid  好友
	 * @param session
	 * @describe： 请求好友，不是不是成功成为正常好友，需要等待对方同意，即state由0变为1。
	 */
	@RequestMapping("/askforFriend")
	public ModelAndView askforFriend(Integer friendid,HttpSession session){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("operainforback");
		String friendUsername=userService.findUserById(friendid).getUsername();//获取好友昵称，用于跳转输出必要信息
		User host=(User) session.getAttribute("host");
		Friendmap friendmapexist1=friendService.findFriendmap(friendid,host.getUserid(), 1); //获取数据库中是否存在好友映射值对
		Friendmap friendmapexist2=friendService.findFriendmap(host.getUserid(),friendid, 1);  //获取数据库中是否存在好友映射值对
		Friendmap friendmapreceiveconfirm=friendService.findFriendmap(friendid,host.getUserid(), 0);//获取自己为被请求者状态为0等待状态的好友对，用于判断是否自己曾被"自己将要请求的用户"请求过
		Friendmap friendmapsendconfirm=friendService.findFriendmap(host.getUserid(),friendid, 0);
		Friendmap friendmapblackreceiveconfirm=friendService.findFriendmap(friendid,host.getUserid(), -1);//获取自己为被请求者状态为黑名单状态的好友对
		Friendmap friendmapblacksendconfirm=friendService.findFriendmap(host.getUserid(),friendid, -1);//获取自己为请求者状态为黑名单状态的好友对
		/*判断添加的好友是否是自己
		 *若存在，则返回提示  “不能添加自己为好友！”
		 **/
		if(friendid.equals(host.getUserid())){
			mav.addObject("askfor_fail", "不能添加自己为好友！");
		}
		/*获取数据库中是否存在好友映射值对
		 *若存在，则返回提示  “对方已在您的好友列表中，无需添加！”
		 **/
		else if(friendmapexist1!=null||friendmapexist2!=null){
			mav.addObject("askfor_fail", friendUsername+" 已在您的好友列表中，无需添加！");
		}

		/*获取数据库中是否存在未确认的好友请求，避免在未确认状态下双方互相好友请求是数据库出现不必要的数据映射对，
		 * 若存在，则返回提示  “对方已经向您发起了请求，请先处理！”
		 * */

		else if(friendmapreceiveconfirm!=null){
			mav.addObject("askfor_fail", friendUsername+"  已经向您发起了请求，请先处理！");
		}
		/*
		 * 获取数据库中是否存在自己请求过的记录，
		 * 若存在，则返回提示“您曾经请求过，请等待对方确认！”
		 */

		else if(friendmapsendconfirm!=null){
			mav.addObject("askfor_fail","您曾经请求过，请等待对方确认！");
		}

		else if(friendmapblackreceiveconfirm!=null||friendmapblacksendconfirm!=null){
			mav.addObject("askfor_fail","他是您黑名单中的成员，请您到黑名单中恢复为正常好友！");
		}
		/*
		 * 添加到数据库好友请求,将好友状态置为0,即等待确认状态
		 * 若成功，则返回提示“请求成功，请等待对方接受。”
		 */
		else{
			Friendmap friendmap=new Friendmap();
			friendmap.setFriendid(friendid);
			friendmap.setUserid(host.getUserid());
			friendmap.setState(0);  //将状态置为0,表示请求等待
			java.util.Date  date=new java.util.Date();
			java.sql.Timestamp time=new java.sql.Timestamp(date.getTime()); //插入当前时间
			friendmap.setAddtime(time);  //设置请求时间。这里不为添加成功时间。如果对方确认，则更新时间后为添加时间
			boolean askfor_suc=friendService.askforFriend(friendmap);
			if(askfor_suc){
				logger.info(host.getQq()+"向"+userService.findUserById(friendid).getQq()+"好友的好友请求");
				mav.addObject("askfor_suc", "请求成功，请等待  "+ friendUsername+" 接受");
			}else{
				mav.addObject("askfor_fail", "请求失败，服务器正在维修！");
			}
		}
		return mav;
	}
	/**
	 * @param friendid  好友
	 * @param session
	 * @describe： 恢复黑名单好友，原理：删除原有的好友对，调用 请求方法
	 */
	@RequestMapping("/regainFriend")
	public ModelAndView regainFriend(Integer friendid,HttpSession session){
		ModelAndView mav=new ModelAndView();      //创建一个ModelAndView 实例对象
		User host=(User) session.getAttribute("host");
		Friendmap friendmapblackreceiveconfirm=friendService.findFriendmap(friendid,host.getUserid(), -1);//获取自己为被请求者状态为黑名单状态的好友对
		Friendmap friendmapblacksendconfirm=friendService.findFriendmap(host.getUserid(),friendid, -1);//获取自己为请求者状态为黑名单状态的好友对

			if(friendmapblackreceiveconfirm!=null){
				boolean delete_suc= friendService.deleteFriendmap(friendmapblackreceiveconfirm.getFriendmapid());
				if(delete_suc){
					logger.info(host.getQq()+"向"+userService.findUserById(friendid).getQq()+"好友的好友请求");
					mav.setViewName("redirect:/user/askforFriend?friendid="+friendid); //重定向到请求 控制器
					} 
				else{
					mav.addObject("delete_fail", "服务器正在维护，请稍后！");
					mav.setViewName("operainforback");
				}
			}
			else if(friendmapblacksendconfirm!=null){
				boolean delete_suc=friendService.deleteFriendmap(friendmapblacksendconfirm.getFriendmapid());
				if(delete_suc){
					 mav.setViewName("redirect:/user/askforFriend?friendid="+friendid);  //重定向到请求 控制器
				} 
				else{
					mav.addObject("delete_fail", "服务器正在维护，请稍后！");
					mav.setViewName("operainforback");
				}
			}
			else{
				logger.info(host.getQq()+"向"+userService.findUserById(friendid).getQq()+"好友的好友请求,请求失败！原因：sql错误");
				mav.addObject("delete_fail", "服务器正在维护，请稍后！");
				mav.setViewName("operainforback");
			}
		return mav;

	}

	/**
	 * @param userid
	 * @param session
	 * @describe： 接受好友请求，即将state由0变为1
	 */
	@RequestMapping("/agreeFriend")
	public ModelAndView agreeFriend(@RequestParam(value="userid")Integer friendid,HttpSession session){
		ModelAndView mav=new ModelAndView();      //创建一个ModelAndView 实例对象
		User host=(User) session.getAttribute("host");   //获取主人userid，用于联合friendid查询好友对
		String friendUsername=userService.findUserById(friendid).getUsername();//获取好友昵称，用于跳转输出必要信息
		Friendmap friendmap=friendService.findFriendmap( friendid, host.getUserid(),0);	//获取好友映射对中自己为被请求者身份的好友映射对
		if(friendmap!=null){   
			friendmap.setState(1);          //将等待状态更改为正常好友状态
			 java.util.Date  date=new java.util.Date();
			 java.sql.Timestamp time=new java.sql.Timestamp(date.getTime()); //插入当前时间
			friendmap.setAddtime(time);
			boolean agree_suc=friendService.updateFriendmap(friendmap);
			if(agree_suc){
				logger.info(host.getQq()+"向"+userService.findUserById(friendid).getQq()+"好友的好友请求");
				mav.addObject("agree_suc","已成功接受"+friendUsername+"的请求！");
			}
			else{
				mav.addObject("agree_fail","服务器正在维护，请稍后！");
			}
		}
		else{
			mav.addObject("agree_fail","服务器正在维护，请稍后！");
		}
		mav.setViewName("operainforback");
		return mav;

	}

	/**
	 * @param userid
	 * @param session
	 * @describe： 拒绝好友请求，即删除一个好友对。 //获取主人userid，用于联合friendid查询好友对，然后删除好友对
	 */
	@RequestMapping("/refuseFriend")
	public ModelAndView refuseFriend(@RequestParam(value="userid")Integer friendid,HttpSession session){
		ModelAndView mav=new ModelAndView();  //创建一个ModelAndView 实例对象
		User host=(User) session.getAttribute("host");    //获取主人userid，用于联合friendid查询好友对，然后删除好友对
		String friendUsername=userService.findUserById(friendid).getUsername();//获取好友昵称，用于跳转输出必要信息
		Friendmap friendmap=friendService.findFriendmap(friendid, host.getUserid(),0);	//获取好友映射对中自己为被请求者身份的好友映射对
		if(friendmap!=null){   //为出错的情况下，查询到该状态为0的好友 对
			boolean agree_suc=friendService.deleteFriendmap(friendmap.getFriendmapid());//删除操作
			if(agree_suc){
				logger.info(host.getQq()+"拒绝了"+userService.findUserById(friendid).getQq()+"好友的好友请求！");
				mav.addObject("refuse_suc","您拒绝了 "+friendUsername+" 的请求！");
			}
			else{
				mav.addObject("refuse_fail","服务器正在维护，请稍后！");  //如果删除失败，返回友好提示信息
			}
		}
		else{
			mav.addObject("refuse_fail","服务器正在维护，请稍后！");
		}
		mav.setViewName("operainforback");
		return mav;
	}

	/**
	 * @param userid
	 * @param session
	 * @describe： 拉黑，即更新一个好友对，使好友状态由1变成-1
	 */
	@RequestMapping("/blackFriend")
	public ModelAndView blackFriend(@RequestParam(value="userid")Integer friendid,HttpSession session){
		ModelAndView mav=new ModelAndView();
		User host=(User) session.getAttribute("host");   //获取主人userid，用于联合friendid查询好友对，然后更新好友对
		String friendUsername=userService.findUserById(friendid).getUsername();//获取好友昵称，用于跳转输出必要信息
		Friendmap friendmap=friendService.findFriendmap(friendid, host.getUserid(),1);	//获取好友映射对中自己为被请求者身份的好友映射对
		Friendmap friendmap1=friendService.findFriendmap(host.getUserid(),friendid, 1);	//获取好友映射对中自己为被请求者身份的好友映射对
		if(friendmap1!=null){
			friendmap1.setState(-1);    //将正常状态状态更改为拉黑好友状态
			boolean black_suc=friendService.updateFriendmap(friendmap1);  //更新操作
			if(black_suc){
				logger.info(host.getQq()+"拉黑了"+userService.findUserById(friendid).getQq()+"！");
				mav.addObject("black_suc","您拉黑了"+friendUsername+"！");
			}
			else{
				mav.addObject("black_fail","服务器正在维护，请稍后！");
			}
		}
		if(friendmap!=null){
			friendmap.setState(-1);    //将正常状态状态更改为拉黑好友状态
			boolean black_suc=friendService.updateFriendmap(friendmap);   //更新操作
			if(black_suc){
				logger.info(host.getQq()+"拉黑了"+userService.findUserById(friendid).getQq()+"！");
				mav.addObject("black_suc","您拉黑了"+friendUsername+"！");
			}
			else{
				mav.addObject("black_fail","服务器正在维护，请稍后！");
			}
		}
		mav.setViewName("operainforback");
		return mav;
	}

	/**
	 * @param userid
	 * @param session
	 * @describe： 删除好友，即删除state为1的一个好友对
	 */
	@RequestMapping("/deleteFriend")
	public ModelAndView deleteFriend(@RequestParam(value="userid")Integer friendid,HttpSession session){
		ModelAndView mav=new ModelAndView();
		User host=(User) session.getAttribute("host");
		String friendUsername=userService.findUserById(friendid).getUsername();//获取好友昵称，用于跳转输出必要信息
		Friendmap friendmap=friendService.findFriendmap(friendid, host.getUserid(),1);	//获取好友映射对中自己为被请求者身份的好友映射对
		Friendmap friendmap1=friendService.findFriendmap(host.getUserid(),friendid, 1);	//获取好友映射对中自己为被请求者身份的好友映射对
		if(friendmap1!=null){
			boolean delete_suc=friendService.deleteFriendmap(friendmap1.getFriendmapid());
			if(delete_suc){
				logger.info(host.getQq()+"删除了"+userService.findUserById(friendid).getQq()+"！");
				mav.addObject("delete_suc","您删除了"+friendUsername+"！");
			}
			else{
				mav.addObject("delete_fail","服务器正在维护，请稍后！");
			}
		}
		if(friendmap!=null){
			boolean delete_suc=friendService.deleteFriendmap(friendmap.getFriendmapid());
			if(delete_suc){
				mav.addObject("delete_suc","您删除了"+friendUsername+"！");
			}
			else{
				mav.addObject("delete_fail","服务器正在维护，请稍后！");
			}
		}
		mav.setViewName("operainforback");
		return mav;
	}

	/**
	 * @param userid
	 * @param session
	 * @describe： 删除黑名单好友，即删除一个state为-1的好友对
	 */
	@RequestMapping("/deleteblackFriend")
	public ModelAndView deleteblackFriend(@RequestParam(value="userid")Integer friendid,HttpSession session){
		ModelAndView mav=new ModelAndView();
		User host=(User) session.getAttribute("host");
		String friendUsername=userService.findUserById(friendid).getUsername();//获取好友昵称，用于跳转输出必要信息
		Friendmap friendmap=friendService.findFriendmap(friendid, host.getUserid(),-1);	//获取好友映射对中自己为被请求者身份的好友映射对
		Friendmap friendmap1=friendService.findFriendmap(host.getUserid(),friendid, -1);	//获取好友映射对中自己为被请求者身份的好友映射对
		if(friendmap1!=null){
			boolean delete_suc=friendService.deleteFriendmap(friendmap1.getFriendmapid());
			if(delete_suc){
				logger.info(host.getQq()+"删除了黑名单好友"+userService.findUserById(friendid).getQq()+"！");
				mav.addObject("delete_suc","您删除了"+friendUsername+"！");
			}
			else{
				mav.addObject("delete_fail","服务器正在维护，请稍后！");
			}
		}
		if(friendmap!=null){
			boolean delete_suc=friendService.deleteFriendmap(friendmap.getFriendmapid());
			if(delete_suc){
				logger.info(host.getQq()+"删除了黑名单好友"+userService.findUserById(friendid).getQq()+"！");
				mav.addObject("delete_suc","您删除了"+friendUsername+"！");
			}
			else{
				mav.addObject("delete_fail","服务器正在维护，请稍后！");
			}
		}
		mav.setViewName("operainforback");
		return mav;
	}


}
