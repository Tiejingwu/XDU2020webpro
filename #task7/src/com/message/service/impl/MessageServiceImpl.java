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
	 * @author: 霍光恩
	 * @date: 2016年6月22日
	 * @param receiveid:被留言者id，currentPage：当前页号
	 * @return 留言列表PageInfo 对象，其中封装者分页信息和结果集合
	 * @describe： 查询所有给receiveid的用户的留言
	 * 分页插件进行分页
	 */
	@Override
	public PageInfo<Message> showMessages(int receiveid,Integer currentPage) {
		MessageExample example=new MessageExample();  
		example.setOrderByClause("messagetime DESC"); //在example中添加查询条件，按时间排序
		Criteria criteria=example.createCriteria();
		criteria.andReceiveidEqualTo(receiveid);  /*添加查询条件，赋值接收者参数*/
		PageInfo pageinfo=new PageInfo();   //新建分页对象，封装了查询结果，分页信息
		pageinfo.setPageSize(3);   //设置分页size为8
		//startPage是告诉拦截器说我要开始分页了。分页参数是这两个
		PageHelper.startPage(currentPage,pageinfo.getPageSize()); 
		List list=messageMapper.selectByExampleWithBLOBs(example);
		//取记录总条数
		PageInfo<Message> pageInfo = new PageInfo<Message>(list);  //将查询的结果放入PageInfo中，封装起来供前端获取数据使用
		return pageInfo;
	}
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月22日
	 * @param receiveid
	 * @return 符合条件的留言的总条数。
	 */
	@Override
	public int messageCount(int receiveid) {
		MessageExample example=new MessageExample();
		Criteria criteria=example.createCriteria();
		criteria.andReceiveidEqualTo(receiveid);   /*添加查询条件，赋值接收者参数*/
		return messageMapper.countByExample(example);  //返回符合条件的记录数量
	}
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月23日
	 * @param message
	 * @return boolean 添加成功返回true，失败则返回false
	 * @describe：添加留言
	 */
	@Override
	public boolean leaveMessage(Message message) {
		int n=messageMapper.insertSelective(message);
		if(n!=0) return true;
		else
			return false; 
	}
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月23日
	 * @param messageid
	 * @return boolean 删除成功返回true，失败则返回false
	 * @describe：根据messageid删除留言
	 */
	@Override
	public boolean deleteMessage(int messageid) {
		int n=messageMapper.deleteByPrimaryKey(messageid);
		if(n!=0) return true;
		else
			return false;
	}

}
