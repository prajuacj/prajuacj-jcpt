/**
 * Project Name:prajuacj-system
 * File Name:ISysMenuService.java
 * Package Name:com.prajuacj.jcpt.modules.system.service
 * Date:2019年3月29日上午10:43:14
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prajuacj.jcpt.modules.system.entity.SysMenuEntity;

/**
 * ClassName:ISysMenuService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午10:43:14 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ISysMenuService extends IService<SysMenuEntity> {

	/**
	 * 根据父菜单，查询子菜单
	 * 
	 * @param parentId   父菜单ID
	 * @param menuIdList 用户菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);

	/**
	 * 根据父菜单，查询子菜单
	 * 
	 * @param parentId 父菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Long parentId);

	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenuEntity> queryNotButtonList();

	/**
	 * 获取用户菜单列表
	 */
	List<SysMenuEntity> getUserMenuList(Long userId);

	/**
	 * 删除
	 */
	void delete(Long menuId);
}
