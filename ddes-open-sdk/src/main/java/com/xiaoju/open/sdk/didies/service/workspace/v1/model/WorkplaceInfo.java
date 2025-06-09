package com.xiaoju.open.sdk.didies.service.workspace.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WorkplaceInfo  {

    /**
     * 滴滴地址ID，客户ID或滴滴地址ID二选一，如果两个都有，则以滴滴ID为准
     * 
     */
    @JsonProperty("id")
    private String id;
    /**
     * 职场所在城市id，职场所在城市id
     * 
     */
    @JsonProperty("city_id")
    private Integer cityId;
    /**
     * 地址所属城市id，客户地址ID，最大64字符
     * 
     */
    @JsonProperty("out_address_id")
    private String outAddressId;
    /**
     * 地址详细名称，地址详细名称，最大100字符
     * 
     */
    @JsonProperty("address")
    private String address;
    /**
     * 经度
     * 
     */
    @JsonProperty("lng")
    private String lng;
    /**
     * 纬度
     * 
     */
    @JsonProperty("lat")
    private String lat;
    /**
     * 是否为职场，是否为职场，1是，0否，默认为否
     * 
     */
    @JsonProperty("is_workplace")
    private Integer isWorkplace;
    /**
     * 用车范围，用车范围 100 到1500 枚举为100的整数倍
     * 
     */
    @JsonProperty("point_range")
    private Integer pointRange;
    /**
     * 备注，备注，最大200字符
     * 
     */
    @JsonProperty("remark")
    private String remark;
}

