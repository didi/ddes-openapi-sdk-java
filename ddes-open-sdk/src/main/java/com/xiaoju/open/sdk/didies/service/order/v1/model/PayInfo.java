package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PayInfo  {

    /**
     * 支付方式，枚举值数字：0企业支付，1个人垫付，2混合支付 机票暂不支持混付
     * 
     */
    @JsonProperty("pay_type")
    private Integer payType;
}

