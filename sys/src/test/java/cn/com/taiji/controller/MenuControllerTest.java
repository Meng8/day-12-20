package cn.com.taiji.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.taiji.domain.Menu;
import cn.com.taiji.dto.MenuDto;
import cn.com.taiji.service.MenuService;

/**
 * 
 * 类名称：MenuControllerTest   
 * 类描述：   
 * 创建人：Meng   
 * 创建时间：2017年12月10日 下午11:47:04 
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuControllerTest {
	@Autowired
	MenuService menuservice;
	/**
	 * 
	 * @Description: 增加菜单方法 
	 * @throws
	 * @author Meng
	 * @date 2017年12月11日
	 */
	@Test
	public void addMenuTest() {
			MenuDto menu = new MenuDto();
			menu.setId("66");
			menu.setName("浪哥");
			menu.setUrl("666666");
			menu.setHierarchy("再见");
			menu.setDescpt("下次再来啊！");
			System.out.println(menu);
			menuservice.addMenu(menu);
		}
	/**
	 * 
	 * @Description: 物理删除
	 * @throws
	 * @author Meng
	 * @date 2017年12月11日
	 */
	@Test
	public void deleteMenuTest() {
		menuservice.deleteMenu("8a80a8d860436c6f0160436c8f590000");
	}
	/**
	 * 
	 * @Description: 修改和逻辑删除  
	 * @throws
	 * @author Meng
	 * @date 2017年12月11日
	 */
	@Test
	public void update() {
		MenuDto menu = menuservice.fingOne("8a80a8d860436c6f0160436c8f590000");
		System.out.println(menu);
		menu.setName("浪野");
		menuservice.addMenu(menu);
		System.out.println(menu);
	}
}
