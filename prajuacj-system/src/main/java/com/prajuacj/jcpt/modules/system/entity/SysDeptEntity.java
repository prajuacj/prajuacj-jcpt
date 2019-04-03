/**
 * Project Name:prajuacj-system
 * File Name:SysDeptEntity.java
 * Package Name:com.prajuacj.jcpt.modules.system.entity
 * Date:2019年3月28日下午2:37:02
 * Copyright (c) 2019, prajuacj@163.com All Rights Reserved.
 *
*/

package com.prajuacj.jcpt.modules.system.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * ClassName:SysDeptEntity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月28日 下午2:37:02 <br/>
 * 
 * @author prajuacj
 * @version
 * @since JDK 1.8
 * @see
 */
@TableName("sys_dept")
public class SysDeptEntity implements Serializable {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = 8518833029651842659L;
	/**
	 * 部门ID
	 */
	@TableId
	private Long deptId;
	/**
	 * 上级部门ID，一级部门为0
	 */
	private Long parentId;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 上级部门名称
	 */
	@TableField(exist = false)
	private String parentName;
	private Integer orderNum;
	@TableLogic
	private Integer delFlag;
	/**
	 * ztree属性
	 */
	@TableField(exist = false)
	private Boolean open;
	@TableField(exist = false)
	private List<?> list;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
}
