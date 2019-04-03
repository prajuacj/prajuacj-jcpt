/**
 * Project Name:prajuacj-generator
 * File Name:GeneratorDao.java
 * Package Name:com.prajuacj.jcpt.modules.generator.dao
 * Date:2019年3月29日下午2:55:30
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.generator.dao;

import java.util.List;
import java.util.Map;

/**
 * ClassName:GeneratorDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午2:55:30 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public interface GeneratorDao {

	List<Map<String, Object>> queryList(Map<String, Object> map);

	Map<String, String> queryTable(String tableName);

	List<Map<String, String>> queryColumns(String tableName);
}
