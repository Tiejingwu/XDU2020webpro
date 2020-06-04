package com.message.service;

import com.github.pagehelper.PageInfo;
import com.message.model.Message;

public interface MessageService {
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月22日
	 * @param receiveid:被留言者id，currentPage：当前页号
	 * @return 留言列表PageInfo 对象，其中封装者分页信息和结果集合
	 * @describe： 查询所有给receiveid的用户的留言
	 * 分页插件进行分页
	 */
  public PageInfo<Message> showMessages(int receiveid,Integer currentPage);
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月22日
	 * @param receiveid
	 * @return 符合条件的留言的总条数。
	 */
  public int messageCount(int receiveid);
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月23日
	 * @param message
	 * @return boolean 添加成功返回true，失败则返回false
	 * @describe：添加留言
	 */
  public boolean leaveMessage(Message message);
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月23日
	 * @param messageid
	 * @return boolean 删除成功返回true，失败则返回false
	 * @describe：根据messageid删除留言
	 */
  public boolean deleteMessage(int messageid);
}
