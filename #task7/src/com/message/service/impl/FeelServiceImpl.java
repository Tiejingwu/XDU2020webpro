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
	 * @author: 霍光恩
	 * @date: 2016年6月22日
	 * @param receiveid:发表所说者的id，currentPage：当前页号
	 * @return 留言列表PageInfo 对象，其中封装者分页信息和结果集合
	 * @describe： 查询userid的用户的说说
	 * 分页插件进行分页
	 */
	@Override
	public PageInfo<Feel> showFeels(Integer userid,Integer currentPage) {
		FeelExample example=new FeelExample();  
		example.setOrderByClause("feeltime DESC"); //在example中添加查询条件，按时间排序
		Criteria criteria=example.createCriteria();
		if(userid!=null){
		criteria.andUseridEqualTo(userid);  /*添加查询条件，赋值接收者参数*/
		}
		PageInfo pageinfo=new PageInfo();   //新建分页对象，封装了查询结果，分页信息
		pageinfo.setPageSize(8);   //设置分页size为8
		//startPage是告诉拦截器说我要开始分页了。分页参数是这两个
		PageHelper.startPage(currentPage,pageinfo.getPageSize()); 
		List list=feelMapper.selectByExampleWithBLOBs(example);
		//取记录总条数
		PageInfo<Feel> pageInfo = new PageInfo<Feel>(list);  //将查询的结果放入PageInfo中，封装起来供前端获取数据使用
		return pageInfo;
	}
	
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月22日
	 * @param userid
	 * @return 符合条件的说说的总条数。
	 */
	@Override
	public int feelCount(Integer userid) {
		FeelExample example=new FeelExample();
		Criteria criteria=example.createCriteria();
		if(userid!=null){
		criteria.andUseridEqualTo(userid);   /*添加查询条件，赋值接收者参数*/
		}
		return feelMapper.countByExample(example);  //返回符合条件的记录数量
	}

	/**
	 * @author: 霍光恩
	 * @date: 2016年6月23日
	 * @param feel
	 * @return boolean 添加成功返回true，失败则返回false
	 * @describe：发表说说即添加一条记录
	 */
	@Override
	public boolean publishFeel(Feel feel) {
		int n=feelMapper.insertSelective(feel);
		if(n!=0) return true;
		else
			return false; 
	}
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月23日
	 * @param feelid
	 * @return boolean 删除成功返回true，失败则返回false
	 * @describe：根据feelid删除留言
	 */
	@Override
	public boolean deleteFeel(int feelid) {
		int n=feelMapper.deleteByPrimaryKey(feelid);
		if(n!=0) return true;
		else
			return false;
	}


}
