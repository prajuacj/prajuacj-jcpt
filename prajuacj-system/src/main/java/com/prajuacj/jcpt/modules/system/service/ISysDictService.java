/**
 * Project Name:prajuacj-system
 * File Name:ISysDictService.java
 * Package Name:com.prajuacj.jcpt.modules.system.service
 * Date:2019年3月29日上午10:41:54
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prajuacj.jcpt.common.utils.PageUtils;
import com.prajuacj.jcpt.modules.system.entity.SysDictEntity;

/**
 * ClassName:ISysDictService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午10:41:54 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
public interface ISysDictService extends IService<SysDictEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
