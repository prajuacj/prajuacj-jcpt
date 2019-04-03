/**
 * Project Name:prajuacj-common
 * File Name:SHAUtils.java
 * Package Name:com.prajuacj.jcpt.common.utils
 * Date:2019年3月29日下午12:35:09
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * ClassName:SHAUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午12:35:09 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public class SHAUtils {

	/** 加密算法 */
	public final static String hashAlgorithmName = "SHA-256";
	/** 循环次数 */
	public final static int hashIterations = 16;

	public static String sha256(String password, String salt) {
		return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
	}
}
