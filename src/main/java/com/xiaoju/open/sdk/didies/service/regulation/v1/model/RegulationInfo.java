package com.xiaoju.open.sdk.didies.service.regulation.v1.model;

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
public class RegulationInfo  {

    /**
     * 制度id
     * 
     */
    @JsonProperty("regulation_id")
    private String regulationId;
    /**
     * 制度名称
     * 
     */
    @JsonProperty("regulation_name")
    private String regulationName;
    /**
     * 制度状态，（0-停用 1-正常 2-删除 3-过期）
     * 
     */
    @JsonProperty("regulation_status")
    private String regulationStatus;
    /**
     * 来源，来源（1-通用规则 2-行前审批 3-差旅 4-无需审批）
     * 
     */
    @JsonProperty("source")
    private Integer source;
    /**
     * 因公出行场景，（0-个人用车、1-商务出行、2-需审批差旅制度、3-加班、4-办公地点通勤、5-疫期通勤、11-会议用车、91-代叫车、92-接送机、93-包车、94-代驾、95-私车同行、96-行前审批、104-无需审批差旅制度）
     * 
     */
    @JsonProperty("scene_type")
    private String sceneType;
    /**
     * 是否使用个人限额，（0-不使用、1-使用），差旅制度默认返回不使用
     * 
     */
    @JsonProperty("is_use_quota")
    private Integer isUseQuota;
    /**
     * 制度是否需要审批，(0-无需审批，1-行前审批，2-差旅)
     * 
     */
    @JsonProperty("is_approve")
    private Integer isApprove;
    /**
     * 制度模板ID
     * 
     */
    @JsonProperty("institution_id")
    private String institutionId;
    /**
     * 管控方式（0-不管控、1-中度管控、2-严格管控、3-交叉预定（轻度管控）、4-会议管控）。默认值-1无意义
     * 
     */
    @JsonProperty("city_type")
    private Integer cityType;
    /**
     * 审批类型，(0-无需审批 1-差旅 2-行前审批按次数 3-行前审批按日期)
     * 
     */
    @JsonProperty("approval_type")
    private Integer approvalType;
}

