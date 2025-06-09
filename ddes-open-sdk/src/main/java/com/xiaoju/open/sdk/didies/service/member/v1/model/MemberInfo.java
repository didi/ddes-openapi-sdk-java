package com.xiaoju.open.sdk.didies.service.member.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.member.v1.model.CardInfo;
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
public class MemberInfo  {

    /**
     * 员工信息类型，枚举值数字 0：手机号，1：工号。2：邮箱；默认为0
     * 
     */
    @JsonProperty("member_type")
    private Integer memberType;
    /**
     * 员工手机号，member_type 为0时必传
     * 
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * 员工姓名
     * 
     */
    @JsonProperty("realname")
    private String realname;
    /**
     * 员工工号，member_type 为1时必传 员工在公司的员工号
     * 
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
    /**
     * 邮箱，member_type 为2时必传
     * 
     */
    @JsonProperty("email")
    private String email;
    /**
     * 系统角色，枚举值数字 0 车辆预定人员，1 普通管理员，2 超级管理员
     * 
     */
    @JsonProperty("system_role")
    private Integer systemRole;
    /**
     * 角色，可以通过角色API获取对应的ID
     * 
     */
    @JsonProperty("role_ids")
    private String roleIds;
    /**
     * 员工直属上级的手机号码，直属上级可在审批流中担任审批人 immediate_superior_phone与immediate_superior_eid以手机号优先
     * 
     */
    @JsonProperty("immediate_superior_phone")
    private String immediateSuperiorPhone;
    /**
     * 直属上级邮箱
     * 
     */
    @JsonProperty("immediate_superior_email")
    private String immediateSuperiorEmail;
    /**
     * 员工直属上级的员工编号，直属上级可在审批流中担任审批人
     * 
     */
    @JsonProperty("immediate_superior_employee_number")
    private String immediateSuperiorEmployeeNumber;
    /**
     * 直属上级 ID
     * 
     */
    @JsonProperty("immediate_superior_memberID")
    private Integer immediateSuperiorMemberID;
    /**
     * 清除上级；数字1 清除；【更新参数】
     * 
     */
    @JsonProperty("clear_immediate_superior")
    private Integer clearImmediateSuperior;
    /**
     * 常驻地中文
     * 
     */
    @JsonProperty("residentsname")
    private String residentsname;
    /**
     * 常驻地ID，不传不更新，传“”清空，多个使用“_”连接；
     * 
     */
    @JsonProperty("redisents_ids")
    private String redisentsIds;
    /**
     * 是否企业支付余额，枚举值数字 0 否，1 是
     * 
     */
    @JsonProperty("use_company_money")
    private Integer useCompanyMoney;
    /**
     * 每月配额，单位元 0 不限
     * 
     */
    @JsonProperty("total_quota")
    private String totalQuota;
    /**
     * 叫车时备注信息是否必填，枚举值数字 0 选填，1 必填，2 按制度填写
     * 
     */
    @JsonProperty("is_remark")
    private Integer isRemark;
    /**
     * 所在部门ID，budget_center_id与out_budget_id同时存在时，以budget_center_id为准
     * 
     */
    @JsonProperty("budget_center_id")
    private Long budgetCenterId;
    /**
     * 客户部门CODE
     * 
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
    /**
     * 所在兼岗部门ID，con_department_ids与con_department_codes都存在时，以con_department_ids为准 多个使用“_”连接
     * 
     */
    @JsonProperty("con_department_ids")
    private String conDepartmentIds;
    /**
     * 所在兼岗部门CODE（同部门新增修改的out_budget_id），con_department_ids与con_department_codes都存在时，以con_department_ids为准 多个使用“_”连接
     * 
     */
    @JsonProperty("con_department_codes")
    private String conDepartmentCodes;
    /**
     * 用车制度ID数组，制度ID；通过制度列表接口查询；多个用 _ 连接；默认为空，若该员工的所有制度都是在es后台通过部门/职级/全员方式分配，则员工身上的制度字段不用传；同时注意检查use_company_money字段是否传输，制度和企业支付权限都有才能企业支付
     * 
     */
    @JsonProperty("regulation_id")
    private String regulationId;
    /**
     * 设置的员工离职日期，设置员工离职日期，到期后自动加入已离职名单，不传或为空时认为不设置离职时间，不传不更新；传空更新为空 格式为 yyyy-MM-dd，时间需要传入大于今天，隔天凌晨处理离职时间。
     * 
     */
    @JsonProperty("set_dismiss_time")
    private String setDismissTime;
    /**
     * 所在项目ID，可以填多个，以_分隔。通过成本中心查询api获取id（类型为2）
     * 
     */
    @JsonProperty("project_ids")
    private String projectIds;
    /**
     * 项目信息，人员上绑定的项目信息，将project_codes_detail的值转为 json 字符 \&quot;project_codes_detail\&quot;:\&quot;[{\&quot;project_name\&quot;:\&quot;出差巡视\&quot;,\&quot;project_code\&quot;:\&quot;travelcode\&quot; },{\&quot;project_name\&quot;:\&quot;出差巡视\&quot;,\&quot;project_code\&quot;:\&quot;travelcode\&quot; }] \&quot;，project_ids与project_code_detail同时有值时，以project_ids为准。元素上限100个
     * 
     */
    @JsonProperty("project_codes_detail")
    private String projectCodesDetail;
    /**
     * 所在公司主体id
     * 
     */
    @JsonProperty("legal_entity_id")
    private String legalEntityId;
    /**
     * 外部所在公司主体id
     * 
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 职级id
     * 
     */
    @JsonProperty("rank_id")
    private String rankId;
    /**
     * 外部职级 ID
     * 
     */
    @JsonProperty("out_rank_id")
    private String outRankId;
    /**
     * 英文姓，同lastname
     * 
     */
    @JsonProperty("english_surname")
    private String englishSurname;
    /**
     * 英文名，同firstname 有middlename时 english_name&#x3D;firstname middlename
     * 
     */
    @JsonProperty("english_name")
    private String englishName;
    /**
     * 昵称
     * 
     */
    @JsonProperty("nickname")
    private String nickname;
    /**
     * 性别，枚举值数字 0 未知 1 男 2 女
     * 
     */
    @JsonProperty("sex")
    private Integer sex;
    /**
     * 出生日期，格式2000-01-01，注：1、若采用AES256整体加密，此字段需明文传输，无需单独再加密 2、若不整体加密传输时，此字段只可采用AES128加密传输 3、若采用AES128整体加密，此字段仍需采用AES128单独加密（存在历史客户原因）
     * 
     */
    @JsonProperty("birth_date")
    private String birthDate;
    /**
     * 证件信息
     * 
     */
    @JsonProperty("card_list")
    private List<CardInfo> cardList;
}

