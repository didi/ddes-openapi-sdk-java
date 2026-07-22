package com.xiaoju.open.sdk.didies.service.project.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CardInfo  {

    /**
     * 证件号码
     *
     */
    @JsonProperty("card_no")
    private String cardNo;
    /**
     * 证件类型编码
     *
     */
    @JsonProperty("card_type")
    private Integer cardType;
    /**
     * 证件有效期
     *
     */
    @JsonProperty("expire_date")
    private String expireDate;
}
