package cn.com.taiji.service;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.taiji.domain.Role;
import cn.com.taiji.dto.RoleDto;
import cn.com.taiji.repository.RoleRepository;

/**
 * 
 * 类名称：RoleService   
 * 类描述：   角色的代理层
 * 创建人：Meng   
 * 创建时间：2017年12月8日 下午4:32:26 
 * @version
 */
@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	    //查找全部
		public List<Role> fingAllRole(){
			return roleRepository.findAll();
		}
		//查找单个
		public RoleDto fingOne(String id) {
			Role role = roleRepository.findOne(id);
			RoleDto roleDto = new RoleDto();
			BeanUtils.copyProperties(role, roleDto);
			return roleDto;
			
		}
		
		//新增和修改
		public void addRole(RoleDto roledto) {
			Role role = new Role();
			BeanUtils.copyProperties(roledto, role);//把roledto转换成role实体类类型
			roleRepository.saveAndFlush(role);
		}
		//删除
		public void deleteRole(String id) {
			roleRepository.delete(id);
		} 
		
	
	

}
