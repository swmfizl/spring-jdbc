package com.swmfizl.dao;

import java.util.List;

import javax.sql.DataSource;

import com.swmfizl.bean.User;

public interface UserDao {
	/**
	 * ��������Դ
	 * 
	 * @param dataSource ����Դ
	 */
	public void setDataSource(DataSource dataSource);

	/**
	 * �����û�
	 * 
	 * @param id         �û�ID
	 * @param name       �û�����
	 * @param profession ְҵ
	 * 
	 * @return ����������
	 */
	public int insert(String id, String name, String profession);

	/**
	 * ƥ��IDɾ���û�
	 * 
	 * @param id �û�ID
	 * 
	 * @return ɾ���ĺ���
	 */
	public int deleteById(String id);

	/**
	 * ƥ���û�ID�޸�ְҵ
	 * 
	 * @param id
	 * @param profession
	 * 
	 * @return �޸ĵ�����
	 */
	public int updateById(String id, String profession);

	/**
	 * ƥ��ID��ѯ�û�
	 * 
	 * @param id �û�ID
	 * @return ƥ����û�
	 */
	public User selectById(String id);

	/**
	 * ��ѯȫ���û�
	 * 
	 * @return ȫ���û�
	 */
	public List<User> select();
}
