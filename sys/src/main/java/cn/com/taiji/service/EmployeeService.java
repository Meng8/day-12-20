package cn.com.taiji.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.com.taiji.domain.Employee;
import cn.com.taiji.dto.EmployeeDto;
import cn.com.taiji.repository.EmployeeRepository;

/**
 * 
 * 类名称：EmployeeService   
 * 类描述：   
 * 创建人：Meng   
 * 创建时间：2017年12月8日 下午4:32:31 
 * @version
 */

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	 //查找全部
	public List<Employee> fingAllUser(){
		return employeeRepository.findAll();
	}
	
	
	//查找单个
	public EmployeeDto fingOne(String id) {
		Employee employee = employeeRepository.findOne(id);
		EmployeeDto employeeDto = new EmployeeDto();
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}
	//新增和修改
	public void addUser(EmployeeDto employeedto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeedto, employee);
		employeedto.setDeletemark(1);
		employeeRepository.saveAndFlush(employee);
	}
	//删除
	public void deleteUser(String id) {
		employeeRepository.delete(id);
	} 
	/**
	 * 
	 * @Description: 用户列表
	 * @param page
	 * @param pageSize
	 * @param orderMaps
	 * @param filters
	 * @return Map  
	 * @throws
	 * @author Meng
	 * @date 2017年12月11日
	 */

	
	public Map getPage(int page,int pageSize,
			HashMap<String,String> orderMaps,HashMap<String,String> filters) {
		Page<Employee> pageContent;
		
		if (pageSize < 1)
			pageSize = 1;
		if (pageSize > 100)
			pageSize = 100;

		List<Order> orders = new ArrayList<Order>();
		if (orderMaps != null) {
			for (String key : orderMaps.keySet()) {
				if ("DESC".equalsIgnoreCase(orderMaps.get(key))) {
					orders.add(new Order(Direction.DESC, key));
				} else {
					orders.add(new Order(Direction.ASC, key));
				}
			}
			
		}
		PageRequest pageable;
		if (orders.size() > 0) {
			pageable = new PageRequest(page, pageSize, new Sort(orders));
		} else {
			pageable = new PageRequest(page, pageSize);
		}

		if (filters != null) {
			Specification<Employee> spec = new Specification<Employee>() {
				@Override
				public Predicate toPredicate(Root<Employee> root,
						CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> pl = new ArrayList<Predicate>();
					for (String key : filters.keySet()) {
						// TODO should change with operator, and according to value
						String value = filters.get(key);
						if ("enabled".equalsIgnoreCase(key)) {
							if ("true".equalsIgnoreCase(value)) {
								pl.add(cb.equal(root.get(key), true));
							} else if ("false".equalsIgnoreCase(value)) {
								pl.add(cb.equal(root.get(key), false));
							}
						} else if ("code".equalsIgnoreCase(key)) {
							if (value.length() > 0)
								pl.add(cb.like(root.<String> get(key), value + "%"));
						} else if ("name".equalsIgnoreCase(key)) {
							if (value.length() > 0)
								pl.add(cb.like(root.get(key), value));
						}
					}
					return cb.and(pl.toArray(new Predicate[0]));
				}
			};
			pageContent = employeeRepository.findAll(spec, pageable);
		} else {
			pageContent = employeeRepository.findAll(pageable);
		}
		Map map = new HashMap();
		
		map.put("total", pageContent.getTotalElements());
		map.put("users", accountPage2Dto(pageContent));
		return map;
	}
	
	/**
	 * 
	 * @Description: 便利集合转换成EmployeeDto类
	 * @param pageContent
	 * @return List<EmployeeDto>  
	 * @throws
	 * @author Meng
	 * @date 2017年12月11日
	 */


	private List<EmployeeDto> accountPage2Dto(Page<Employee> pageContent) {
		List<Employee> content = pageContent.getContent();
		List<EmployeeDto>  list= new ArrayList<EmployeeDto>();
		
		for (Employee employee : content) {
			EmployeeDto employeeD = accountPageDto(employee);
			list.add(employeeD);
		}
		
		return list;
	}
	
	/**
	 * 
	 * @Description:把employee实体类转成EmployeeDto类
	 * @param employee
	 * @return EmployeeDto  
	 * @throws
	 * @author Meng
	 * @date 2017年12月11日
	 */
	private EmployeeDto accountPageDto(Employee employee) {
			EmployeeDto employeeD = new EmployeeDto();
			BeanUtils.copyProperties(employee, employeeD);
		return employeeD;
	}
	/**
	 * 
	 * @Description:分页
	 * @return Map  
	 * @throws
	 * @author Meng
	 * @date 2017年12月12日
	 */
//	public Map empGetPage(Map searchParameters) {
//		Map map = new HashMap();
//		int page = 0;
//		int pageSize = 10;
//		Page<Employee> pageContent;
//		if (searchParameters != null && searchParameters.size() > 0
//				&& searchParameters.get("page") != null) {
//			page = Integer.parseInt(searchParameters.get("page").toString()) - 1;
//		}
//		if (searchParameters != null && searchParameters.size() > 0
//				&& searchParameters.get("pageSize") != null) {
//			pageSize = Integer.parseInt(searchParameters.get("pageSize")
//					.toString());
//		}
//		if (pageSize < 1)
//			pageSize = 1;
//		if (pageSize > 100)
//			pageSize = 100;
//		List<Map> orderMaps = (List<Map>) searchParameters.get("sort");
//		List<Order> orders = new ArrayList<Order>();
//		if (orderMaps != null) {
//			for (Map m : orderMaps) {
//				if (m.get("field") == null)
//					continue;
//				String field = m.get("field").toString();
//				if (!StringUtils.isEmpty(field)) {
//					String dir = m.get("dir").toString();
//					if ("DESC".equalsIgnoreCase(dir)) {
//						orders.add(new Order(Direction.DESC, field));
//					} else {
//						orders.add(new Order(Direction.ASC, field));
//					}
//				}
//			}
//		}
//		PageRequest pageable;
//		if (orders.size() > 0) {
//			pageable = new PageRequest(page, pageSize, new Sort(orders));
//		} else {
//			Sort s = new Sort(Direction.ASC, "id");
//			pageable = new PageRequest(page, pageSize, s);
//		}
//		return null;
//		}

}
