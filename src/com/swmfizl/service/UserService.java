package com.swmfizl.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.swmfizl.bean.User;
import com.swmfizl.dao.UserDao;
import com.swmfizl.mapper.UserMapper;

public class UserService implements UserDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * 设置数据源
	 * 
	 * @param dataSource 数据源
	 */
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO 自动生成的方法存根
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/**
	 * 创建用户
	 * 
	 * @param id         用户ID
	 * @param name       用户名称
	 * @param profession 职业
	 * @return 新增的行数
	 */
	@Override
	public int insert(String id, String name, String profession) {
		String SQL = "insert into user (id, name, profession) values (?, ?, ?)";
		int insertNum = jdbcTemplateObject.update(SQL, id, name, profession);
		return insertNum;
	}

	/**
	 * 匹配ID删除用户
	 * 
	 * @param id 用户ID
	 * 
	 * @return 删除的行数
	 */
	@Override
	public int deleteById(String id) {
		String SQL = "delete from user where id = ?";
		int delNum = jdbcTemplateObject.update(SQL, id);
		return delNum;
	}

	/**
	 * 匹配用户ID修改职业
	 * 
	 * @param id
	 * @param profession
	 * 
	 * @return 修改的行数
	 */
	public int updateById(String id, String profession) {
		String SQL = "update user set profession = ? where id = ?";
		int updateNum = jdbcTemplateObject.update(SQL, profession, id);
		return updateNum;
	}

	/**
	 * 匹配ID查询用户
	 * 
	 * @param id 用户ID
	 * @return 匹配的用户
	 */
	@Override
	public User selectById(String id) {
		// TODO 自动生成的方法存根
		String SQL = "select * from user where id = ?";
		User user = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new UserMapper());
		return user;
	}

	/**
	 * 查询全部用户
	 * 
	 * @return 全部用户
	 */
	@Override
	public List<User> select() {
		// TODO 自动生成的方法存根
		String SQL = "select * from user";
		List<User> list = jdbcTemplateObject.query(SQL, new UserMapper());
		return list;
	}

}
