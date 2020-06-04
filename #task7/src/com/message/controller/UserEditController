package com.message.controller;

import java.io.File;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.message.model.User;
import com.message.service.UserService;
import com.message.util.DigestUtil;
@Controller
@RequestMapping("/user")
public class UserEditController {
	@Autowired
	private UserService userService;
	private final Log logger = LogFactory.getLog(getClass());
	/**
	 * @param user
	 * @return ModelAndView
	 * @describe：mybatis文件中，将前端传来的密码通过MD5进行加密，更安全
	 * state 状态为1，表示正常，0表示冻结
	 */
	@RequestMapping("/registervalid")
	public ModelAndView registervalid(User user){
		ModelAndView mav=new ModelAndView();  //实例化一个ModelAndView对象
		mav.setViewName("register_suc");   // 初始化逻辑视图为register_suc.jsp
		String qq=(System.currentTimeMillis()+"").substring(3,13);  //qq号码由时间随机生成。
		if(userService.findUserByQq(qq)!=null){  //如果发生qq生成错误错误，则重新生成
			logger.info("qq生成错误：原因：生成重复");
			this.registervalid(user);
		}
		user.setQq(qq);  //设置qq
		user.setHeadpic("defaultheadpic.jpg");  //设置默认头像
		user.setState(1);  //标志状态为1,正常状态
		if(userService.register(user)){
			logger.info(user.getUsername()+"注册成功。QQ为"+qq);
			mav.addObject("user", user);  //注册成功转到页面为初始化页面即register_suc.jsp
		}else{
			logger.info(user.getUsername()+"注册成功。原因：sql语句发生错误");
			mav.addObject("register_fail","注册失败。原因：内部服务器发生错误，请稍后再进行注册");
			mav.setViewName("register");  //若注册失败转到注册页面重新注册
		}
		return mav;
	}
	/**
	 * @param user
	 * @return ModelAndView
	 */
	@RequestMapping("/modifyInfor")
	public ModelAndView modifyInfor(User user,HttpSession session){
		ModelAndView mav=new ModelAndView();  //实例化一个ModelAndView对象
		User host=(User) session.getAttribute("host");
		mav.setViewName("hostinfor");   // 初始化逻辑视图为modify_suc.jsp
		user.setUserid(host.getUserid());
		if(userService.updateUser(user)){
			logger.info(user.getQq()+"修改了基本信息");
			mav.addObject("modify_suc", "修改成功"); 
			User user1=userService.findUserById(host.getUserid());
			session.setAttribute("host", user1);
		}else{
			logger.info(user.getQq()+"修改基本信息修改失败。原因：sql语句错误");
			mav.addObject("modify_fail","修改失败。原因：内部服务器正在维护，请稍后再进行修改");
			mav.setViewName("modifyInfor");  //若注册失败转到修改页面重新修改
		}
		return mav;
		
	}
	/**
		 * @param oldpassword 原始密码
		 * @param password 新密码
		 * @param repassword 新密码重复
		 * @param session
		 * @throws NoSuchAlgorithmException
		 * @describe： 修改密码
	 */
	@RequestMapping("/modifyPass")
	public ModelAndView modifyPass(String oldpassword,String password,String repassword,HttpSession session) throws NoSuchAlgorithmException{
		ModelAndView mav=new ModelAndView();  //实例化一个ModelAndView对象
		User host=(User) session.getAttribute("host");
		User user=new User();
		if(!host.getPassword().equals(DigestUtil.getMD5(oldpassword.getBytes()))){
			mav.addObject("modifypass_fail","原始密码输入错误");
			mav.setViewName("modifyInfor");  //若输入错误转到修改页面重新修改
		}
		else{
	    	user.setUserid(host.getUserid());
	    	user.setPassword(password);
			if(userService.updateUser(user)){
				session.invalidate();
				logger.info(user.getQq()+"修改了密码");
				mav.setViewName("redirect:/user/login");
			}else{
				logger.info(user.getQq()+"修改密码修改失败。原因：sql语句错误");
				mav.addObject("modify_fail","修改失败。原因：内部服务器正在维护，请稍后再进行注册");
				mav.setViewName("modifyInfor");  //若注册失败转到修改页面重新修改
			}
		}
		return mav;
	}
	
	/**
		 * @param file
		 * @param request
		 * @param session
		 * @describe：上传文件，头像
	 */
	   @RequestMapping(value = "/updateheadpic")  
	    public ModelAndView upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,HttpSession session) {  
		   ModelAndView mav=new ModelAndView();
		   User host=(User) session.getAttribute("host");
	        String path =request.getSession().getServletContext().getRealPath("headpic");  
	        System.out.println(path);
	        String fileName = file.getOriginalFilename();  //获得图片名字
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	        //保存  
	        try {  
	            file.transferTo(targetFile);  
	            User user=new User();
	            user.setUserid(host.getUserid());
		    	user.setHeadpic(fileName);
		    	if(userService.updateUser(user)){
		    		logger.info(user.getQq()+"修改了头像");
					mav.addObject("modify_suc", "修改成功"); 
					User user1=userService.findUserById(host.getUserid());
					session.setAttribute("host", user1);
					mav.setViewName("redirect:/user/feelallperson");
				}else{
					mav.addObject("modify_fail","修改失败。原因：内部服务器正在维护，请稍后再进行修改");
					mav.setViewName("updateheadpic");  //若注册失败转到修改页面重新修改
				}
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return mav;  
	    }  
		
}
