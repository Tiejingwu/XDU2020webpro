package com.message.service;

import com.github.pagehelper.PageInfo;
import com.message.model.Feel;
public interface FeelService {
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月22日
	 * @param receiveid:发表所说者的id，currentPage：当前页号
	 * @return 留言列表PageInfo 对象，其中封装者分页信息和结果集合
	 * @describe： 查询userid的用户的说说
	 * 分页插件进行分页
	 */
  public PageInfo showFeels(Integer userid,Integer currentPage);
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月22日
	 * @param userid
	 * @return 符合条件的说说的总条数。
	 */
  public int feelCount(Integer userid); 
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月23日
	 * @param feel
	 * @return boolean 添加成功返回true，失败则返回false
	 * @describe：发表说说即添加一条记录
	 */
  public boolean publishFeel(Feel feel);
	/**
	 * @author: 霍光恩
	 * @date: 2016年6月23日
	 * @param feelid
	 * @return boolean 删除成功返回true，失败则返回false
	 * @describe：根据feelid删除留言
	 */
  public boolean deleteFeel(int feelid);
}
