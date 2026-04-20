package com.xiaoju.open.sdk.didies.service.order.v1.model;

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
public class CostShare  {

    /**
     * 分配比例
     * 
     */
    @JsonProperty("share_ratio")
    private BigDecimal shareRatio;
    /**
     * 公司承担比例
     * 
     */
    @JsonProperty("share_company_ratio")
    private BigDecimal shareCompanyRatio;
    /**
     * 个人承担比例
     * 
     */
    @JsonProperty("share_personal_ratio")
    private BigDecimal sharePersonalRatio;
    /**
     * 企业应付总额
     * 
     */
    @JsonProperty("company_pay")
    private String companyPay;
    /**
     * 个人应付总额
     * 
     */
    @JsonProperty("personal_pay")
    private String personalPay;
    /**
     * 公司实付金额
     * 
     */
    @JsonProperty("company_real_pay")
    private String companyRealPay;
    /**
     * 个人实付金额
     * 
     */
    @JsonProperty("personal_real_pay")
    private String personalRealPay;
    /**
     * 公司实际退款金额
     * 
     */
    @JsonProperty("company_real_refund")
    private String companyRealRefund;
    /**
     * 个人实际退款金额
     * 
     */
    @JsonProperty("personal_real_refund")
    private String personalRealRefund;
}

