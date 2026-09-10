package com.xiaoju.open.sdk.didies.service.traveler.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TravelerInfo  {

    /**
     * 滴滴侧出行人ID;更新的时候必填
     * 
     */
    @JsonProperty("traveler_id")
    private String travelerId;
    /**
     * 外部出行人 手机号
     * 
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * 外部出行人姓名
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 英文姓
     * 
     */
    @JsonProperty("english_surname")
    private String englishSurname;
    /**
     * 英文名
     * 
     */
    @JsonProperty("english_name")
    private String englishName;
    /**
     * 备注信息
     * 
     */
    @JsonProperty("remark")
    private String remark;
    /**
     * 性别
     * 
     */
    @JsonProperty("sex")
    private Integer sex;
    /**
     * 外部出行人唯一ID
     * 
     */
    @JsonProperty("out_traveler_id")
    private String outTravelerId;
    /**
     * 出生日期
     * 
     */
    @JsonProperty("birth_date")
    private String birthDate;
    /**
     * 身份证件信息
     * 
     */
    @JsonProperty("card_list")
    private List<TravelCardInfo> cardList;
    /**
     * 强制清空字段;目前只支持传 card_list
     * 
     */
    @JsonProperty("force_clear_fields")
    private List<String> forceClearFields;
    /**
     * 外部出行人类型，枚举值数字 0：公司维护（默认），3：项目维度外部出行人（2026.06.23 新增）
     *
     */
    @JsonProperty("type")
    private Integer type;
    /**
     * 归属企业名称，集团账户【上级公司统一对接】场景使用，随 param_json 提交
     *
     */
    @JsonProperty("belong_enterprise_name")
    private String belongEnterpriseName;
    /**
     * 纳税人识别号，集团账户【上级公司统一对接】场景使用，与belong_enterprise_name二选一，随 param_json 提交
     *
     */
    @JsonProperty("taxpayer_no")
    private String taxpayerNo;
}

