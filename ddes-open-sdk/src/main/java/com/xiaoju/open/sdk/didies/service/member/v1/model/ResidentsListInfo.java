package com.xiaoju.open.sdk.didies.service.member.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ResidentsListInfo  {

    /**
     * 常驻地ID
     *
     */
    @JsonProperty("id")
    private Long id;
    /**
     * 常驻地名称
     *
     */
    @JsonProperty("name")
    private String name;
    /**
     * 常驻地行政区划代码
     *
     */
    @JsonProperty("adcode")
    private String adcode;
}
