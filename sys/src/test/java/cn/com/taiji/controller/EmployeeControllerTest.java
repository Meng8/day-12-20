package cn.com.taiji.controller;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.taiji.dto.EmployeeDto;
import cn.com.taiji.service.EmployeeService;
/**
 * 
 * 类名称：EmployeeControllerTest   
 * 类描述：   
 * 创建人：Meng   
 * 创建时间：2017年12月10日 下午11:47:17 
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {
	
	@Autowired
	EmployeeService employeeservice;
	
	@Test
	public void addEmpTest() {
		Date valueOf = Date.valueOf("2017-8-8");
//		Employee employee = new Employee("11", (long) 1, "一龙", "男", "技术", "北京", "企业", "企业二部", "四级", 8,
//				"java", valueOf, "18333333333", "8484884@jii.com", "admin", "admin", "22", 22, "清华",
//				valueOf, 1, role);
	   EmployeeDto employeedto = new  EmployeeDto();
	   employeedto.setName("zhang");
	   employeedto.setAge(33);
	   employeedto.setDateOfBirth(valueOf);
	   employeedto.setDept("国防三部");
	   employeedto.setEducation("222");
	   employeedto.setEmpId((long) 1212);
	   employeedto.setEmptype("牛");
	   employeedto.setGender("男");
	   employeedto.setJobcity("北京");
	   employeedto.setJobLevel(5);
	   employeedto.setJobName("经理");
	   employeedto.setJobSequence("55");
	   employeedto.setPassword("admin");
	   employeedto.setUsername("admin");
	   employeedto.setSecondDept("打野");
	   employeedto.setTime(valueOf);
	   employeedto.setPhone("12128888888");
	   employeedto.setEmail("18334787649@163.com");
	   System.out.println(employeedto);
	   employeeservice.addUser(employeedto);
	}
	
	@Test
	public void update() {
		EmployeeDto empdto = employeeservice.fingOne("8a80a8d860448d1b0160448d41170000");
		empdto.setName("猎魔者");
		employeeservice.addUser(empdto);
	}
	/**
	 * 
	 * @Description: 获取用户登录时间  
	 * @throws
	 * @author Meng
	 * @date 2017年12月11日
	 */
	@Test
	public void getTime() {
		Calendar instance = Calendar.getInstance();
		System.out.println(instance);
	}
	/**
	 * 
	 * @Description: 获取当前登录的用户对象  
	 * @throws
	 * @author Meng
	 * @date 2017年12月11日
	 */
	@Test
	public void getEmp() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		System.out.println(userDetails);
	}

}
