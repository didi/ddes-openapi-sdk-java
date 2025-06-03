package com.xiaoju.open.sdk.didies.service.login.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class H5BTripOrderDetail  {

    /**
     * 差旅、申请用车，必传
     * 
     */
    @JsonProperty("jump_page")
    private String jumpPage;
    /**
     * 订单id
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
}

