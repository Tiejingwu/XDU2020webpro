package com.message.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.message.model.User;

public interface UserService {
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月21日
	 * @param qq
	 * @return User
	 * @describe： 通过qq查询用户
	 */
  public User findUserById(int userid);
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月21日
	 * @param qq
	 * @return User
	 * @describe： 通过id查询用户
	 */
  public User findUserByQq(String qq);
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月24日
	 * @param username
	 * @return User
	 * @describe：通过昵称查找用户
	 */
  public List findUserByUsername(String username);
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月24日
	 * @param condition
	 * @return  返回一个分页结果
	 * @describe：通过qq号码或者昵称来查询用户
	 */
  public PageInfo findUserByQqOrUsername(String username,String qq,Integer currentPage);
	/**
	 * 
	 * @author: 霍光恩
	 * @date: 2016年6月21日
	 * @param user
	 * @return 注册成功返回true,失败返回false
	 * @describe：注册
	 */
  public boolean register(User user);
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月23日
	 * @param user
	 * @return  更新成功反回true,失败返回false
	 * @describe： 更新用户信息
	 */
  public boolean updateUser(User user);
}
