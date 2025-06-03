package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;




@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdjustBillDataRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 自行传递的调整id,后面用于查询(成功的提交id不能重复)
     * 
     */
    @JsonProperty("adjust_req_id")
    private String adjustReqId;
    /**
     * 业务线（1：网约车；2：商旅, 40：代驾 100：出租车）
     * 
     */
    @JsonProperty("business_type")
    private Integer businessType;
    /**
     * 调整类型1:订单计入下期2:订单信息调整
     * 
     */
    @JsonProperty("adjust_type")
    private Integer adjustType;
    /**
     * 账单ID
     * 
     */
    @JsonProperty("bill_id")
    private Long billId;
    /**
     * adjust_list，要求长度大于0
     * 
     */
    @JsonProperty("adjust_list")
    private List<AdjustListItem> adjustList;
    /**
     * 备注
     * 
     */
    @JsonProperty("remark")
    private String remark;
}

