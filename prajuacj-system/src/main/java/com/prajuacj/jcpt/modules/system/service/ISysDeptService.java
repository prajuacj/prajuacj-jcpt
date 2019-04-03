/**
 * Project Name:prajuacj-system
 * File Name:ISysDeptService.java
 * Package Name:com.prajuacj.jcpt.modules.system.service
 * Date:2019年3月29日上午10:35:24
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prajuacj.jcpt.modules.system.entity.SysDeptEntity;

/**
 * ClassName:ISysDeptService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午10:35:24 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ISysDeptService extends IService<SysDeptEntity> {

	List<SysDeptEntity> queryList(Map<String, Object> map);

	/**
	 * 查询子部门ID列表
	 * 
	 * @param parentId 上级部门ID
	 */
	List<Long> queryDetpIdList(Long parentId);

	/**
	 * 获取子部门ID，用于数据过滤
	 */
	List<Long> getSubDeptIdList(Long deptId);
}
