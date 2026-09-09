package com.xiaoju.open.sdk.didies.service.legalentity.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LegalEntityV2Record  {

    /**
     * 滴滴侧公司主体 id（集团路径返回为字符串）
     *
     */
    @JsonProperty("legal_entity_id")
    private String legalEntityId;
    /**
     * 公司主体名称
     *
     */
    @JsonProperty("name")
    private String name;
    /**
     * 归属企业名称（集团路径返回字段）
     *
     */
    @JsonProperty("belong_enterprise_name")
    private String belongEnterpriseName;
    /**
     * 公司主体外部编号
     *
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 上级公司滴滴侧公司主体 id
     *
     */
    @JsonProperty("parent_id")
    private Long parentId;
    /**
     * 上级公司外部编号
     *
     */
    @JsonProperty("out_parent_id")
    private String outParentId;
    /**
     * 公司主体有效期开始日期
     *
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * 公司主体有效期结束日期
     *
     */
    @JsonProperty("end_time")
    private String endTime;
    /**
     * 纳税人识别号
     *
     */
    @JsonProperty("taxpayer_no")
    private String taxpayerNo;
    /**
     * 开户行名称
     *
     */
    @JsonProperty("open_bank")
    private String openBank;
    /**
     * 开户行账号
     *
     */
    @JsonProperty("bank_card_no")
    private String bankCardNo;
    /**
     * 注册地址
     *
     */
    @JsonProperty("address")
    private String address;
    /**
     * 注册电话
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
