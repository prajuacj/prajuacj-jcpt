/**
 * Project Name:prajuacj-common
 * File Name:R.java
 * Package Name:com.prajuacj.jcpt.common.base
 * Date:2019年3月29日下午5:37:09
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.common.base;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:R <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午5:37:09 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public R() {
		put("code", 0);
	}

	public static R error() {
		return error(500, "未知异常，请联系管理员");
	}

	public static R error(String msg) {
		return error(500, msg);
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}