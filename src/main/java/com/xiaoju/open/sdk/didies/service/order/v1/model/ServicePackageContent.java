package com.xiaoju.open.sdk.didies.service.order.v1.model;

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
public class ServicePackageContent  {

    /**
     * 服务包内容名称
     * 
     */
    @JsonProperty("name")
    private Integer name;
    /**
     * 内容对应数量
     * 
     */
    @JsonProperty("num")
    private Integer num;
    /**
     * 服务包描述
     * 
     */
    @JsonProperty("desc")
    private String desc;
    /**
     * 机票唯一标记
     * 
     */
    @JsonProperty("ticket_unique_key")
    private Integer ticketUniqueKey;
}

