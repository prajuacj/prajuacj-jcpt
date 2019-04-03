/**
 * Project Name:prajuacj-admin
 * File Name:MybatisPlusConfig.java
 * Package Name:com.prajuacj.jcpt.admin.config
 * Date:2019年4月1日下午4:12:57
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 * ClassName:MybatisPlusConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年4月1日 下午4:12:57 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Configuration
public class MybatisPlusConfig {

	/**
	 * 分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

	@Bean
	public ISqlInjector sqlInjector() {
		return new LogicSqlInjector();
	}
}
