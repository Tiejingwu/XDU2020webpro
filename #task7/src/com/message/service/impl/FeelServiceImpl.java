package com.message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.message.mapper.FeelMapper;
import com.message.model.Feel;
import com.message.model.FeelExample;
import com.message.model.FeelExample.Criteria;
import com.message.service.FeelService;
@Service
public class FeelServiceImpl implements FeelService {
	@Autowired
	private FeelMapper feelMapper;
	/**
	 * @author: �����
	 * @date: 2016��6��22��
	 * @param receiveid:������˵�ߵ�id��currentPage����ǰҳ��
	 * @return �����б�PageInfo �������з�װ�߷�ҳ��Ϣ�ͽ������
	 * @describe�� ��ѯuserid���û���˵˵
	 * ��ҳ������з�ҳ
	 */
	@Override
	public PageInfo<Feel> showFeels(Integer userid,Integer currentPage) {
		FeelExample example=new FeelExample();  
		example.setOrderByClause("feeltime DESC"); //��example����Ӳ�ѯ��������ʱ������
		Criteria criteria=example.createCriteria();
		if(userid!=null){
		criteria.andUseridEqualTo(userid);  /*��Ӳ�ѯ��������ֵ�����߲���*/
		}
		PageInfo pageinfo=new PageInfo();   //�½���ҳ���󣬷�װ�˲�ѯ�������ҳ��Ϣ
		pageinfo.setPageSize(8);   //���÷�ҳsizeΪ8
		//startPage�Ǹ���������˵��Ҫ��ʼ��ҳ�ˡ���ҳ������������
		PageHelper.startPage(currentPage,pageinfo.getPageSize()); 
		List list=feelMapper.selectByExampleWithBLOBs(example);
		//ȡ��¼������
		PageInfo<Feel> pageInfo = new PageInfo<Feel>(list);  //����ѯ�Ľ������PageInfo�У���װ������ǰ�˻�ȡ����ʹ��
		return pageInfo;
	}
	
	/**
	 * @author: �����
	 * @date: 2016��6��22��
	 * @param userid
	 * @return ����������˵˵����������
	 */
	@Override
	public int feelCount(Integer userid) {
		FeelExample example=new FeelExample();
		Criteria criteria=example.createCriteria();
		if(userid!=null){
		criteria.andUseridEqualTo(userid);   /*��Ӳ�ѯ��������ֵ�����߲���*/
		}
		return feelMapper.countByExample(example);  //���ط��������ļ�¼����
	}

	/**
	 * @author: �����
	 * @date: 2016��6��23��
	 * @param feel
	 * @return boolean ��ӳɹ�����true��ʧ���򷵻�false
	 * @describe������˵˵�����һ����¼
	 */
	@Override
	public boolean publishFeel(Feel feel) {
		int n=feelMapper.insertSelective(feel);
		if(n!=0) return true;
		else
			return false; 
	}
	/**
	 * @author: �����
	 * @date: 2016��6��23��
	 * @param feelid
	 * @return boolean ɾ���ɹ�����true��ʧ���򷵻�false
	 * @describe������feelidɾ������
	 */
	@Override
	public boolean deleteFeel(int feelid) {
		int n=feelMapper.deleteByPrimaryKey(feelid);
		if(n!=0) return true;
		else
			return false;
	}


}
