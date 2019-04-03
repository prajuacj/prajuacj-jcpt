/**
 * Project Name:prajuacj-admin
 * File Name:FreemarkerConfig.java
 * Package Name:com.prajuacj.jcpt.admin.config
 * Date:2019年4月1日下午4:18:43
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.admin.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.prajuacj.jcpt.admin.shiro.ShiroTag;

/**
 * ClassName:FreemarkerConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年4月1日 下午4:18:43 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Configuration
public class FreemarkerConfig {

	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer(ShiroTag shiroTag) {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPath("classpath:/templates");
		Map<String, Object> variables = new HashMap<>(1);
		variables.put("shiro", shiroTag);
		configurer.setFreemarkerVariables(variables);

		Properties settings = new Properties();
		settings.setProperty("default_encoding", "utf-8");
		settings.setProperty("number_format", "0.##");
		configurer.setFreemarkerSettings(settings);
		return configurer;
	}
}
