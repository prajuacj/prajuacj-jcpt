/**
 * Project Name:prajuacj-system
 * File Name:ISysRoleService.java
 * Package Name:com.prajuacj.jcpt.modules.system.service
 * Date:2019年3月29日上午10:45:48
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.modules.system.entity.SysRoleEntity;

/**
 * ClassName:ISysRoleService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午10:45:48 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ISysRoleService extends IService<SysRoleEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void saveRole(SysRoleEntity role);

	void update(SysRoleEntity role);

	void deleteBatch(Long[] roleIds);
}
