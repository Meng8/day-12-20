package cn.com.taiji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.taiji.service.RoleService;
/**
 * 
 * 类名称：RoleController   
 * 类描述：   用户表
 * 创建人：Meng   
 * 创建时间：2017年12月10日 下午10:37:34 
 * @version
 */

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService roleservice;
	

}
