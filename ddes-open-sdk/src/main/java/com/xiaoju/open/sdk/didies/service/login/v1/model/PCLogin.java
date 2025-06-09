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
public class PCLogin  {

    /**
     * 跳转页面-默认bill; bill 单据页index 首页;trip 商旅pc首页;tripHotel 商旅pc首页 - 选中酒店tab;tripFlight 商旅pc首页 - 选中机票tab;tripTrain 商旅pc首页 - 选中火车票tab。注意：当没有跳转没有权限时管理后台会跳转404商旅会跳到敬请期待的兜底页面
     * 
     */
    @JsonProperty("jumpPage")
    private String jumpPage;
}

