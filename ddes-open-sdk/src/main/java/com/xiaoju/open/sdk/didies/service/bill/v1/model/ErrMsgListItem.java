package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ErrMsgListItem  {

    /**
     * 提示信息品类
     * 
     */
    @JsonProperty("sub_business_type")
    private Integer subBusinessType;
    /**
     * 提示信息哪一单提交不通过
     * 
     */
    @JsonProperty("sub_order_id")
    private String subOrderId;
    /**
     * 该单不通过的原因
     * 
     */
    @JsonProperty("adjust_err")
    private String adjustErr;
}

