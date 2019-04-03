/**
 * Project Name:prajuacj-system
 * File Name:SysUserRoleEntity.java
 * Package Name:com.prajuacj.jcpt.modules.system.entity
 * Date:2019年3月28日下午3:49:30
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * ClassName:SysUserRoleEntity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月28日 下午3:49:30 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@TableName("sys_user_role")
public class SysUserRoleEntity implements Serializable {
	
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = 8656608255773419082L;

	@TableId
	private Long id;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 角色ID
	 */
	private Long roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
