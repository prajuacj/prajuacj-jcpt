/**
 * Project Name:prajuacj-common
 * File Name:DataFilter.java
 * Package Name:com.prajuacj.jcpt.common.annotation
 * Date:2019年3月29日下午12:08:52
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
 * ClassName:DataFilter <br/>
 * Function: 数据过滤. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2019年3月29日 下午12:08:52 <br/>
 * @author   prajuacj
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataFilter {
	
    /**  表的别名 */
    String tableAlias() default "";

    /**  true：没有本部门数据权限，也能查询本人数据 */
    boolean user() default true;

    /**  true：拥有子部门数据权限 */
    boolean subDept() default false;

    /**  部门ID */
    String deptId() default "dept_id";

    /**  用户ID */
    String userId() default "user_id";
}

