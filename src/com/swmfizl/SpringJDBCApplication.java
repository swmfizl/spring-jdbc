
package com.swmfizl;

import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.swmfizl.service.UserService;
/**
 * 
 * @author ZhongLi
 * @date 2020-06-19
 *
 */
public class SpringJDBCApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
		// �����û�
		String newID = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		System.out.println("������" + userService.insert(newID, "����", "ǰ�˸߼���������ʦ"));
		// ��ѯȫ���û�
		System.out.println("��ѯȫ����" + userService.select());
		// �޸��û�
		System.out.println("�޸ģ�" + userService.updateById(newID, "Java�߼���������ʦ"));
		// ƥ��ID��ѯ�û�
		System.out.println("ƥ��ID��ѯ��" + userService.selectById(newID));
		// ƥ��IDɾ���û�
		System.out.println("ƥ��IDɾ����" + userService.deleteById(newID));
	}
}
