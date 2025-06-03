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
public class H5BTrip  {

    /**
     * 差旅、申请用车，必传
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * 订单id
     * 
     */
    @JsonProperty("order_id")
    private String orderId;
    /**
     * 跳转页orderDetail:订单详情页 注：此处的jump_page是小写的， 和网约车页面跳转的jumpPage 的区别；
     * 
     */
    @JsonProperty("jump_page")
    private String jumpPage;
}

