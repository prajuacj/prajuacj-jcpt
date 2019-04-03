/**
 * Project Name:prajuacj-system
 * File Name:ISysUserService.java
 * Package Name:com.prajuacj.jcpt.modules.system.service
 * Date:2019年3月29日上午10:47:12
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.modules.system.entity.SysUserEntity;

/**
 * ClassName:ISysUserService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午10:47:12 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ISysUserService extends IService<SysUserEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);

	/**
	 * 保存用户
	 */
	void saveUser(SysUserEntity user);

	/**
	 * 修改用户
	 */
	void update(SysUserEntity user);

	/**
	 * 修改密码
	 * 
	 * @param userId      用户ID
	 * @param password    原密码
	 * @param newPassword 新密码
	 */
	boolean updatePassword(Long userId, String password, String newPassword);

	List<String> queryAllPerms(Long userId);
}
