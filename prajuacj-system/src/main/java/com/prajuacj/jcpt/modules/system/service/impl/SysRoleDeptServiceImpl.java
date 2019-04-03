/**
 * Project Name:prajuacj-system
 * File Name:SysRoleDeptServiceImpl.java
 * Package Name:com.prajuacj.jcpt.modules.system.service.impl
 * Date:2019年3月29日下午12:05:38
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prajuacj.jcpt.modules.system.dao.SysRoleDeptDao;
import com.prajuacj.jcpt.modules.system.entity.SysRoleDeptEntity;
import com.prajuacj.jcpt.modules.system.service.ISysRoleDeptService;

/**
 * ClassName:SysRoleDeptServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年3月29日 下午12:05:38 <br/>
 * @author   prajuacj
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service("sysRoleDeptService")
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptDao, SysRoleDeptEntity> implements ISysRoleDeptService {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveOrUpdate(Long roleId, List<Long> deptIdList) {
		//先删除角色与部门关系
		deleteBatch(new Long[]{roleId});

		if(deptIdList.size() == 0){
			return ;
		}

		//保存角色与菜单关系
		for(Long deptId : deptIdList){
			SysRoleDeptEntity sysRoleDeptEntity = new SysRoleDeptEntity();
			sysRoleDeptEntity.setDeptId(deptId);
			sysRoleDeptEntity.setRoleId(roleId);

			this.save(sysRoleDeptEntity);
		}
	}

	@Override
	public List<Long> queryDeptIdList(Long[] roleIds) {
		return baseMapper.queryDeptIdList(roleIds);
	}

	@Override
	public int deleteBatch(Long[] roleIds){
		return baseMapper.deleteBatch(roleIds);
	}
}