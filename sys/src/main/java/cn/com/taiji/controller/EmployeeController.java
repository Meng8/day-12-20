package cn.com.taiji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.taiji.dto.EmployeeDto;
import cn.com.taiji.service.EmployeeService;
/**
 * 
 * 类名称：EmployeeController   
 * 类描述：   员工表的
 * 创建人：Meng   
 * 创建时间：2017年12月10日 下午10:36:50 
 * @version
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@GetMapping("getpage")
	public String getPage() {
		return "emplist";
	}
	//增加用户
	@GetMapping("addemp")
	public String addEmp(EmployeeDto employeeDto) {
		employeeservice.addUser(employeeDto);
		return "emplist";
	}
	
	//删除用户
	@GetMapping("deleteemp")
	public String deleteEmp(String id) {
		employeeservice.deleteUser(id);
		return "emplist";
	}

}
