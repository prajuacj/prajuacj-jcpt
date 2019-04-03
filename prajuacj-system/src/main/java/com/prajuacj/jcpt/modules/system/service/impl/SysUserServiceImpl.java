/**
 * Project Name:prajuacj-system
 * File Name:SysUserServiceImpl.java
 * Package Name:com.prajuacj.jcpt.modules.system.service.impl
 * Date:2019年3月29日下午12:07:12
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
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
import com.prajuacj.jcpt.common.utils.SHAUtils;
import com.prajuacj.jcpt.modules.system.dao.SysUserDao;
import com.prajuacj.jcpt.modules.system.entity.SysDeptEntity;
import com.prajuacj.jcpt.modules.system.entity.SysUserEntity;
import com.prajuacj.jcpt.modules.system.service.ISysDeptService;
import com.prajuacj.jcpt.modules.system.service.ISysUserRoleService;
import com.prajuacj.jcpt.modules.system.service.ISysUserService;

/**
 * ClassName:SysUserServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午12:07:12 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements ISysUserService {
	@Autowired
	private ISysUserRoleService sysUserRoleService;
	@Autowired
	private ISysDeptService sysDeptService;

	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return baseMapper.queryAllMenuId(userId);
	}

	@Override
	@DataFilter(subDept = true, user = false)
	public PageUtils queryPage(Map<String, Object> params) {
		String username = (String) params.get("username");

		IPage<SysUserEntity> page = this.page(new Query<SysUserEntity>().getPage(params),
				new QueryWrapper<SysUserEntity>().like(StringUtils.isNotBlank(username), "username", username)
						.apply(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER)));

		for (SysUserEntity sysUserEntity : page.getRecords()) {
			SysDeptEntity sysDeptEntity = sysDeptService.getById(sysUserEntity.getDeptId());
			sysUserEntity.setDeptName(sysDeptEntity.getName());
		}

		return new PageUtils(page);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveUser(SysUserEntity user) {
		user.setCreateTime(new Date());
		// sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		user.setSalt(salt);
		user.setPassword(SHAUtils.sha256(user.getPassword(), user.getSalt()));
		this.save(user);

		// 保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SysUserEntity user) {
		if (StringUtils.isBlank(user.getPassword())) {
			user.setPassword(null);
		} else {
			SysUserEntity userEntity = this.getById(user.getUserId());
			user.setPassword(SHAUtils.sha256(user.getPassword(), userEntity.getSalt()));
		}
		this.updateById(user);

		// 保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}

	@Override
	public boolean updatePassword(Long userId, String password, String newPassword) {
		SysUserEntity userEntity = new SysUserEntity();
		userEntity.setPassword(newPassword);
		return this.update(userEntity,
				new QueryWrapper<SysUserEntity>().eq("user_id", userId).eq("password", password));
	}

	@Override
	public List<String> queryAllPerms(Long userId) {
		
		// TODO Auto-generated method stub
		return baseMapper.queryAllPerms(userId);
	}
}
