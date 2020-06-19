
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
		// 新增用户
		String newID = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		System.out.println("新增：" + userService.insert(newID, "钟力", "前端高级开发工程师"));
		// 查询全部用户
		System.out.println("查询全部：" + userService.select());
		// 修改用户
		System.out.println("修改：" + userService.updateById(newID, "Java高级开发工程师"));
		// 匹配ID查询用户
		System.out.println("匹配ID查询：" + userService.selectById(newID));
		// 匹配ID删除用户
		System.out.println("匹配ID删除：" + userService.deleteById(newID));
	}
}
