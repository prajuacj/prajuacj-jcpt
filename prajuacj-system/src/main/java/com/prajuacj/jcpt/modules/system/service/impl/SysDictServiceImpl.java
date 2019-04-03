/**
 * Project Name:prajuacj-system
 * File Name:SysDictServiceImpl.java
 * Package Name:com.prajuacj.jcpt.modules.system.service.impl
 * Date:2019年3月29日下午12:04:44
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prajuacj.jcpt.common.mybatisplus.Query;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.modules.system.dao.SysDictDao;
import com.prajuacj.jcpt.modules.system.entity.SysDictEntity;
import com.prajuacj.jcpt.modules.system.service.ISysDictService;

/**
 * ClassName:SysDictServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午12:04:44 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDictEntity> implements ISysDictService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String name = (String) params.get("name");

		IPage<SysDictEntity> page = this.page(new Query<SysDictEntity>().getPage(params),
				new QueryWrapper<SysDictEntity>().like(StringUtils.isNotBlank(name), "name", name));

		return new PageUtils(page);
	}
}