/**
 * Project Name:prajuacj-system
 * File Name:SysDeptDao.java
 * Package Name:com.prajuacj.jcpt.modules.system.dao
 * Date:2019年3月28日下午4:56:19
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prajuacj.jcpt.modules.system.entity.SysDeptEntity;

/**
 * ClassName:SysDeptDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月28日 下午4:56:19 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Mapper
public interface SysDeptDao extends BaseMapper<SysDeptEntity> {

	List<SysDeptEntity> queryList(Map<String, Object> params);

	/**
	 * 查询子部门ID列表
	 * 
	 * @param parentId 上级部门ID
	 */
	List<Long> queryDetpIdList(Long parentId);
}
