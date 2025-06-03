package com.xiaoju.open.sdk.didies.service.traveler.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.traveler.v1.model.TravelCardInfo;
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
}

