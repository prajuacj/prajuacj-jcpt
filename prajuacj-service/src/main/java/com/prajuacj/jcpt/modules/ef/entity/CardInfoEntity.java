package com.prajuacj.jcpt.modules.ef.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 
 * 
 * @author prajuacj
 * @email prajuacj@163.com
 * @date 2019-04-03 16:55:50
 */
@TableName("ef_card_info")
public class CardInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 卡编号
	 */
	private String cardNo;
	/**
	 * 卡槽地址编号
	 */
	private String slotNo;
	/**
	 * 初始流量（M）
	 */
	private Integer initFlow;
	/**
	 * 剩余流量
	 */
	private Integer residualFlow;
	/**
	 * 运营商ID
	 */
	private Integer operatorId;
	/**
	 * card状态（0：有空且正常；1：正常使用；2：异常；3：已经用完）
	 */
	private Integer cardStatus;
	/**
	 * iccid号
	 */
	private String iccid;
	/**
	 * 创建者
	 */
	private String createBy;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 更新者
	 */
	private String updateBy;
	/**
	 * 
	 */
	private Date updateTime;
	/**
	 * 备注
	 */
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}

	public Integer getInitFlow() {
		return initFlow;
	}

	public void setInitFlow(Integer initFlow) {
		this.initFlow = initFlow;
	}

	public Integer getResidualFlow() {
		return residualFlow;
	}

	public void setResidualFlow(Integer residualFlow) {
		this.residualFlow = residualFlow;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public Integer getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(Integer cardStatus) {
		this.cardStatus = cardStatus;
	}

	public String getIccid() {
		return iccid;
	}

	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}