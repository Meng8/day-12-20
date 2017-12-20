package cn.com.taiji.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.taiji.dto.RoleDto;
import cn.com.taiji.service.RoleService;
/**
 * 
 * 类名称：RoleControllerTest   
 * 类描述：   
 * 创建人：Meng   
 * 创建时间：2017年12月10日 下午11:46:25 
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleControllerTest {
	@Autowired
	RoleService roleservice;
	/**
	 * 
	 * @Description: 增加角色方法测试
	 * @throws
	 * @author Meng
	 * @date 2017年12月11日
	 */
	@Test
	public void addRoleTest() {
		RoleDto roleDto = new RoleDto();
		roleDto.setName("经理");
		roleDto.setDescription("牛");
		roleDto.setDeletemark(1);
		System.out.println(roleDto);
		roleservice.addRole(roleDto);
	}
	/**
	 * 
	 * @Description: 修改和逻辑删除  
	 * @throws
	 * @author Meng
	 * @date 2017年12月11日
	 */
	@Test
	public void update() {
		RoleDto roledto = roleservice.fingOne("8a80a8d860447bfa0160447c21d20000");
		roledto.setName("大堂经理");
		roledto.setDescription("不是经理的经理");
		roleservice.addRole(roledto);
	}

}
