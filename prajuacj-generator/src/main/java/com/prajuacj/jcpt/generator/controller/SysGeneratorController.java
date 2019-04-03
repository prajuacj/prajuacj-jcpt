/**
 * Project Name:prajuacj-generator
 * File Name:SysGeneratorController.java
 * Package Name:com.prajuacj.jcpt.generator.controller
 * Date:2019年3月29日下午5:34:11
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.generator.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prajuacj.jcpt.generator.service.ISysGeneratorService;
import com.prajuacj.jcpt.generator.utils.PageUtils;
import com.prajuacj.jcpt.generator.utils.Query;
import com.prajuacj.jcpt.generator.utils.R;

/**
 * ClassName:SysGeneratorController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午5:34:11 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Controller
@RequestMapping("/sys/generator")
public class SysGeneratorController {
	@Autowired
	private ISysGeneratorService sysGeneratorService;

	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils pageUtil = sysGeneratorService.queryList(new Query(params));

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 生成代码
	 */
	@RequestMapping("/code")
	public void code(String tables, HttpServletResponse response) throws IOException {
		byte[] data = sysGeneratorService.generatorCode(tables.split(","));

		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"prajuacj.zip\"");
		response.addHeader("Content-Length", "" + data.length);
		response.setContentType("application/octet-stream; charset=UTF-8");

		IOUtils.write(data, response.getOutputStream());
	}
}