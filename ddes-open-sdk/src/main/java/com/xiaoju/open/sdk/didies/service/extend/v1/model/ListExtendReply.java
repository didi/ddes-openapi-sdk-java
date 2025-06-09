package com.xiaoju.open.sdk.didies.service.extend.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.extend.v1.model.ExtendInfo;
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
public class ListExtendReply  {

    /**
     * 档案唯一标识
     * 
     */
    @JsonProperty("root_id")
    private String rootId;
    /**
     * 档案code
     * 
     */
    @JsonProperty("root_code")
    private String rootCode;
    /**
     * 档案名称
     * 
     */
    @JsonProperty("root_name")
    private String rootName;
    /**
     * 档案状态，1正常，2停用
     * 
     */
    @JsonProperty("root_status")
    private Integer rootStatus;
    /**
     * 子档案列表
     * 
     */
    @JsonProperty("children")
    private List<ExtendInfo> children;
}

