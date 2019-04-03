/**
 * Project Name:prajuacj-generator
 * File Name:DbConfig.java
 * Package Name:com.prajuacj.jcpt.generator.config
 * Date:2019年3月29日下午5:58:14
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.generator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.prajuacj.jcpt.generator.dao.GeneratorDao;
import com.prajuacj.jcpt.generator.dao.MySQLGeneratorDao;
import com.prajuacj.jcpt.generator.dao.OracleGeneratorDao;
import com.prajuacj.jcpt.generator.dao.PostgreSQLGeneratorDao;
import com.prajuacj.jcpt.generator.dao.SQLServerGeneratorDao;
import com.prajuacj.jcpt.generator.utils.RRException;

/**
 * ClassName:DbConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 下午5:58:14 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Configuration
public class DbConfig {

	@Value("${prajuacj.database: mysql}")
	private String database;
	@Autowired
	private MySQLGeneratorDao mySQLGeneratorDao;
	@Autowired
	private OracleGeneratorDao oracleGeneratorDao;
	@Autowired
	private SQLServerGeneratorDao sqlServerGeneratorDao;
	@Autowired
	private PostgreSQLGeneratorDao postgreSQLGeneratorDao;

	@Bean
	@Primary
	public GeneratorDao getGeneratorDao() {
		if ("mysql".equalsIgnoreCase(database)) {
			return mySQLGeneratorDao;
		} else if ("oracle".equalsIgnoreCase(database)) {
			return oracleGeneratorDao;
		} else if ("sqlserver".equalsIgnoreCase(database)) {
			return sqlServerGeneratorDao;
		} else if ("postgresql".equalsIgnoreCase(database)) {
			return postgreSQLGeneratorDao;
		} else {
			throw new RRException("不支持当前数据库：" + database);
		}
	}
}
