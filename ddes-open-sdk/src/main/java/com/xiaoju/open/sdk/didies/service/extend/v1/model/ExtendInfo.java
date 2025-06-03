package com.xiaoju.open.sdk.didies.service.extend.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
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

