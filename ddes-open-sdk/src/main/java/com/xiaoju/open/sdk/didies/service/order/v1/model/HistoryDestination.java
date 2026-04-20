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
public class HistoryDestination  {

    /**
     * 历史目的地详细地址
     * 
     */
    @JsonProperty("address")
    private String address;
    /**
     * 历史目的地经度
     * 
     */
    @JsonProperty("lng")
    private String lng;
    /**
     * 历史目的地纬度
     * 
     */
    @JsonProperty("lat")
    private String lat;
    /**
     * 历史目的地地址名称
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 历史目的地序号，序号从1开始递增，存在多次修改目的地时，1表示最早修改的那次
     * 
     */
    @JsonProperty("sequence")
    private Integer sequence;
}

