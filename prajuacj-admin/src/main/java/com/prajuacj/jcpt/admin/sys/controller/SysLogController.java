/**
 * Project Name:prajuacj-admin
 * File Name:SysLogController.java
 * Package Name:com.prajuacj.jcpt.admin.sys.controller
 * Date:2019年4月2日下午5:59:22
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.admin.sys.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prajuacj.jcpt.common.base.R;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.modules.system.service.ISysLogService;

/**
 * ClassName:SysLogController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年4月2日 下午5:59:22 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Controller
@RequestMapping("/sys/log")
public class SysLogController {
	@Autowired
	private ISysLogService sysLogService;

	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("sys:log:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = sysLogService.queryPage(params);

		return R.ok().put("page", page);
	}
}
