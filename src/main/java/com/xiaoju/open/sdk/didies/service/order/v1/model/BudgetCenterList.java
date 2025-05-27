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
public class BudgetCenterList  {

    /**
     * 字段员工侧展示名称
     * 
     */
    @JsonProperty("app_name")
    private String appName;
    /**
     * 字段序号 支持从1到9
     * 
     */
    @JsonProperty("sequence")
    private Integer sequence;
    /**
     * 滴滴主键，sequence为1时，生效
     * 
     */
    @JsonProperty("id")
    private String id;
    /**
     * 对应成本中心的值。sequence为1时与name字段一致，sequence为2时，对应extend_field_01，sequence为3时，对应extend_field_02，sequence为4时，对应extend_field_03
     * 
     */
    @JsonProperty("value")
    private String value;
    /**
     * 对应成本中心的编码。sequence为1时与out_budget_id字段一致 sequence为2到9时，CODE无效。
     * 
     */
    @JsonProperty("code")
    private String code;
}

