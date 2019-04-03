/**
 * Project Name:prajuacj-common
 * File Name:HttpContextUtils.java
 * Package Name:com.prajuacj.jcpt.common.utils
 * Date:2019年3月29日上午11:07:33
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * ClassName:HttpContextUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午11:07:33 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public class HttpContextUtils {

	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
}
