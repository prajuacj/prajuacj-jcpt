/**
 * Project Name:prajuacj-system
 * File Name:SysDeptServiceImpl.java
 * Package Name:com.prajuacj.jcpt.modules.system.service.impl
 * Date:2019年3月29日下午12:04:27
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prajuacj.jcpt.common.annotation.DataFilter;
import com.prajuacj.jcpt.modules.system.dao.SysDeptDao;
import com.prajuacj.jcpt.modules.system.entity.SysDeptEntity;
import com.prajuacj.jcpt.modules.system.service.ISysDeptService;

/**
 * ClassName:SysDeptServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午12:04:27 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Service("sysDeptService")
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDeptEntity> implements ISysDeptService {

	@Override
	@DataFilter(subDept = true, user = false, tableAlias = "t1")
	public List<SysDeptEntity> queryList(Map<String, Object> params) {
		return baseMapper.queryList(params);
	}

	@Override
	public List<Long> queryDetpIdList(Long parentId) {
		return baseMapper.queryDetpIdList(parentId);
	}

	@Override
	public List<Long> getSubDeptIdList(Long deptId) {
		// 部门及子部门ID列表
		List<Long> deptIdList = new ArrayList<>();

		// 获取子部门ID
		List<Long> subIdList = queryDetpIdList(deptId);
		getDeptTreeList(subIdList, deptIdList);

		return deptIdList;
	}

	/**
	 * 递归
	 */
	private void getDeptTreeList(List<Long> subIdList, List<Long> deptIdList) {
		for (Long deptId : subIdList) {
			List<Long> list = queryDetpIdList(deptId);
			if (list.size() > 0) {
				getDeptTreeList(list, deptIdList);
			}

			deptIdList.add(deptId);
		}
	}
}
