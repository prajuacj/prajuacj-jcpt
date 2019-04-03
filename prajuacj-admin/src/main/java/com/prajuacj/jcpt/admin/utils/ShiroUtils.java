/**
 * Project Name:prajuacj-admin
 * File Name:ShiroUtils.java
 * Package Name:com.prajuacj.jcpt.admin.sys.utils
 * Date:2019年4月1日上午10:25:48
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.admin.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.prajuacj.jcpt.common.exception.RRException;
import com.prajuacj.jcpt.modules.system.entity.SysUserEntity;

/**
 * ClassName:ShiroUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年4月1日 上午10:25:48 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public class ShiroUtils {

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	public static SysUserEntity getUserEntity() {
		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	public static Long getUserId() {
		return getUserEntity().getUserId();
	}

	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}

	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}

	public static void logout() {
		SecurityUtils.getSubject().logout();
	}

	public static String getKaptcha(String key) {
		Object kaptcha = getSessionAttribute(key);
		if (kaptcha == null) {
			throw new RRException("验证码已失效");
		}
		getSession().removeAttribute(key);
		return kaptcha.toString();
	}
}
