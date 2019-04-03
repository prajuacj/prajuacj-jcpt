/**
 * Project Name:prajuacj-system
 * File Name:ISysConfigService.java
 * Package Name:com.prajuacj.jcpt.modules.system.service
 * Date:2019年3月29日上午10:20:42
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.modules.system.entity.SysConfigEntity;

/**
 * ClassName:ISysConfigService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午10:20:42 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ISysConfigService extends IService<SysConfigEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 保存配置信息
	 */
	void saveConfig(SysConfigEntity config);

	/**
	 * 更新配置信息
	 */
	void update(SysConfigEntity config);

	/**
	 * 根据key，更新value
	 */
	void updateValueByKey(String key, String value);

	/**
	 * 删除配置信息
	 */
	void deleteBatch(Long[] ids);

	/**
	 * 根据key，获取配置的value值
	 * 
	 * @param key key
	 */
	String getValue(String key);

	/**
	 * 根据key，获取value的Object对象
	 * 
	 * @param key   key
	 * @param clazz Object对象
	 */
	<T> T getConfigObject(String key, Class<T> clazz);
}
