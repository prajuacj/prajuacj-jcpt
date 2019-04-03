/**
 * Project Name:prajuacj-system
 * File Name:SysUserRoleServiceImpl.java
 * Package Name:com.prajuacj.jcpt.modules.system.service.impl
 * Date:2019年3月29日下午12:06:53
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prajuacj.jcpt.modules.system.dao.SysUserRoleDao;
import com.prajuacj.jcpt.modules.system.entity.SysUserRoleEntity;
import com.prajuacj.jcpt.modules.system.service.ISysUserRoleService;

/**
 * ClassName:SysUserRoleServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午12:06:53 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity>
		implements ISysUserRoleService {
	@Override
	public void saveOrUpdate(Long userId, List<Long> roleIdList) {
		// 先删除用户与角色关系
		this.remove(new QueryWrapper<SysUserRoleEntity>().eq("user_id", userId));

		if (roleIdList == null || roleIdList.size() == 0) {
			return;
		}

		// 保存用户与角色关系
		for (Long roleId : roleIdList) {
			SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
			sysUserRoleEntity.setUserId(userId);
			sysUserRoleEntity.setRoleId(roleId);

			this.save(sysUserRoleEntity);
		}

	}

	@Override
	public List<Long> queryRoleIdList(Long userId) {
		return baseMapper.queryRoleIdList(userId);
	}

	@Override
	public int deleteBatch(Long[] roleIds) {
		return baseMapper.deleteBatch(roleIds);
	}
}