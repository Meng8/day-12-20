package cn.com.taiji.service;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.taiji.domain.User;
import cn.com.taiji.dto.UserDto;
import cn.com.taiji.repository.UserRepository;
/**
 * 
 * 类名称：UserService   
 * 类描述：   
 * 创建人：Meng   
 * 创建时间：2017年12月18日 下午2:03:05 
 * @version
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//查找单个
		public UserDto findOne(String id) {
			User user = userRepository.findOne(id);
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(user, userDto);
			return userDto;
		}
		//新增和修改
		public void addUser(UserDto userDto) {
			User user = new User();
			BeanUtils.copyProperties(userDto, user);
			userDto.setState(1);
			user.setId(UUID.randomUUID().toString());
			userRepository.saveAndFlush(user);
		}
		//删除
		public void deleteUser(String id) {
			userRepository.delete(id);
		} 
}
