/**
 * Project Name:prajuacj-admin
 * File Name:AbstractController.java
 * Package Name:com.prajuacj.jcpt.modules.sys.controller
 * Date:2019年4月1日上午10:13:56
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.admin.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prajuacj.jcpt.modules.system.entity.SysUserEntity;

/**
 * ClassName:AbstractController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年4月1日 上午10:13:56 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public abstract class AbstractController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected SysUserEntity getUser() {
		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}

	protected Long getDeptId() {
		return getUser().getDeptId();
	}
}
