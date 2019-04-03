/**
 * Project Name:prajuacj-admin
 * File Name:SysRoleController.java
 * Package Name:com.prajuacj.jcpt.admin.sys.controller
 * Date:2019年4月2日下午6:04:51
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.admin.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prajuacj.jcpt.common.annotation.SysLog;
import com.prajuacj.jcpt.common.base.R;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.common.validator.ValidatorUtils;
import com.prajuacj.jcpt.modules.system.entity.SysRoleEntity;
import com.prajuacj.jcpt.modules.system.service.ISysRoleDeptService;
import com.prajuacj.jcpt.modules.system.service.ISysRoleMenuService;
import com.prajuacj.jcpt.modules.system.service.ISysRoleService;

/**
 * ClassName:SysRoleController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年4月2日 下午6:04:51 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {
	@Autowired
	private ISysRoleService sysRoleService;
	@Autowired
	private ISysRoleMenuService sysRoleMenuService;
	@Autowired
	private ISysRoleDeptService sysRoleDeptService;

	/**
	 * 角色列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:role:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = sysRoleService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 角色列表
	 */
	@RequestMapping("/select")
	@RequiresPermissions("sys:role:select")
	public R select() {
		List<SysRoleEntity> list = sysRoleService.list();

		return R.ok().put("list", list);
	}

	/**
	 * 角色信息
	 */
	@RequestMapping("/info/{roleId}")
	@RequiresPermissions("sys:role:info")
	public R info(@PathVariable("roleId") Long roleId) {
		SysRoleEntity role = sysRoleService.getById(roleId);

		// 查询角色对应的菜单
		List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
		role.setMenuIdList(menuIdList);

		// 查询角色对应的部门
		List<Long> deptIdList = sysRoleDeptService.queryDeptIdList(new Long[] { roleId });
		role.setDeptIdList(deptIdList);

		return R.ok().put("role", role);
	}

	/**
	 * 保存角色
	 */
	@SysLog("保存角色")
	@RequestMapping("/save")
	@RequiresPermissions("sys:role:save")
	public R save(@RequestBody SysRoleEntity role) {
		ValidatorUtils.validateEntity(role);

		sysRoleService.saveRole(role);

		return R.ok();
	}

	/**
	 * 修改角色
	 */
	@SysLog("修改角色")
	@RequestMapping("/update")
	@RequiresPermissions("sys:role:update")
	public R update(@RequestBody SysRoleEntity role) {
		ValidatorUtils.validateEntity(role);

		sysRoleService.update(role);

		return R.ok();
	}

	/**
	 * 删除角色
	 */
	@SysLog("删除角色")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:role:delete")
	public R delete(@RequestBody Long[] roleIds) {
		sysRoleService.deleteBatch(roleIds);

		return R.ok();
	}
}
