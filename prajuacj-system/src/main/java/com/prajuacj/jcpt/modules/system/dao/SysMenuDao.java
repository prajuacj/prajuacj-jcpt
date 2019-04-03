/**
 * Project Name:prajuacj-system
 * File Name:SysMenuDao.java
 * Package Name:com.prajuacj.jcpt.modules.system.dao
 * Date:2019年3月28日下午5:01:59
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prajuacj.jcpt.modules.system.entity.SysMenuEntity;

/**
 * ClassName:SysMenuDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月28日 下午5:01:59 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenuEntity> {

	/**
	 * 根据父菜单，查询子菜单
	 * 
	 * @param parentId 父菜单ID
	 */
	List<SysMenuEntity> queryListParentId(Long parentId);

	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<SysMenuEntity> queryNotButtonList();
}
