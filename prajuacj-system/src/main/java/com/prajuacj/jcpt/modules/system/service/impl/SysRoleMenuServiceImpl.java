/**
 * Project Name:prajuacj-system
 * File Name:SysRoleMenuServiceImpl.java
 * Package Name:com.prajuacj.jcpt.modules.system.service.impl
 * Date:2019年3月29日下午12:06:08
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prajuacj.jcpt.modules.system.dao.SysRoleMenuDao;
import com.prajuacj.jcpt.modules.system.entity.SysRoleMenuEntity;
import com.prajuacj.jcpt.modules.system.service.ISysRoleMenuService;

/**
 * ClassName:SysRoleMenuServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午12:06:08 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenuEntity>
		implements ISysRoleMenuService {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
		// 先删除角色与菜单关系
		deleteBatch(new Long[] { roleId });

		if (menuIdList.size() == 0) {
			return;
		}

		// 保存角色与菜单关系
		for (Long menuId : menuIdList) {
			SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
			sysRoleMenuEntity.setMenuId(menuId);
			sysRoleMenuEntity.setRoleId(roleId);

			this.save(sysRoleMenuEntity);
		}
	}

	@Override
	public List<Long> queryMenuIdList(Long roleId) {
		return baseMapper.queryMenuIdList(roleId);
	}

	@Override
	public int deleteBatch(Long[] roleIds) {
		return baseMapper.deleteBatch(roleIds);
	}
}