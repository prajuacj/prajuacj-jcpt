/**
 * Project Name:prajuacj-common
 * File Name:SQLFilter.java
 * Package Name:com.prajuacj.jcpt.common.xss
 * Date:2019年3月29日上午11:57:15
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.common.xss;

import org.apache.commons.lang.StringUtils;

import com.prajuacj.jcpt.common.exception.RRException;

/**
 * ClassName:SQLFilter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午11:57:15 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public class SQLFilter {

	/**
	 * SQL注入过滤
	 * 
	 * @param str 待验证的字符串
	 */
	public static String sqlInject(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		// 去掉'|"|;|\字符
		str = StringUtils.replace(str, "'", "");
		str = StringUtils.replace(str, "\"", "");
		str = StringUtils.replace(str, ";", "");
		str = StringUtils.replace(str, "\\", "");

		// 转换成小写
		str = str.toLowerCase();

		// 非法字符
		String[] keywords = { "master", "truncate", "insert", "select", "delete", "update", "declare", "alter",
				"drop" };

		// 判断是否包含非法字符
		for (String keyword : keywords) {
			if (str.indexOf(keyword) != -1) {
				throw new RRException("包含非法字符");
			}
		}

		return str;
	}
}
