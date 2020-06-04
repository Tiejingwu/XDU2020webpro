package com.message.service;

import java.util.List;

import com.message.model.Friendmap;

public interface FriendService {
	/**
	 * @author: �����
	 * @date: 2016��6��21��
	 * @param userid ���Լ�Ϊ������ʱ�ĺ��Ѷ�
	 * @return
	 * @describe�� ͨ��userid��ѯ���Ѷ�
	 */
	 public  List findFriendMapSend(int userid,int state);
		/**
		 * @author: �����
		 * @date: 2016��6��21��
		 * @param userid �Լ�Ϊ��������ʱ�ĺ��Ѷ�
		 * @return
		 * @describe��ͨ��friendid��ѯ���Ѷ�
		 */
	 public  List findFriendMapReceive(int userid,int state);
		/**
		 * @author: �����
		 * @date: 2016��6��24��
		 * @param userid ������
		 * @param friendid ��������
		 * @param state ����״̬
		 * @return  ���Ѷ�
		 * @describe�����Һ��Ѷ�
		 */
	 public Friendmap findFriendmap(int userid,int friendid,int state);
		/**
		 * @author: �����
		 * @date: 2016��6��24��
		 * @param FriendMap ����
		 * @return  boolean  
		 * @describe ����ɹ�����true��ʧ�ܷ���false
		 * �������󡣼���Ӻ��Ѳ�������״̬��Ϊ0
		 */
	 public boolean askforFriend(Friendmap friendmap);
		/**
		 * @author: �����
		 * @date: 2016��6��24��
		 * @param friendmap
		 * @return ���³ɹ�����true��ʧ�ܷ���false
		 * @describe���û��������������ߴ�����ѹ�ϵ�����ں��ѻ���ͬ��������󡣼�������״̬�ı�
		 */
	 public boolean updateFriendmap(Friendmap friendmap);
		/**
		 * @author: �����
		 * @date: 2016��6��24��
		 * @param friendmap
		 * @describe��ͨ������ɾ�����Ѷ�
		 */
	 public boolean deleteFriendmap(Integer friendmapid);
		/**
		 * @author: �����
		 * @date: 2016��6��25��
		 * @param user
		 * @return  �û��ĺ�������
		 * @describe��ͨ���û�id,�������������
		 */
	 public int selectCountFriend(Integer userid);

}
