/**
 * Project Name:prajuacj-common
 * File Name:Assert.java
 * Package Name:com.prajuacj.jcpt.common.validator
 * Date:2019年3月29日下午9:04:59
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.common.validator;

import org.apache.commons.lang.StringUtils;

import com.prajuacj.jcpt.common.exception.RRException;

/**
 * ClassName:Assert <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午9:04:59 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public abstract class Assert {

	public static void isBlank(String str, String message) {
		if (StringUtils.isBlank(str)) {
			throw new RRException(message);
		}
	}

	public static void isNull(Object object, String message) {
		if (object == null) {
			throw new RRException(message);
		}
	}
}
