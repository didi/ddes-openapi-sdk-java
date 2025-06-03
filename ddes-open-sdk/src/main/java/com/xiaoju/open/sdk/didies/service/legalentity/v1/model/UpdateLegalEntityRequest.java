package com.xiaoju.open.sdk.didies.service.legalentity.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLegalEntityRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 公司主体名称
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 公司主体编号
     * 
     */
    @JsonProperty("legal_entity_id")
    private String legalEntityId;
    /**
     * 外部公司主体编号，不可重复，滴滴后台有效的公司ID不重复
     * 
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 上级公司id，新建公司信息之后，滴滴返回的公司ID
     * 
     */
    @JsonProperty("parent_id")
    private Integer parentId;
    /**
     * 公司主体有效期开始日期，不传 默认为当前日期 格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * 公司主体有效期结束日期，不传默认为长期有效 格式：yyyy-MM-dd HH:mm:ss 需大于当前时间
     * 
     */
    @JsonProperty("end_time")
    private String endTime;
    /**
     * 纳税人识别号，长度为 15/18/20 位
     * 
     */
    @JsonProperty("taxpayer_no")
    private String taxpayerNo;
    /**
     * 公司主体注册地址
     * 
     */
    @JsonProperty("address")
    private String address;
    /**
     * 公司主体注册电话
     * 
     */
    @JsonProperty("telephone")
    private String telephone;
    /**
     * 开户行名称
     * 
     */
    @JsonProperty("open_bank")
    private String openBank;
    /**
     * 开户行账号，纯数字
     * 
     */
    @JsonProperty("bank_card_no")
    private String bankCardNo;
}

