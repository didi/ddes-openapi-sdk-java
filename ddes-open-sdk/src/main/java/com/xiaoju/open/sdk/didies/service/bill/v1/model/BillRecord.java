package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;



@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BillRecord  {

    /**
     * 结算单号
     * 
     */
    @JsonProperty("bill_id")
    private Long billId;
    /**
     * 结算周期
     * 
     */
    @JsonProperty("bill_period")
    private String billPeriod;
    /**
     * 当前状态，枚举值数字：1：待确认；3：已确认
     * 
     */
    @JsonProperty("bill_status")
    private Integer billStatus;
    /**
     * 应结算金额
     * 
     */
    @JsonProperty("bill_amount")
    private BigDecimal billAmount;
    /**
     * 消耗金额
     * 
     */
    @JsonProperty("bill_consumption")
    private BigDecimal billConsumption;
    /**
     * 退款金额
     * 
     */
    @JsonProperty("bill_refund")
    private BigDecimal billRefund;
    /**
     * 差异金额（出租车为调整金额）
     * 
     */
    @JsonProperty("bill_difference")
    private BigDecimal billDifference;
    /**
     * 公司 ID
     * 
     */
    @JsonProperty("companyId")
    private String companyId;
    /**
     * 公司名称
     * 
     */
    @JsonProperty("companyName")
    private String companyName;
    /**
     * 确认日期
     * 
     */
    @JsonProperty("confirm_date")
    private String confirmDate;
    /**
     * 开始时间（商旅适用）
     * 
     */
    @JsonProperty("start_date")
    private String startDate;
    /**
     * 结束时间（商旅适用）
     * 
     */
    @JsonProperty("end_date")
    private String endDate;
    /**
     * 分组类型
     * 
     */
    @JsonProperty("groupType")
    private Integer groupType;
    /**
     * 根结点批次（商旅适用）
     * 
     */
    @JsonProperty("root_batch_id")
    private Long rootBatchId;
    /**
     * 账单状态（商旅适用），0. 生成中 1. 生成成功（待确认） 2.生成失败 3.已确认
     * 
     */
    @JsonProperty("status")
    private Integer status;
}

