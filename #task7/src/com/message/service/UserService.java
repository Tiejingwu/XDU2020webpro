package com.message.service;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.message.model.User;

public interface UserService {
	/**
	 * @author: �����
	 * @date: 2016��6��21��
	 * @param qq
	 * @return User
	 * @describe�� ͨ��qq��ѯ�û�
	 */
  public User findUserById(int userid);
	/**
	 * @author: �����
	 * @date: 2016��6��21��
	 * @param qq
	 * @return User
	 * @describe�� ͨ��id��ѯ�û�
	 */
  public User findUserByQq(String qq);
	/**
	 * @author: �����
	 * @date: 2016��6��24��
	 * @param username
	 * @return User
	 * @describe��ͨ���ǳƲ����û�
	 */
  public List findUserByUsername(String username);
	/**
	 * @author: �����
	 * @date: 2016��6��24��
	 * @param condition
	 * @return  ����һ����ҳ���
	 * @describe��ͨ��qq��������ǳ�����ѯ�û�
	 */
  public PageInfo findUserByQqOrUsername(String username,String qq,Integer currentPage);
	/**
	 * 
	 * @author: �����
	 * @date: 2016��6��21��
	 * @param user
	 * @return ע��ɹ�����true,ʧ�ܷ���false
	 * @describe��ע��
	 */
  public boolean register(User user);
	/**
	 * @author: �����
	 * @date: 2016��6��23��
	 * @param user
	 * @return  ���³ɹ�����true,ʧ�ܷ���false
	 * @describe�� �����û���Ϣ
	 */
  public boolean updateUser(User user);
}
