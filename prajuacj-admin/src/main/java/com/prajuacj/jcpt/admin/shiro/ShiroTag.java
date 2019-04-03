/**
 * Project Name:prajuacj-admin
 * File Name:ShiroTag.java
 * Package Name:com.prajuacj.jcpt.admin.shiro
 * Date:2019年4月1日上午10:55:36
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.admin.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

/**
 * ClassName:ShiroTag <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年4月1日 上午10:55:36 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Component
public class ShiroTag {

	/**
	 * 是否拥有该权限
	 * 
	 * @param permission 权限标识
	 * @return true：是 false：否
	 */
	public boolean hasPermission(String permission) {
		Subject subject = SecurityUtils.getSubject();
		return subject != null && subject.isPermitted(permission);
	}
}
