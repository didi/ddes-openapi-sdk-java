package com.xiaoju.open.sdk.didies.service.regulation.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RegulationV2Record  {

    /**
     * 制度 id
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
     * 制度状态（0-停用 1-正常 2-删除 3-过期）
     *
     */
    @JsonProperty("regulation_status")
    private String regulationStatus;
    /**
     * 因公出行场景
     *
     */
    @JsonProperty("scene_type")
    private String sceneType;
    /**
     * 来源（1-通用规则 2-行前审批 3-差旅 4-无需审批）
     *
     */
    @JsonProperty("source")
    private Integer source;
    /**
     * 是否使用个人限额（0-不使用、1-使用）
     *
     */
    @JsonProperty("is_use_quota")
    private Integer isUseQuota;
    /**
     * 制度是否需要审批（0-无需审批，1-行前审批，2-差旅）
     *
     */
    @JsonProperty("is_approve")
    private Integer isApprove;
    /**
     * 管控方式（0-不管控、1-中度管控、2-严格管控、3-交叉预定、4-会议管控）
     *
     */
    @JsonProperty("city_type")
    private Integer cityType;
    /**
     * 审批类型（0-无需审批 1-差旅 2-行前审批按次数 3-行前审批按日期）
     *
     */
    @JsonProperty("approval_type")
    private Integer approvalType;
    /**
     * 制度适用员工姓名（实测返回字段，文档参数表未声明）
     *
     */
    @JsonProperty("regulation_employee_name")
    private String regulationEmployeeName;
    /**
     * 制度适用员工说明（实测返回字段，文档参数表未声明）
     *
     */
    @JsonProperty("regulation_employee_description")
    private String regulationEmployeeDescription;
    /**
     * 归属企业名称（集团路径返回字段）
     *
     */
    @JsonProperty("belong_enterprise_name")
    private String belongEnterpriseName;
}
