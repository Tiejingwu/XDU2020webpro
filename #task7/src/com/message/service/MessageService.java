package com.message.service;

import com.github.pagehelper.PageInfo;
import com.message.model.Message;

public interface MessageService {
	/**
	 * @author: �����
	 * @date: 2016��6��22��
	 * @param receiveid:��������id��currentPage����ǰҳ��
	 * @return �����б�PageInfo �������з�װ�߷�ҳ��Ϣ�ͽ������
	 * @describe�� ��ѯ���и�receiveid���û�������
	 * ��ҳ������з�ҳ
	 */
  public PageInfo<Message> showMessages(int receiveid,Integer currentPage);
	/**
	 * @author: �����
	 * @date: 2016��6��22��
	 * @param receiveid
	 * @return �������������Ե���������
	 */
  public int messageCount(int receiveid);
	/**
	 * @author: �����
	 * @date: 2016��6��23��
	 * @param message
	 * @return boolean ��ӳɹ�����true��ʧ���򷵻�false
	 * @describe���������
	 */
  public boolean leaveMessage(Message message);
	/**
	 * @author: �����
	 * @date: 2016��6��23��
	 * @param messageid
	 * @return boolean ɾ���ɹ�����true��ʧ���򷵻�false
	 * @describe������messageidɾ������
	 */
  public boolean deleteMessage(int messageid);
}
