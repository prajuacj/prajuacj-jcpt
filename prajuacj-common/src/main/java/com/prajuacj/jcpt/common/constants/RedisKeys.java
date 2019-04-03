/**
 * Project Name:prajuacj-common
 * File Name:RedisKeys.java
 * Package Name:com.prajuacj.jcpt.common.constants
 * Date:2019年3月29日上午11:20:52
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.common.constants;

/**
 * ClassName:RedisKeys <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午11:20:52 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public class RedisKeys {

	public static String getSysConfigKey(String key) {
		return "sys:config:" + key;
	}

	public static String getShiroSessionKey(String key) {
		return "sessionid:" + key;
	}
}
