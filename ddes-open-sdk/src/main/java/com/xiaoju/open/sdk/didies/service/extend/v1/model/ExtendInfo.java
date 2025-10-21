package com.xiaoju.open.sdk.didies.service.extend.v1.model;

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
public class ExtendInfo  {

    /**
     * 子档案唯一标识
     * 
     */
    @JsonProperty("id")
    private String id;
    /**
     * 子档案状态，1正常，停用的还有返回么？
     * 
     */
    @JsonProperty("status")
    private Integer status;
    /**
     * 子档案code
     * 
     */
    @JsonProperty("code")
    private String code;
    /**
     * 子档案名称
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 下一级子档案列表
     * 
     */
    @JsonProperty("children")
    private List<ExtendInfo> children;
}

