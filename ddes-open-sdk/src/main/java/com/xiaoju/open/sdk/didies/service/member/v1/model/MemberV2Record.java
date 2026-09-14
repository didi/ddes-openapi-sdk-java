package com.xiaoju.open.sdk.didies.service.member.v1.model;

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
public class MemberV2Record  {

    /**
     * 员工在滴滴侧的 ID
     *
     */
    @JsonProperty("id")
    private String id;
    /**
     * 归属企业名称（集团路径返回字段）
     *
     */
    @JsonProperty("belong_enterprise_name")
    private String belongEnterpriseName;
    /**
     * 员工姓名
     *
     */
    @JsonProperty("realname")
    private String realname;
    /**
     * 员工手机号
     *
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * 员工邮箱
     *
     */
    @JsonProperty("email")
    private String email;
    /**
     * 员工工号
     *
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
    /**
     * 昵称
     *
     */
    @JsonProperty("nickname")
    private String nickname;
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
     * 性别，0 未知 1 男 2 女
     *
     */
    @JsonProperty("sex")
    private Integer sex;
    /**
     * 出生日期
     *
     */
    @JsonProperty("birth_date")
    private String birthDate;
    /**
     * 系统角色
     *
     */
    @JsonProperty("system_role")
    private Integer systemRole;
    /**
     * 角色 ID
     *
     */
    @JsonProperty("role_ids")
    private String roleIds;
    /**
     * 员工状态，0 停用，1 启用
     *
     */
    @JsonProperty("status")
    private Integer status;
    /**
     * 来源
     *
     */
    @JsonProperty("source")
    private String source;
    /**
     * 部门名称
     *
     */
    @JsonProperty("department")
    private String department;
    /**
     * 分部名称
     *
     */
    @JsonProperty("branch_name")
    private String branchName;
    /**
     * 兼岗部门 ID 列表
     *
     */
    @JsonProperty("con_department_ids")
    private List<String> conDepartmentIds;
    /**
     * 所在成本中心/项目 ID
     *
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 所在公司主体 id
     *
     */
    @JsonProperty("legal_entity_id")
    private String legalEntityId;
    /**
     * 外部所在公司主体编号
     *
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
    /**
     * 职级 ID
     *
     */
    @JsonProperty("rank_id")
    private String rankId;
    /**
     * 外部职级编号
     *
     */
    @JsonProperty("out_rank_id")
    private String outRankId;
    /**
     * 用车制度 ID 列表（与 v1 MemberRecord 同构；原 String 建模在服务端返回数组时反序列化失败）
     *
     */
    @JsonProperty("regulation_id")
    private List<String> regulationId;
    /**
     * 是否企业支付余额，0 否，1 是
     *
     */
    @JsonProperty("use_company_money")
    private Integer useCompanyMoney;
    /**
     * 总限额
     *
     */
    @JsonProperty("total_quota")
    private String totalQuota;
    /**
     * 可用限额
     *
     */
    @JsonProperty("available_quota")
    private String availableQuota;
    /**
     * 月限额
     *
     */
    @JsonProperty("month_quota")
    private String monthQuota;
    /**
     * 叫车备注是否必填
     *
     */
    @JsonProperty("is_remark")
    private Integer isRemark;
    /**
     * 用车配置
     *
     */
    @JsonProperty("use_car_config")
    private List<String> useCarConfig;
    /**
     * 第三方系统用户 ID（实测字段，文档暂未声明）
     *
     */
    @JsonProperty("third_user_id")
    private String thirdUserId;
    /**
     * 直属上级手机号
     *
     */
    @JsonProperty("immediate_superior_phone")
    private String immediateSuperiorPhone;
    /**
     * 直属上级员工编号
     *
     */
    @JsonProperty("immediate_superior_eid")
    private String immediateSuperiorEid;
    /**
     * 离职时间
     *
     */
    @JsonProperty("dismiss_time")
    private String dismissTime;
    /**
     * 设置的离职时间
     *
     */
    @JsonProperty("set_dismiss_time")
    private String setDismissTime;
    /**
     * 常驻地中文
     *
     */
    @JsonProperty("residentsname")
    private String residentsname;
    /**
     * 常驻地列表
     *
     */
    @JsonProperty("residents_list")
    private List<ResidentsListInfo> residentsList;
    /**
     * 证件信息
     *
     */
    @JsonProperty("card_list")
    private List<CardInfo> cardList;
    /**
     * 证件中文姓名
     *
     */
    @JsonProperty("cert_realname")
    private String certRealname;
    /**
     * 证件英文姓
     *
     */
    @JsonProperty("cert_english_surname")
    private String certEnglishSurname;
    /**
     * 证件英文名
     *
     */
    @JsonProperty("cert_english_name")
    private String certEnglishName;
    /**
     * 乘车人权益（实测字段，文档暂未声明）
     *
     */
    @JsonProperty("guest_car_right")
    private Integer guestCarRight;
    /**
     * 发票信息（实测字段，文档暂未声明）
     *
     */
    @JsonProperty("invoice_info")
    private String invoiceInfo;
    /**
     * 限额规则列表
     *
     */
    @JsonProperty("limit_rule_list")
    private List<LimitRuleInfo> limitRuleList;
}
