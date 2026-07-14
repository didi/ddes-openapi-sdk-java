package com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ExtendFieldItem  {

    /**
     * 扩展字段ID
     *
     */
    @JsonProperty("id")
    private Long id;
    /**
     * 扩展字段编码
     *
     */
    @JsonProperty("code")
    private String code;
    /**
     * 扩展字段值
     *
     */
    @JsonProperty("value")
    private String value;
}
