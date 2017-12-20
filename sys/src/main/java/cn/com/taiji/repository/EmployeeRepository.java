package cn.com.taiji.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.com.taiji.domain.Employee;

/**
 * 
 * 类名称：EmployeeRepository   
 * 类描述：   用户表dao层
 * 创建人：Meng   
 * 创建时间：2017年12月8日 下午4:13:31 
 * @version
 */

public interface EmployeeRepository extends  
JpaRepository<Employee, String>,JpaSpecificationExecutor<Employee>,PagingAndSortingRepository<Employee,String>{


	//Employee findOne(long empId);
	
	

}
