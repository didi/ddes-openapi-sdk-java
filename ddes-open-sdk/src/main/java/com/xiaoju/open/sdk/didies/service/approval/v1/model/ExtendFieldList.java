package com.xiaoju.open.sdk.didies.service.approval.v1.model;

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
public class ExtendFieldList  {

    /**
     * 扩展信息一
     * 
     */
    @JsonProperty("extend_field_01")
    private String extendField01;
    /**
     * 扩展信息二
     * 
     */
    @JsonProperty("extend_field_02")
    private String extendField02;
    /**
     * 扩展信息三
     * 
     */
    @JsonProperty("extend_field_03")
    private String extendField03;
}

