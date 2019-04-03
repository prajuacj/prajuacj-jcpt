/**
 * Project Name:prajuacj-system
 * File Name:SysDictEntity.java
 * Package Name:com.prajuacj.jcpt.modules.system.entity
 * Date:2019年3月28日下午2:40:39
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * ClassName:SysDictEntity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月28日 下午2:40:39 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@TableName("sys_dict")
public class SysDictEntity implements Serializable {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = -3264859136505798791L;
	@TableId
	private Long id;
	/**
	 * 字典名称
	 */
	@NotBlank(message = "字典名称不能为空")
	private String name;
	/**
	 * 字典类型
	 */
	@NotBlank(message = "字典类型不能为空")
	private String type;
	/**
	 * 字典码
	 */
	@NotBlank(message = "字典码不能为空")
	private String code;
	/**
	 * 字典值
	 */
	@NotBlank(message = "字典值不能为空")
	private String value;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 删除标记 -1：已删除 0：正常
	 */
	@TableLogic
	private Integer delFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
}
