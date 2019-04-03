/**
 * Project Name:prajuacj-generator
 * File Name:SysGeneratorServiceImpl.java
 * Package Name:com.prajuacj.jcpt.modules.generator.service.impl
 * Date:2019年3月29日下午3:05:33
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.generator.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.prajuacj.jcpt.generator.dao.GeneratorDao;
import com.prajuacj.jcpt.generator.service.ISysGeneratorService;
import com.prajuacj.jcpt.generator.utils.GenUtils;
import com.prajuacj.jcpt.generator.utils.PageUtils;
import com.prajuacj.jcpt.generator.utils.Query;

/**
 * ClassName:SysGeneratorServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午3:05:33 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Service("sysGeneratorService")
public class SysGeneratorServiceImpl implements ISysGeneratorService {

	@Autowired
	private GeneratorDao generatorDao;

	public PageUtils queryList(Query query) {
		Page<?> page = PageHelper.startPage(query.getPage(), query.getLimit());
		List<Map<String, Object>> list = generatorDao.queryList(query);

		return new PageUtils(list, (int) page.getTotal(), query.getLimit(), query.getPage());
	}

	public Map<String, String> queryTable(String tableName) {
		return generatorDao.queryTable(tableName);
	}

	public List<Map<String, String>> queryColumns(String tableName) {
		return generatorDao.queryColumns(tableName);
	}

	public byte[] generatorCode(String[] tableNames) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);

		for (String tableName : tableNames) {
			// 查询表信息
			Map<String, String> table = queryTable(tableName);
			// 查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
			// 生成代码
			GenUtils.generatorCode(table, columns, zip);
		}
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}
}
