/**
 * Project Name:prajuacj-generator
 * File Name:ISysGeneratorService.java
 * Package Name:com.prajuacj.jcpt.modules.generator.service
 * Date:2019年3月29日下午3:01:45
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.generator.service;

import java.util.List;
import java.util.Map;

import com.prajuacj.jcpt.generator.utils.PageUtils;
import com.prajuacj.jcpt.generator.utils.Query;

/**
 * ClassName:ISysGeneratorService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午3:01:45 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ISysGeneratorService {

	public PageUtils queryList(Query query);

	public Map<String, String> queryTable(String tableName);

	public List<Map<String, String>> queryColumns(String tableName);

	public byte[] generatorCode(String[] tableNames);
}
