package com.swmfizl.dao;

import java.util.List;

import javax.sql.DataSource;

import com.swmfizl.bean.User;

public interface UserDao {
	/**
	 * 设置数据源
	 * 
	 * @param dataSource 数据源
	 */
	public void setDataSource(DataSource dataSource);

	/**
	 * 创建用户
	 * 
	 * @param id         用户ID
	 * @param name       用户名称
	 * @param profession 职业
	 * 
	 * @return 新增的行数
	 */
	public int insert(String id, String name, String profession);

	/**
	 * 匹配ID删除用户
	 * 
	 * @param id 用户ID
	 * 
	 * @return 删除的函数
	 */
	public int deleteById(String id);

	/**
	 * 匹配用户ID修改职业
	 * 
	 * @param id
	 * @param profession
	 * 
	 * @return 修改的行数
	 */
	public int updateById(String id, String profession);

	/**
	 * 匹配ID查询用户
	 * 
	 * @param id 用户ID
	 * @return 匹配的用户
	 */
	public User selectById(String id);

	/**
	 * 查询全部用户
	 * 
	 * @return 全部用户
	 */
	public List<User> select();
}
