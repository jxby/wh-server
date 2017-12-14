package com.wanghuan.controller.sys;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wanghuan.model.sys.MenuEntity;
import com.wanghuan.model.sys.UserEntity;
import com.wanghuan.service.sys.MenuService;
import com.wanghuan.service.sys.UserService;

@RestController
public class MenuController {
	
	private Logger log = LoggerFactory.getLogger(MenuController.class);
	
	@Resource(name = "menuServiceImpl")
	private MenuService menuService;
	
	@Resource(name = "userServiceImpl")
	private UserService userService;
	
	@GetMapping("/menu/{loginName}")
	public List<MenuEntity> menuList(@PathVariable String loginName){
		UserEntity userEntity = userService.getUserEntityByLoginName(loginName);
		List<MenuEntity> menuList = menuService.menuList(userEntity.getId());
		return menuList;
	}
}
