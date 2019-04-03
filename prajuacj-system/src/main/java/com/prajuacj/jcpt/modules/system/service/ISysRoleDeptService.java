/**
 * Project Name:prajuacj-system
 * File Name:ISysRoleDeptService.java
 * Package Name:com.prajuacj.jcpt.modules.system.service
 * Date:2019年3月29日上午10:44:00
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prajuacj.jcpt.modules.system.entity.SysRoleDeptEntity;

/**
 * ClassName:ISysRoleDeptService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午10:44:00 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ISysRoleDeptService extends IService<SysRoleDeptEntity> {

	void saveOrUpdate(Long roleId, List<Long> deptIdList);

	/**
	 * 根据角色ID，获取部门ID列表
	 */
	List<Long> queryDeptIdList(Long[] roleIds);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);
}
