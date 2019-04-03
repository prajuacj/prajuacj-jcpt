/**
 * Project Name:prajuacj-system
 * File Name:ISysRoleMenuService.java
 * Package Name:com.prajuacj.jcpt.modules.system.service
 * Date:2019年3月29日上午10:44:50
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prajuacj.jcpt.modules.system.entity.SysRoleMenuEntity;

/**
 * ClassName:ISysRoleMenuService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午10:44:50 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ISysRoleMenuService extends IService<SysRoleMenuEntity> {

	void saveOrUpdate(Long roleId, List<Long> menuIdList);

	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
}
