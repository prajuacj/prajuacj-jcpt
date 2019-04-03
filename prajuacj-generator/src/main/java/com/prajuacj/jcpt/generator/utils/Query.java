/**
 * Project Name:prajuacj-generator
 * File Name:Query.java
 * Package Name:com.prajuacj.jcpt.generator.utils
 * Date:2019年3月29日下午6:19:43
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.generator.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ClassName:Query <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午6:19:43 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public class Query extends LinkedHashMap<String, Object> {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = -3292729910433230152L;
	// 当前页码
	private int page;
	// 每页条数
	private int limit;

	public Query(Map<String, Object> params) {
		this.putAll(params);

		// 分页参数
		this.page = Integer.parseInt(params.get("page").toString());
		this.limit = Integer.parseInt(params.get("limit").toString());
		this.put("offset", (page - 1) * limit);
		this.put("page", page);
		this.put("limit", limit);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
