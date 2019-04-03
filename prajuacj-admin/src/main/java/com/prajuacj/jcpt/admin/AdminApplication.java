/**
 * Project Name:prajuacj-admin
 * File Name:AdminApplication.java
 * Package Name:com.prajuacj.jcpt.admin
 * Date:2019年4月1日上午10:47:37
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName:AdminApplication <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年4月1日 上午10:47:37 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@SpringBootApplication
@ComponentScan(basePackages= {"com.prajuacj.jcpt.admin","com.prajuacj.jcpt.modules","com.prajuacj.jcpt.core"})
@MapperScan(basePackages= {"com.prajuacj.jcpt.modules.*.dao"})
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
		System.out.println("(♥◠‿◠)ﾉﾞ  管理后台启动成功   ლ(´ڡ`ლ)ﾞ  \n");
	}
}
