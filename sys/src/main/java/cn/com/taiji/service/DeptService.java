package cn.com.taiji.service;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.taiji.domain.Dept;
import cn.com.taiji.dto.DeptDto;
import cn.com.taiji.dto.UserDto;
import cn.com.taiji.repository.DeptRepository;
import cn.com.taiji.repository.UserRepository;

@Service
public class DeptService {

	@Autowired
	private DeptRepository deptRepository;
	
	//查找单个
		public DeptDto findOne(String id) {
			Dept dept = deptRepository.findOne(id);
			DeptDto deptDto = new DeptDto();
			BeanUtils.copyProperties(dept, deptDto);
			return deptDto;
		}
//		public void saveDept(String deptName) {
//			Dept dept = new Dept();
//			dept.setId(UUID.randomUUID().toString());
//			deptRepository.saveAndFlush(dept);
//		}
		//新增和修改
		public void addDept(DeptDto deptDto) {
			Dept dept = new Dept();
			BeanUtils.copyProperties(deptDto, dept);
			dept.setId(UUID.randomUUID().toString());
			deptRepository.saveAndFlush(dept);
		}
		//删除
		public void deleteDept(String id) {
			deptRepository.delete(id);
		} 
}
