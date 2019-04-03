/**
 * Project Name:prajuacj-system
 * File Name:SysConfigServiceImpl.java
 * Package Name:com.prajuacj.jcpt.modules.system.service.impl
 * Date:2019年3月29日上午10:51:26
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service.impl;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prajuacj.jcpt.common.exception.RRException;
import com.prajuacj.jcpt.common.mybatisplus.Query;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.modules.system.dao.SysConfigDao;
import com.prajuacj.jcpt.modules.system.entity.SysConfigEntity;
import com.prajuacj.jcpt.modules.system.redis.SysConfigRedis;
import com.prajuacj.jcpt.modules.system.service.ISysConfigService;

/**
 * ClassName:SysConfigServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午10:51:26 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Service("sysConfigService")
public class SysConfigServiceImpl extends ServiceImpl<SysConfigDao, SysConfigEntity> implements ISysConfigService {
	@Autowired
	private SysConfigRedis sysConfigRedis;

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String paramKey = (String) params.get("paramKey");

		IPage<SysConfigEntity> page = this.page(new Query<SysConfigEntity>().getPage(params),
				new QueryWrapper<SysConfigEntity>().like(StringUtils.isNotBlank(paramKey), "param_key", paramKey)
						.eq("status", 1));

		return new PageUtils(page);
	}

	@Override
	public void saveConfig(SysConfigEntity config) {
		this.save(config);
		sysConfigRedis.saveOrUpdate(config);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SysConfigEntity config) {
		this.updateById(config);
		sysConfigRedis.saveOrUpdate(config);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateValueByKey(String key, String value) {
		baseMapper.updateValueByKey(key, value);
		sysConfigRedis.delete(key);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBatch(Long[] ids) {
		for (Long id : ids) {
			SysConfigEntity config = this.getById(id);
			sysConfigRedis.delete(config.getParamKey());
		}

		this.removeByIds(Arrays.asList(ids));
	}

	@Override
	public String getValue(String key) {
		SysConfigEntity config = sysConfigRedis.get(key);
		if (config == null) {
			config = baseMapper.queryByKey(key);
			sysConfigRedis.saveOrUpdate(config);
		}

		return config == null ? null : config.getParamValue();
	}

	@Override
	public <T> T getConfigObject(String key, Class<T> clazz) {
		String value = getValue(key);
		if (StringUtils.isNotBlank(value)) {
			return JSON.parseObject(value, clazz);
		}

		try {
			return clazz.newInstance();
		} catch (Exception e) {
			throw new RRException("获取参数失败");
		}
	}
}
