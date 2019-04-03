/**
 * Project Name:prajuacj-common
 * File Name:Group.java
 * Package Name:com.prajuacj.jcpt.common.validator.group
 * Date:2019年3月28日下午4:02:30
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.common.validator.group;

import javax.validation.GroupSequence;

/**
 * ClassName:Group <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月28日 下午4:02:30 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@GroupSequence({ AddGroup.class, UpdateGroup.class })
public interface Group {

}
