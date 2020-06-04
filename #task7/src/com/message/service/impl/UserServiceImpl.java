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
	 * @author: �����
	 * @date: 2016��6��21��
	 * @param qq
	 * @return User
	 * @describe�� ͨ��qq��ѯ�û�
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
	 * @author: �����
	 * @date: 2016��6��21��
	 * @param user
	 * @return ע��ɹ�����true,ʧ�ܷ���false
	 * @describe��ע��
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
	 * @author: �����
	 * @date: 2016��6��21��
	 * @param userid
	 * @return User
	 * @describe�� ͨ��idѰ��user
	 */
	@Override
	public User findUserById(int userid) {
		return userMapper.selectByPrimaryKey(userid);
	}
	
	/**
	 * @author: �����
	 * @date: 2016��6��23��
	 * @param user
	 * @return  ���³ɹ�����true,ʧ�ܷ���false
	 * @describe�� �����û���Ϣ
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
		 * @author: �����
		 * @date: 2016��6��24��
		 * @param username
		 * @return User
		 * @describe��ͨ���ǳƲ����û�
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
			 * @author: �����
			 * @date: 2016��6��24��
			 * @param condition
			 * @return  ����һ����ҳ���
			 * @describe��ͨ��qq��������ǳ�����ѯ�û�
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
			pageinfo.setPageSize(6);   //���÷�ҳsizeΪ8
			PageHelper.startPage(currentPage, pageinfo.getPageSize());
			List list=userMapper.selectByExample(example);
			PageInfo<User> pageInfo = new PageInfo<User>(list);  //����ѯ�Ľ������PageInfo�У���װ������ǰ�˻�ȡ����ʹ��
			return pageInfo;
		}

}
