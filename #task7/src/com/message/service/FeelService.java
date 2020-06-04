package com.message.service;

import com.github.pagehelper.PageInfo;
import com.message.model.Feel;
public interface FeelService {
	/**
	 * @author: �����
	 * @date: 2016��6��22��
	 * @param receiveid:������˵�ߵ�id��currentPage����ǰҳ��
	 * @return �����б�PageInfo �������з�װ�߷�ҳ��Ϣ�ͽ������
	 * @describe�� ��ѯuserid���û���˵˵
	 * ��ҳ������з�ҳ
	 */
  public PageInfo showFeels(Integer userid,Integer currentPage);
	/**
	 * @author: �����
	 * @date: 2016��6��22��
	 * @param userid
	 * @return ����������˵˵����������
	 */
  public int feelCount(Integer userid); 
	/**
	 * @author: �����
	 * @date: 2016��6��23��
	 * @param feel
	 * @return boolean ��ӳɹ�����true��ʧ���򷵻�false
	 * @describe������˵˵�����һ����¼
	 */
  public boolean publishFeel(Feel feel);
	/**
	 * @author: �����
	 * @date: 2016��6��23��
	 * @param feelid
	 * @return boolean ɾ���ɹ�����true��ʧ���򷵻�false
	 * @describe������feelidɾ������
	 */
  public boolean deleteFeel(int feelid);
}
