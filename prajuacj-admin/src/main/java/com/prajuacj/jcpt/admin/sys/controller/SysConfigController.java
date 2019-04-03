/**
 * Project Name:prajuacj-admin
 * File Name:SysConfigController.java
 * Package Name:com.prajuacj.jcpt.admin.sys.controller
 * Date:2019年4月2日下午6:03:58
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.admin.sys.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prajuacj.jcpt.common.annotation.SysLog;
import com.prajuacj.jcpt.common.base.R;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.common.validator.ValidatorUtils;
import com.prajuacj.jcpt.modules.system.entity.SysConfigEntity;
import com.prajuacj.jcpt.modules.system.service.ISysConfigService;

/**
 * ClassName:SysConfigController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年4月2日 下午6:03:58 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@RestController
@RequestMapping("/sys/config")
public class SysConfigController extends AbstractController {
	
	@Autowired
	private ISysConfigService sysConfigService;

	/**
	 * 所有配置列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:config:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = sysConfigService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 配置信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:config:info")
	@ResponseBody
	public R info(@PathVariable("id") Long id) {
		SysConfigEntity config = sysConfigService.getById(id);

		return R.ok().put("config", config);
	}

	/**
	 * 保存配置
	 */
	@SysLog("保存配置")
	@RequestMapping("/save")
	@RequiresPermissions("sys:config:save")
	public R save(@RequestBody SysConfigEntity config) {
		ValidatorUtils.validateEntity(config);

		sysConfigService.saveConfig(config);

		return R.ok();
	}

	/**
	 * 修改配置
	 */
	@SysLog("修改配置")
	@RequestMapping("/update")
	@RequiresPermissions("sys:config:update")
	public R update(@RequestBody SysConfigEntity config) {
		ValidatorUtils.validateEntity(config);

		sysConfigService.update(config);

		return R.ok();
	}

	/**
	 * 删除配置
	 */
	@SysLog("删除配置")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:config:delete")
	public R delete(@RequestBody Long[] ids) {
		sysConfigService.deleteBatch(ids);

		return R.ok();
	}
}
