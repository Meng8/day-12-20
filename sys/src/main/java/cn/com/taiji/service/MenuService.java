package cn.com.taiji.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.taiji.domain.Menu;
import cn.com.taiji.dto.MenuDto;
import cn.com.taiji.dto.TreeDto;
import cn.com.taiji.repository.MenuRepository;
@Service
public class MenuService {
	@Autowired
	MenuRepository menuRepository;

	 //查找全部
	public List<Menu> fingAllMenu(){
		return menuRepository.findAll();
	}
	
	
	
	//查找单个
	public MenuDto fingOne(String id) {
		Menu menu = menuRepository.findOne(id);
		MenuDto menuDto = new MenuDto();
		BeanUtils.copyProperties(menu, menuDto);
		return menuDto;
	}
	
	//新增和修改
	public void addMenu(MenuDto menudto) {
		Menu menu = new Menu();
		BeanUtils.copyProperties(menudto, menu);
		menuRepository.saveAndFlush(menu);
	}
	//删除
	public void deleteMenu(String id) {
		menuRepository.delete(id);
	} 
	
	public TreeDto toTreeDto(Menu m) {
		TreeDto treeDto = new TreeDto();
		
		treeDto.setId(m.getId());
		treeDto.setText(m.getName());
		treeDto.setUrl(m.getUrl());
		
		List<Menu> list = new ArrayList<>();
		for (Menu menu : m.getMenus()) {
			if(menu!=null) {
				TreeDto treeDto2 = toTreeDto(menu);
				list.add(treeDto2);
			}
		}
		treeDto.setNodes(list);
		
		return treeDto;
	}

}
