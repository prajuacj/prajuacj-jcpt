/**
 * Project Name:prajuacj-admin
 * File Name:SysPageController.java
 * Package Name:com.prajuacj.jcpt.admin.sys.controller
 * Date:2019年4月2日下午5:30:32
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.admin.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:SysPageController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年4月2日 下午5:30:32 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Controller
public class SysPageController {

	@RequestMapping("modules/{module}/{url}.html")
	public String module(@PathVariable("module") String module, @PathVariable("url") String url) {
		return "modules/" + module + "/" + url;
	}

	@RequestMapping(value = { "/", "index.html" })
	public String index() {
		return "index";
	}

	@RequestMapping("index1.html")
	public String index1() {
		return "index1";
	}

	@RequestMapping("login.html")
	public String login() {
		return "login";
	}

	@RequestMapping("main.html")
	public String main() {
		return "main";
	}

	@RequestMapping("404.html")
	public String notFound() {
		return "404";
	}
}
