/**
 * Project Name:prajuacj-generator
 * File Name:RRException.java
 * Package Name:com.prajuacj.jcpt.generator.utils
 * Date:2019年3月29日下午8:02:01
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.generator.utils;

/**
 * ClassName:RRException <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午8:02:01 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public class RRException extends RuntimeException {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = -4037909850803219582L;
	private String msg;
	private int code = 500;

	public RRException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public RRException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public RRException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public RRException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
