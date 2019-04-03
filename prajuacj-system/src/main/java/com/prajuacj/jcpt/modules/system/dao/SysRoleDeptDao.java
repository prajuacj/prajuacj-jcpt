/**
 * Project Name:prajuacj-system
 * File Name:SysRoleDeptDao.java
 * Package Name:com.prajuacj.jcpt.modules.system.dao
 * Date:2019年3月28日下午5:08:00
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prajuacj.jcpt.modules.system.entity.SysRoleDeptEntity;

/**
 * ClassName:SysRoleDeptDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月28日 下午5:08:00 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Mapper
public interface SysRoleDeptDao extends BaseMapper<SysRoleDeptEntity> {

	/**
	 * 根据角色ID，获取部门ID列表
	 */
	List<Long> queryDeptIdList(Long[] roleIds);

	/**
	 * 根据角色ID数组，批量删除
	 */
	int deleteBatch(Long[] roleIds);

}
