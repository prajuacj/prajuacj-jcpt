/**
 * Project Name:prajuacj-system
 * File Name:SysConfigRedis.java
 * Package Name:com.prajuacj.jcpt.modules.system.redis
 * Date:2019年3月29日上午11:49:32
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prajuacj.jcpt.common.constants.RedisKeys;
import com.prajuacj.jcpt.core.utils.RedisUtils;
import com.prajuacj.jcpt.modules.system.entity.SysConfigEntity;

/**
 * ClassName:SysConfigRedis <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午11:49:32 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Component
public class SysConfigRedis {

	@Autowired
	private RedisUtils redisUtils;

	public void saveOrUpdate(SysConfigEntity config) {
		if (config == null) {
			return;
		}
		String key = RedisKeys.getSysConfigKey(config.getParamKey());
		redisUtils.set(key, config);
	}

	public void delete(String configKey) {
		String key = RedisKeys.getSysConfigKey(configKey);
		redisUtils.delete(key);
	}

	public SysConfigEntity get(String configKey) {
		String key = RedisKeys.getSysConfigKey(configKey);
		return redisUtils.get(key, SysConfigEntity.class);
	}
}
