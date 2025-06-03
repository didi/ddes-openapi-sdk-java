package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdjustBillDataReply  {

    /**
     * 调账id(提交过来的),可用于后续查询
     * 
     */
    @JsonProperty("adjust_req_id")
    private String adjustReqId;
    /**
     * 是否接口请求提交有效, true为有效,false请参考错误信息重新提交
     * 
     */
    @JsonProperty("check_pass")
    private Boolean checkPass;
    /**
     * 状态1.提交成功2.执行中3.执行成功-1.提交失败-2.执行失败
     * 
     */
    @JsonProperty("adjust_status")
    private Integer adjustStatus;
    /**
     * 没通过时,errmsg 简述
     * 
     */
    @JsonProperty("err_msg")
    private String errMsg;
    /**
     * 没通过时,errMsg 详细
     * 
     */
    @JsonProperty("err_msg_list")
    private List<ErrMsgListItem> errMsgList;
    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private Long companyId;
    /**
     * 业务类型
     * 
     */
    @JsonProperty("business_type")
    private Integer businessType;
    /**
     * 调账类型
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
}

