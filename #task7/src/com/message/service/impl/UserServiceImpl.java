package com.message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.message.mapper.UserMapper;
import com.message.model.User;
import com.message.model.UserExample;
import com.message.model.UserExample.Criteria;
import com.message.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	/**
	 * 
	 * @author: 霍光恩
	 * @date: 2016年6月21日
	 * @param qq
	 * @return User
	 * @describe： 通过qq查询用户
	 */
	@Override
	public User findUserByQq(String qq) {
		UserExample example=new UserExample();
		Criteria criteria=example.createCriteria();
		criteria.andQqEqualTo(qq);
		List<User> list=userMapper.selectByExample(example);
		if(list.size()<=0)return null;
		else
			return (User)list.get(0);
	}
	/**
	 * 
	 * @author: 霍光恩
	 * @date: 2016年6月21日
	 * @param user
	 * @return 注册成功返回true,失败返回false
	 * @describe：注册
	 */
	@Override
	public boolean register(User user) {
		int n=userMapper.insertSelective(user);
		if(n!=0)
			return true;
		else 
			return false;
	}
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月21日
	 * @param userid
	 * @return User
	 * @describe： 通过id寻找user
	 */
	@Override
	public User findUserById(int userid) {
		return userMapper.selectByPrimaryKey(userid);
	}
	
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月23日
	 * @param user
	 * @return  更新成功反回true,失败返回false
	 * @describe： 更新用户信息
	 */
	@Override
	public boolean updateUser(User user) {
		int n=userMapper.updateByPrimaryKeySelective(user);
		if(n!=0)
			return true;
		else 
			return false;
	}
		/**
		 * @author: 霍光恩
		 * @date: 2016年6月24日
		 * @param username
		 * @return User
		 * @describe：通过昵称查找用户
		 */
	@Override
	public List findUserByUsername(String username) {
		UserExample example=new UserExample();
		Criteria criteria=example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> list=userMapper.selectByExample(example);
		return list;
	}
			/**
			 * @author: 霍光恩
			 * @date: 2016年6月24日
			 * @param condition
			 * @return  返回一个分页结果
			 * @describe：通过qq号码或者昵称来查询用户
			 */
		@Override
		public PageInfo findUserByQqOrUsername(String username,String qq,Integer currentPage) {
			UserExample example=new UserExample();
			Criteria criteria=example.createCriteria();
			if(username!=null){
				criteria.andUsernameEqualTo(username);
			}
			if(qq!=null){
				criteria.andQqEqualTo(qq);
			}
			PageInfo pageinfo=new PageInfo();
			pageinfo.setPageSize(6);   //设置分页size为8
			PageHelper.startPage(currentPage, pageinfo.getPageSize());
			List list=userMapper.selectByExample(example);
			PageInfo<User> pageInfo = new PageInfo<User>(list);  //将查询的结果放入PageInfo中，封装起来供前端获取数据使用
			return pageInfo;
		}

}
