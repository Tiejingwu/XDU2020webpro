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
	 * @author: 霍光恩
	 * @date: 2016年6月21日
	 * @param userid ：自己为请求者时的好友对
	 * @return
	 * @describe： 通过userid查询好友对
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
	 * @author: 霍光恩
	 * @date: 2016年6月21日
	 * @param userid 自己为被请求者时的好友对
	 * @return
	 * @describe：通过friendid查询好友对
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
	 * @author: 霍光恩
	 * @date: 2016年6月24日
	 * @param FriendMap 对象
	 * @return  boolean  
	 * @describe 请求成功返回true，失败返回false
	 */
	@Override
	public boolean askforFriend(Friendmap friendmap) {
		int n=friendMapper.insertSelective(friendmap);
		if(n!=0)return true;
		return false;
	}

	/**
	 * @author: 霍光恩
	 * @date: 2016年6月24日
	 * @param friendmap
	 * @return 更新成功返回true，失败返回false
	 * @describe：用户处理好友请求或者处理好友关系
	 */
	@Override
	public boolean updateFriendmap(Friendmap friendmap) {
		int n=friendMapper.updateByPrimaryKey(friendmap);
		if(n!=0)return true;
		return false;
	}

	/**
	 * @author: 霍光恩
	 * @date: 2016年6月24日
	 * @param friendmap
	 * @describe：通过主键删除好友对
	 */
	@Override
	public boolean deleteFriendmap(Integer friendmapid) {
		int n=friendMapper.deleteByPrimaryKey(friendmapid);
		if(n!=0)return true;
		return false;
	}

	/**
	 * @author: 霍光恩
	 * @date: 2016年6月24日
	 * @param userid 请求者
	 * @param friendid 被请求者
	 * @param state 好友状态
	 * @return  好友对
	 * @describe：查找好友对
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
		 * @author: 霍光恩
		 * @date: 2016年6月25日
		 * @param user
		 * @return  用户的好友数量
		 * @describe：通过用户id,查找其好友数量
		 */
	@Override
	public int selectCountFriend(Integer userid) {
		return friendMapper.selectCountFriend(userid);
	}






}
