/**
 * Project Name:prajuacj-system
 * File Name:SysLogServiceImpl.java
 * Package Name:com.prajuacj.jcpt.modules.system.service.impl
 * Date:2019年3月29日下午12:05:00
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
import com.prajuacj.jcpt.modules.system.dao.SysLogDao;
import com.prajuacj.jcpt.modules.system.entity.SysLogEntity;
import com.prajuacj.jcpt.modules.system.service.ISysLogService;

/**
 * ClassName:SysLogServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午12:05:00 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements ISysLogService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String key = (String) params.get("key");

		IPage<SysLogEntity> page = this.page(new Query<SysLogEntity>().getPage(params),
				new QueryWrapper<SysLogEntity>().like(StringUtils.isNotBlank(key), "username", key));

		return new PageUtils(page);
	}
}