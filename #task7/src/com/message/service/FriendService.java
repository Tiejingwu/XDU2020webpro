package com.message.service;

import java.util.List;

import com.message.model.Friendmap;

public interface FriendService {
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月21日
	 * @param userid ：自己为请求者时的好友对
	 * @return
	 * @describe： 通过userid查询好友对
	 */
	 public  List findFriendMapSend(int userid,int state);
		/**
		 * @author: 霍光恩
		 * @date: 2016年6月21日
		 * @param userid 自己为被请求者时的好友对
		 * @return
		 * @describe：通过friendid查询好友对
		 */
	 public  List findFriendMapReceive(int userid,int state);
		/**
		 * @author: 霍光恩
		 * @date: 2016年6月24日
		 * @param userid 请求者
		 * @param friendid 被请求者
		 * @param state 好友状态
		 * @return  好友对
		 * @describe：查找好友对
		 */
	 public Friendmap findFriendmap(int userid,int friendid,int state);
		/**
		 * @author: 霍光恩
		 * @date: 2016年6月24日
		 * @param FriendMap 对象
		 * @return  boolean  
		 * @describe 请求成功返回true，失败返回false
		 * 好友请求。即添加好友并将好友状态置为0
		 */
	 public boolean askforFriend(Friendmap friendmap);
		/**
		 * @author: 霍光恩
		 * @date: 2016年6月24日
		 * @param friendmap
		 * @return 更新成功返回true，失败返回false
		 * @describe：用户处理好友请求或者处理好友关系。拉黑好友或者同意好友请求。即将好友状态改变
		 */
	 public boolean updateFriendmap(Friendmap friendmap);
		/**
		 * @author: 霍光恩
		 * @date: 2016年6月24日
		 * @param friendmap
		 * @describe：通过主键删除好友对
		 */
	 public boolean deleteFriendmap(Integer friendmapid);
		/**
		 * @author: 霍光恩
		 * @date: 2016年6月25日
		 * @param user
		 * @return  用户的好友数量
		 * @describe：通过用户id,查找其好友数量
		 */
	 public int selectCountFriend(Integer userid);

}
