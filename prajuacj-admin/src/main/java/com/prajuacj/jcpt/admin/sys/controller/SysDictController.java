/**
 * Project Name:prajuacj-admin
 * File Name:SysDictController.java
 * Package Name:com.prajuacj.jcpt.admin.sys.controller
 * Date:2019年4月2日下午6:00:31
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.admin.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prajuacj.jcpt.common.base.R;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.common.validator.ValidatorUtils;
import com.prajuacj.jcpt.modules.system.entity.SysDictEntity;
import com.prajuacj.jcpt.modules.system.service.ISysDictService;

/**
 * ClassName:SysDictController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年4月2日 下午6:00:31 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@RestController
@RequestMapping("sys/dict")
public class SysDictController {
	@Autowired
	private ISysDictService sysDictService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:dict:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = sysDictService.queryPage(params);

		return R.ok().put("page", page);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:dict:info")
	public R info(@PathVariable("id") Long id) {
		SysDictEntity dict = sysDictService.getById(id);

		return R.ok().put("dict", dict);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:dict:save")
	public R save(@RequestBody SysDictEntity dict) {
		// 校验类型
		ValidatorUtils.validateEntity(dict);

		sysDictService.save(dict);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:dict:update")
	public R update(@RequestBody SysDictEntity dict) {
		// 校验类型
		ValidatorUtils.validateEntity(dict);

		sysDictService.updateById(dict);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:dict:delete")
	public R delete(@RequestBody Long[] ids) {
		sysDictService.removeByIds(Arrays.asList(ids));

		return R.ok();
	}
}
