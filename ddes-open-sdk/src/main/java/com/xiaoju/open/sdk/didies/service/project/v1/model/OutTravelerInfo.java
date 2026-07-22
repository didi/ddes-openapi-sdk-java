package com.xiaoju.open.sdk.didies.service.project.v1.model;

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
public class OutTravelerInfo  {

    /**
     * 外部出行人滴滴侧ID
     *
     */
    @JsonProperty("traveler_id")
    private String travelerId;
    /**
     * 外部出行人编码
     *
     */
    @JsonProperty("out_traveler_id")
    private String outTravelerId;
    /**
     * 手机号
     *
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * 姓名
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
     * 性别 0:未知 1:男 2:女
     *
     */
    @JsonProperty("sex")
    private Integer sex;
    /**
     * 出生日期 yyyy-MM-dd
     *
     */
    @JsonProperty("birth_date")
    private String birthDate;
    /**
     * 证件信息列表
     *
     */
    @JsonProperty("card_list")
    private List<CardInfo> cardList;
    /**
     * 关联内部员工列表
     *
     */
    @JsonProperty("related_employees")
    private List<RelatedEmployeeInfo> relatedEmployees;
    /**
     * 所属项目滴滴侧ID
     *
     */
    @JsonProperty("project_id")
    private String projectId;
    /**
     * 所属项目名称
     *
     */
    @JsonProperty("project_name")
    private String projectName;
    /**
     * 所属项目编码
     *
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
}
