/**
 * Project Name:prajuacj-admin
 * File Name:FilterConfig.java
 * Package Name:com.prajuacj.jcpt.admin.config
 * Date:2019年4月1日下午4:32:36
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.admin.config;

import javax.servlet.DispatcherType;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.prajuacj.jcpt.common.xss.XssFilter;

/**
 * ClassName:FilterConfig <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年4月1日 下午4:32:36 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean shiroFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new DelegatingFilterProxy("shiroFilter"));
		// 该值缺省为false，表示生命周期由SpringApplicationContext管理，设置为true则表示由ServletContainer管理
		registration.addInitParameter("targetFilterLifecycle", "true");
		registration.setEnabled(true);
		registration.setOrder(Integer.MAX_VALUE - 1);
		registration.addUrlPatterns("/*");
		return registration;
	}

	@Bean
	public FilterRegistrationBean xssFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setDispatcherTypes(DispatcherType.REQUEST);
		registration.setFilter(new XssFilter());
		registration.addUrlPatterns("/*");
		registration.setName("xssFilter");
		registration.setOrder(Integer.MAX_VALUE);
		return registration;
	}
}
