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
public class BudgetCenter  {

    /**
     * 成本中心类型，枚举值数字 ，1：部门；2：项目 type为1时，code有值。为2时code和name成对有值
     * 
     */
    @JsonProperty("type")
    private Integer type;
    /**
     * 成本中心code
     * 
     */
    @JsonProperty("code")
    private String code;
    /**
     * 成本中心名称
     * 
     */
    @JsonProperty("name")
    private String name;
}

