package cn.com.taiji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.com.taiji.domain.Role;

/**
 * 
 * 类名称：RoleRepository   
 * 类描述：   角色的dao层
 * 创建人：Meng   
 * 创建时间：2017年12月8日 下午4:17:56 
 * @version
 */

public interface RoleRepository extends 
JpaRepository<Role, String>,JpaSpecificationExecutor<Role>,PagingAndSortingRepository<Role,String>{


}
