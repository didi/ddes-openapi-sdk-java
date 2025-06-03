package com.xiaoju.open.sdk.didies.service.legalentity.v1.model;

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
public class LegalEntityRecord  {

    /**
     * 公司主体注册地址
     * 
     */
    @JsonProperty("address")
    private String address;
    /**
     * 开户行账号
     * 
     */
    @JsonProperty("bank_card_no")
    private String bankCardNo;
    /**
     * 公司主体有效期截止日期
     * 
     */
    @JsonProperty("end_time")
    private String endTime;
    /**
     * 公司主体 id
     * 
     */
    @JsonProperty("legal_entity_id")
    private Long legalEntityId;
    /**
     * 公司主体名称
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 开户行名称
     * 
     */
    @JsonProperty("open_bank")
    private String openBank;
    /**
     * 外部主体编号
     * 
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 上级公司 id
     * 
     */
    @JsonProperty("parent_id")
    private Long parentId;
    /**
     * 公司主体有效期开始日期
     * 
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * 纳税人识别号
     * 
     */
    @JsonProperty("taxpayer_no")
    private String taxpayerNo;
    /**
     * 公司主体注册电话
     * 
     */
    @JsonProperty("telephone")
    private String telephone;
    /**
     * 公司状态，0 停用，1 启用
     * 
     */
    @JsonProperty("status")
    private Integer status;
}

