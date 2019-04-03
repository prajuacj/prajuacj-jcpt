/**
 * Project Name:prajuacj-common
 * File Name:SysLog.java
 * Package Name:com.prajuacj.jcpt.common.annotation
 * Date:2019年3月29日下午12:10:31
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:SysLog <br/>
 * Function: 系统日志注解. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年3月29日 下午12:10:31 <br/>
 * @author   prajuacj
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	String value() default "";
}

