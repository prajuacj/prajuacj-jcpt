/**
 * Project Name:prajuacj-system
 * File Name:SysRoleServiceImpl.java
 * Package Name:com.prajuacj.jcpt.modules.system.service.impl
 * Date:2019年3月29日下午12:06:29
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prajuacj.jcpt.common.annotation.DataFilter;
import com.prajuacj.jcpt.common.constants.Constant;
import com.prajuacj.jcpt.common.mybatisplus.Query;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.modules.system.dao.SysRoleDao;
import com.prajuacj.jcpt.modules.system.entity.SysDeptEntity;
import com.prajuacj.jcpt.modules.system.entity.SysRoleEntity;
import com.prajuacj.jcpt.modules.system.service.ISysDeptService;
import com.prajuacj.jcpt.modules.system.service.ISysRoleDeptService;
import com.prajuacj.jcpt.modules.system.service.ISysRoleMenuService;
import com.prajuacj.jcpt.modules.system.service.ISysRoleService;
import com.prajuacj.jcpt.modules.system.service.ISysUserRoleService;

/**
 * ClassName:SysRoleServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午12:06:29 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements ISysRoleService {

	@Autowired
	private ISysRoleMenuService sysRoleMenuService;
	@Autowired
	private ISysRoleDeptService sysRoleDeptService;
	@Autowired
	private ISysUserRoleService sysUserRoleService;
	@Autowired
	private ISysDeptService sysDeptService;

	@Override
	@DataFilter(subDept = true, user = false)
	public PageUtils queryPage(Map<String, Object> params) {
		String roleName = (String) params.get("roleName");

		IPage<SysRoleEntity> page = this.page(new Query<SysRoleEntity>().getPage(params),
				new QueryWrapper<SysRoleEntity>().like(StringUtils.isNotBlank(roleName), "role_name", roleName)
						.apply(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER)));

		for (SysRoleEntity sysRoleEntity : page.getRecords()) {
			SysDeptEntity sysDeptEntity = sysDeptService.getById(sysRoleEntity.getDeptId());
			if (sysDeptEntity != null) {
				sysRoleEntity.setDeptName(sysDeptEntity.getName());
			}
		}

		return new PageUtils(page);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveRole(SysRoleEntity role) {
		role.setCreateTime(new Date());
		this.save(role);

		// 保存角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

		// 保存角色与部门关系
		sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SysRoleEntity role) {
		this.updateById(role);

		// 更新角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

		// 保存角色与部门关系
		sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBatch(Long[] roleIds) {
		// 删除角色
		this.removeByIds(Arrays.asList(roleIds));

		// 删除角色与菜单关联
		sysRoleMenuService.deleteBatch(roleIds);

		// 删除角色与部门关联
		sysRoleDeptService.deleteBatch(roleIds);

		// 删除角色与用户关联
		sysUserRoleService.deleteBatch(roleIds);
	}
}
