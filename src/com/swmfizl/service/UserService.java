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
	 * ��������Դ
	 * 
	 * @param dataSource ����Դ
	 */
	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO �Զ����ɵķ������
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/**
	 * �����û�
	 * 
	 * @param id         �û�ID
	 * @param name       �û�����
	 * @param profession ְҵ
	 * @return ����������
	 */
	@Override
	public int insert(String id, String name, String profession) {
		String SQL = "insert into user (id, name, profession) values (?, ?, ?)";
		int insertNum = jdbcTemplateObject.update(SQL, id, name, profession);
		return insertNum;
	}

	/**
	 * ƥ��IDɾ���û�
	 * 
	 * @param id �û�ID
	 * 
	 * @return ɾ��������
	 */
	@Override
	public int deleteById(String id) {
		String SQL = "delete from user where id = ?";
		int delNum = jdbcTemplateObject.update(SQL, id);
		return delNum;
	}

	/**
	 * ƥ���û�ID�޸�ְҵ
	 * 
	 * @param id
	 * @param profession
	 * 
	 * @return �޸ĵ�����
	 */
	public int updateById(String id, String profession) {
		String SQL = "update user set profession = ? where id = ?";
		int updateNum = jdbcTemplateObject.update(SQL, profession, id);
		return updateNum;
	}

	/**
	 * ƥ��ID��ѯ�û�
	 * 
	 * @param id �û�ID
	 * @return ƥ����û�
	 */
	@Override
	public User selectById(String id) {
		// TODO �Զ����ɵķ������
		String SQL = "select * from user where id = ?";
		User user = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new UserMapper());
		return user;
	}

	/**
	 * ��ѯȫ���û�
	 * 
	 * @return ȫ���û�
	 */
	@Override
	public List<User> select() {
		// TODO �Զ����ɵķ������
		String SQL = "select * from user";
		List<User> list = jdbcTemplateObject.query(SQL, new UserMapper());
		return list;
	}

}
