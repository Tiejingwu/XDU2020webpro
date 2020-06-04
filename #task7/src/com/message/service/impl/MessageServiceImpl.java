package com.message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.message.mapper.MessageMapper;
import com.message.model.Message;
import com.message.model.MessageExample;
import com.message.model.MessageExample.Criteria;
import com.message.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageMapper messageMapper;
	/**
	 * @author: �����
	 * @date: 2016��6��22��
	 * @param receiveid:��������id��currentPage����ǰҳ��
	 * @return �����б�PageInfo �������з�װ�߷�ҳ��Ϣ�ͽ������
	 * @describe�� ��ѯ���и�receiveid���û�������
	 * ��ҳ������з�ҳ
	 */
	@Override
	public PageInfo<Message> showMessages(int receiveid,Integer currentPage) {
		MessageExample example=new MessageExample();  
		example.setOrderByClause("messagetime DESC"); //��example����Ӳ�ѯ��������ʱ������
		Criteria criteria=example.createCriteria();
		criteria.andReceiveidEqualTo(receiveid);  /*��Ӳ�ѯ��������ֵ�����߲���*/
		PageInfo pageinfo=new PageInfo();   //�½���ҳ���󣬷�װ�˲�ѯ�������ҳ��Ϣ
		pageinfo.setPageSize(3);   //���÷�ҳsizeΪ8
		//startPage�Ǹ���������˵��Ҫ��ʼ��ҳ�ˡ���ҳ������������
		PageHelper.startPage(currentPage,pageinfo.getPageSize()); 
		List list=messageMapper.selectByExampleWithBLOBs(example);
		//ȡ��¼������
		PageInfo<Message> pageInfo = new PageInfo<Message>(list);  //����ѯ�Ľ������PageInfo�У���װ������ǰ�˻�ȡ����ʹ��
		return pageInfo;
	}
	/**
	 * @author: �����
	 * @date: 2016��6��22��
	 * @param receiveid
	 * @return �������������Ե���������
	 */
	@Override
	public int messageCount(int receiveid) {
		MessageExample example=new MessageExample();
		Criteria criteria=example.createCriteria();
		criteria.andReceiveidEqualTo(receiveid);   /*��Ӳ�ѯ��������ֵ�����߲���*/
		return messageMapper.countByExample(example);  //���ط��������ļ�¼����
	}
	/**
	 * @author: �����
	 * @date: 2016��6��23��
	 * @param message
	 * @return boolean ��ӳɹ�����true��ʧ���򷵻�false
	 * @describe���������
	 */
	@Override
	public boolean leaveMessage(Message message) {
		int n=messageMapper.insertSelective(message);
		if(n!=0) return true;
		else
			return false; 
	}
	/**
	 * @author: �����
	 * @date: 2016��6��23��
	 * @param messageid
	 * @return boolean ɾ���ɹ�����true��ʧ���򷵻�false
	 * @describe������messageidɾ������
	 */
	@Override
	public boolean deleteMessage(int messageid) {
		int n=messageMapper.deleteByPrimaryKey(messageid);
		if(n!=0) return true;
		else
			return false;
	}

}
