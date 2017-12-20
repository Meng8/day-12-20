package cn.com.taiji.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.taiji.dto.EmployeeDto;
import cn.com.taiji.service.EmployeeService;


@Controller
public class EmpController {
	private static final Logger log = LoggerFactory.getLogger(EmpController.class);
	@Autowired
	EmployeeService  employeeservice;
	ObjectMapper objectMapper;
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String dosuccess() {
		
		return "emplist";
	}
	
	@GetMapping("/showemplist")
	public String empList() {
		
		return "emplist";
	}
	/**
	 * 
	 * @Description:显示所有员工信息
	 * @param models
	 * @return Map  
	 * @throws
	 * @author Meng
	 * @date 2017年12月12日
	 */
	@RequestMapping(value="/getemplist",method=RequestMethod.POST)
	@ResponseBody
	public Map getPage(@RequestParam(value="limit",defaultValue="0")int limit, @RequestParam(value="offset",defaultValue="10")int offset, String departmentname, String statu) {
		//String json = "{\"page\":0,\"pageSize\":10,\"filter\":{\"filters\":[{\"field\":\"loginName\",\"value\":\"sue\"},{\"field\":\"userName\",\"value\":\"sd\"}],\"logic\":\"and\"},\"sort\":[{\"field\":\"loginName\",\"dir\":\"asc\"},{\"field\":\"email\",\"dir\":\"asc\"}]}";
//		System.out.println(models);
//		Map searchParameters = new HashMap<String,String>();
		Map empPage = new HashMap<>();
//		HashMap<String,String> filter = new HashMap<String,String>();
//		try {
//			searchParameters = objectMapper.readValue(models,new TypeReference<Map>() {});
//			int page = (int) searchParameters.get("page");
//			System.out.println(page);
//			int pageSize = (int) searchParameters.get("pageSize");
//			System.out.println(pageSize);
//			
//			//filter = (HashMap<String, String>) searchParameters.get("filter");
			
		empPage = employeeservice.getPage(limit-1, offset, null,null);
//			empPage = employeeservice.getPage(searchParameters, null);
//			System.out.println(userPage);
//			
//		} catch (JsonParseException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return empPage;
	}
	
	@RequestMapping(value="/addemp",method=RequestMethod.POST)
	public String addEmp(EmployeeDto empDto) {
		System.out.println(empDto);
		
		employeeservice.addUser(empDto);;
		
		return "empList";
		
	}
	

}
