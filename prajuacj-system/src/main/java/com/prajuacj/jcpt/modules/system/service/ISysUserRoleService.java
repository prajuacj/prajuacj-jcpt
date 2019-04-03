/**
 * Project Name:prajuacj-system
 * File Name:ISysUserRoleService.java
 * Package Name:com.prajuacj.jcpt.modules.system.service
 * Date:2019年3月29日上午10:46:34
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prajuacj.jcpt.modules.system.entity.SysUserRoleEntity;

/**
 * ClassName:ISysUserRoleService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午10:46:34 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ISysUserRoleService extends IService<SysUserRoleEntity> {

	void saveOrUpdate(Long userId, List<Long> roleIdList);

	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
}
