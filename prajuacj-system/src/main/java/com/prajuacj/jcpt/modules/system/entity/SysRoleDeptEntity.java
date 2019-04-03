/**
 * Project Name:prajuacj-system
 * File Name:SysRoleDeptEntity.java
 * Package Name:com.prajuacj.jcpt.modules.system.entity
 * Date:2019年3月28日下午3:00:41
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * ClassName:SysRoleDeptEntity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年3月28日 下午3:00:41 <br/>
 * @author   prajuacj
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@TableName("sys_role_dept")
public class SysRoleDeptEntity implements Serializable {
	
	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = 3935823760679955187L;

	@TableId
	private Long id;

	/**
	 * 角色ID
	 */
	private Long roleId;

	/**
	 * 部门ID
	 */
	private Long deptId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
}

