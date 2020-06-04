package com.message.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.message.mapper.FriendmapMapper;
import com.message.mapper.UserMapper;
import com.message.model.Friendmap;
import com.message.model.FriendmapExample;
import com.message.model.FriendmapExample.Criteria;
import com.message.model.User;
import com.message.service.FriendService;
@Service
public class FriendServiceImpl implements FriendService {
	@Autowired
	private FriendmapMapper friendMapper;

	/**
	 * @author: �����
	 * @date: 2016��6��21��
	 * @param userid ���Լ�Ϊ������ʱ�ĺ��Ѷ�
	 * @return
	 * @describe�� ͨ��userid��ѯ���Ѷ�
	 */
	@Override
	public List findFriendMapSend(int userid,int state) {
		FriendmapExample example=new FriendmapExample();
		Criteria criteria=example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andStateEqualTo(state);
		return friendMapper.selectByExample(example);
	}

	/**
	 * @author: �����
	 * @date: 2016��6��21��
	 * @param userid �Լ�Ϊ��������ʱ�ĺ��Ѷ�
	 * @return
	 * @describe��ͨ��friendid��ѯ���Ѷ�
	 */
	@Override
	public List findFriendMapReceive(int userid,int state) {
		FriendmapExample example=new FriendmapExample();
		Criteria criteria=example.createCriteria();
		criteria.andFriendidEqualTo(userid);
		criteria.andStateEqualTo(state);
		return friendMapper.selectByExample(example);
	}

	/**
	 * @author: �����
	 * @date: 2016��6��24��
	 * @param FriendMap ����
	 * @return  boolean  
	 * @describe ����ɹ�����true��ʧ�ܷ���false
	 */
	@Override
	public boolean askforFriend(Friendmap friendmap) {
		int n=friendMapper.insertSelective(friendmap);
		if(n!=0)return true;
		return false;
	}

	/**
	 * @author: �����
	 * @date: 2016��6��24��
	 * @param friendmap
	 * @return ���³ɹ�����true��ʧ�ܷ���false
	 * @describe���û��������������ߴ�����ѹ�ϵ
	 */
	@Override
	public boolean updateFriendmap(Friendmap friendmap) {
		int n=friendMapper.updateByPrimaryKey(friendmap);
		if(n!=0)return true;
		return false;
	}

	/**
	 * @author: �����
	 * @date: 2016��6��24��
	 * @param friendmap
	 * @describe��ͨ������ɾ�����Ѷ�
	 */
	@Override
	public boolean deleteFriendmap(Integer friendmapid) {
		int n=friendMapper.deleteByPrimaryKey(friendmapid);
		if(n!=0)return true;
		return false;
	}

	/**
	 * @author: �����
	 * @date: 2016��6��24��
	 * @param userid ������
	 * @param friendid ��������
	 * @param state ����״̬
	 * @return  ���Ѷ�
	 * @describe�����Һ��Ѷ�
	 */
	@Override
	public Friendmap findFriendmap(int userid, int friendid, int state) {
		FriendmapExample example=new FriendmapExample();
		Criteria criteria=example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andFriendidEqualTo(friendid);
		criteria.andStateEqualTo(state);
		List list=friendMapper.selectByExample(example);
		if(list.size()>0) return (Friendmap)list.get(0);
		return null;
	}

		/**
		 * @author: �����
		 * @date: 2016��6��25��
		 * @param user
		 * @return  �û��ĺ�������
		 * @describe��ͨ���û�id,�������������
		 */
	@Override
	public int selectCountFriend(Integer userid) {
		return friendMapper.selectCountFriend(userid);
	}






}
