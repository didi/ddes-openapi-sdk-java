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
public class MemberRecord  {

    /**
     * 员工在滴滴企业平台的ID
     * 
     */
    @JsonProperty("id")
    private String id;
    /**
     * 员工手机号
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
     * 员工工号，员工在公司的员工号
     * 
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
    /**
     * 邮箱
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
     * 员工直属上级的手机号码，直属上级可在审批流中担任审批人
     * 
     */
    @JsonProperty("immediate_superior_phone")
    private String immediateSuperiorPhone;
    /**
     * 员工直属上级的员工编号
     * 
     */
    @JsonProperty("immediate_superior_eid")
    private String immediateSuperiorEid;
    /**
     * 常驻地中文
     * 
     */
    @JsonProperty("residentsname")
    private String residentsname;
    /**
     * 是否企业支付余额，枚举值数字 0 否，1 是
     * 
     */
    @JsonProperty("use_company_money")
    private Integer useCompanyMoney;
    /**
     * 每月配额，单位元
     * 
     */
    @JsonProperty("total_quota")
    private String totalQuota;
    /**
     * 叫车时备注信息是否必填，枚举值数字 0 选填，1 必填，2 按制度填写
     * 
     */
    @JsonProperty("is_remark")
    private String isRemark;
    /**
     * 所在部门ID
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 所在兼岗部门ID，员工返回兼岗的部门ID数组
     * 
     */
    @JsonProperty("con_department_ids")
    private List<String> conDepartmentIds;
    /**
     * 所在项目ID
     * 
     */
    @JsonProperty("project_ids")
    private String projectIds;
    /**
     * 用车规则ID数组
     * 
     */
    @JsonProperty("use_car_config")
    private List<String> useCarConfig;
    /**
     * 员工可用限额，单位元 例如\&quot;937.70\&quot;
     * 
     */
    @JsonProperty("available_quota")
    private String availableQuota;
    /**
     * 所在分公司名称（老），后续此参数会去掉
     * 
     */
    @JsonProperty("branch_name")
    private String branchName;
    /**
     * 部门名称（老），后续此参数会去掉
     * 
     */
    @JsonProperty("department")
    private String department;
    /**
     * 用车制度ID数组，跟新增、修改、详情等API统一
     * 
     */
    @JsonProperty("regulation_id")
    private List<String> regulationId;
    /**
     * 设置的员工离职日期，为空时表示未设置离职日期，格式为 yyyy-MM-dd
     * 
     */
    @JsonProperty("set_dismiss_time")
    private String setDismissTime;
    /**
     * 员工实际离职日期，为空时表示未离职,格式为 格式：yyyy-MM-dd HH:mm:ss
     * 
     */
    @JsonProperty("dismiss_time")
    private String dismissTime;
    /**
     * 开票主体信息
     * 
     */
    @JsonProperty("invoice_info")
    private String invoiceInfo;
    /**
     * 所在公司主体id
     * 
     */
    @JsonProperty("legal_entity_id")
    private String legalEntityId;
    /**
     * 外部公司主体编号
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
     * 出生日期，格式2000-01-01（已用AES算法加密）
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
    /**
     * 员工加入滴滴企业平台的渠道，枚举值数字：0;未知 1;PC逐一添加 2;PC批量导入 3;邮件邀请
     * 
     */
    @JsonProperty("source")
    private String source;
}

