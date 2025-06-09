package com.xiaoju.open.sdk.didies.service.traveler.v1.model;

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
public class TravelCardInfo  {

    /**
     * 证件类型，枚举值数字 1. 身份证，2. 护照，3. 港澳台居民居住证，4. 台胞证，5. 军官证，6. 回乡证，7. 外国人永久居留身份证
     * 
     */
    @JsonProperty("card_type")
    private Integer cardType;
    /**
     * 证件号码（已用AES算法加密）
     * 
     */
    @JsonProperty("card_no")
    private String cardNo;
    /**
     * 证件过期日期，格式：2050-01-01（已用AES算法加密）
     * 
     */
    @JsonProperty("expire_date")
    private String expireDate;
}

