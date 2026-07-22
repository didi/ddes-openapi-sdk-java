package com.xiaoju.open.sdk.didies.service.budgetcenter.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;




@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBudgetCenterRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 类型，枚举值数字 1 部门 2 项目 使用外部out_budget_id 和name 值更新 type字段必传
     * 
     */
    @JsonProperty("type")
    private Integer type;
    /**
     * 预算周期，枚举值数字 0：不限额；1：自然月 2：自然季度 3：自然年（其中23只对部门生效，需要设置白名单，须联系客户经理）
     * 
     */
    @JsonProperty("budget_cycle")
    private Integer budgetCycle;
    /**
     * 总金额，单位元 0表示不限额度 小数点后保留两位精度
     * 
     */
    @JsonProperty("total_quota")
    private String totalQuota;
    /**
     * 部门/项目 ID，type &#x3D; 1 时， id和out_budget_id 优先处理id type &#x3D; 2时 id和 out_budget_id与 name 组合唯一值时 优先处理id
     * 
     */
    @JsonProperty("id")
    private String id;
    /**
     * 部门/项目名称，不大于 200 字符
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 编号，type &#x3D; 1 时必填；type &#x3D; 2 非必填； 长度限制：≤ 64 字符 更新部门时。字段必填。
     * 
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
    /**
     * 主管ID，人员同步时返回的memberid leader_id和leader_employee_id 时，优先处理leader_id，主管id，多个用英文逗号分开，最多30个
     * 
     */
    @JsonProperty("leader_id")
    private String leaderId;
    /**
     * 主管员工编号，主管工号，json字符串，第一个是主要主管，后续是其他主管，最多30个，leader_id存在时不生效，举例：[111,2222,44444]
     * 
     */
    @JsonProperty("leader_employee_id")
    private String leaderEmployeeId;
    /**
     * 上级部门/项目 ID，新建部门时返回的部门ID，type &#x3D; 1 非必填，不传默认为顶级部门ID，不可以传空字符，type&#x3D;2 默认为，parent_id优先级大于 out_parent_id和 out_parent_name
     * 
     */
    @JsonProperty("parent_id")
    private String parentId;
    /**
     * 上级部门/项目外部CODE，type &#x3D; 1 非必填，不传默认为顶级部门code，不可以传空字符，type&#x3D;2 默认为空，项目需要out_parent_id和out_parent_name一起传递，作为唯一值校验。
     * 
     */
    @JsonProperty("out_parent_id")
    private String outParentId;
    /**
     * 上级部门/项目外部名称，type &#x3D; 1 非必填，不传默认为顶级部门code，type&#x3D;2 默认为空 ，项目需要out_parent_id和out_parent_name一起传递，作为唯一值校验。
     * 
     */
    @JsonProperty("out_parent_name")
    private String outParentName;
    /**
     * 使用范围，枚举值数字 type&#x3D;2时生效，0 ：全员可见，1：项目成员内可见，2：公司主体内可见，不传默认为0 (枚举 2需要设置白名单，须联系客户经理。报错误码10001)
     * 
     */
    @JsonProperty("member_used")
    private Integer memberUsed;
    /**
     * 项目开始日期，默认为空 格式：yyyy-MM-dd type&#x3D;2时生效
     * 
     */
    @JsonProperty("start_date")
    private String startDate;
    /**
     * 项目结束日期，默认为空 格式：yyyy-MM-dd type&#x3D;2时生效
     * 
     */
    @JsonProperty("expiry_date")
    private String expiryDate;
    /**
     * 公司主体ID，多个用英文逗号分开，字段不传不生效，传空字符串清空，传非空字符串更新(更新已有值。后台无值时新建)，如果对应的公司主体id已经停用或者不存在 返回错误码10001 type&#x3D;2时生效
     * 
     */
    @JsonProperty("legal_entity_id")
    private String legalEntityId;
    /**
     * 项目扩展信息的自定义字段，项目扩展信息的自定义字段；最长不大于 500 字符；(必须为json字符串，json解析后不能为空)；仅对项目（type&#x3D;2）生效，部门传了不生效；
     * 
     */
    @JsonProperty("budget_extra_info")
    private String budgetExtraInfo;
    /**
     * 项目拓展字段对象，实际使用的时候会自动转换为json字符串赋值到budget_extra_info
     * 
     */
    @JsonProperty("budget_extra_info__obj__")
    private Map<String, String> budgetExtraInfoObj;
    /**
     * 仅member_used=2时生效，项目所属滴滴侧部门ID，多个逗号分隔，最多300个
     *
     */
    @JsonProperty("department_id")
    private String departmentId;
    /**
     * 仅member_used=2时生效，项目所属部门编码，多个逗号分隔，最多300个
     *
     */
    @JsonProperty("out_department_id")
    private String outDepartmentId;
    /**
     * 仅member_used=2时生效，current_only=仅当前部门(默认)，include_sub=含下级部门
     *
     */
    @JsonProperty("scope")
    private String scope;
    /**
     * 仅type=2时有效，扩展字段JSON数组字符串，需提前在管理后台配置扩展字段
     *
     */
    @JsonProperty("extend_field")
    private String extendField;
    /**
     * 扩展字段对象，实际使用的时候会自动转换为json字符串赋值到extend_field
     *
     */
    @JsonProperty("extend_field__obj__")
    private List<ExtendFieldItem> extendFieldObj;
    /**
     * 仅type=2时有效，POI地点JSON数组字符串，最多20个
     *
     */
    @JsonProperty("poi_list")
    private String poiList;
    /**
     * POI地点对象，实际使用的时候会自动转换为json字符串赋值到poi_list
     *
     */
    @JsonProperty("poi_list__obj__")
    private List<PoiItem> poiListObj;
    /**
     * 仅type=2时有效，外部出行人JSON数组字符串，最多500个
     *
     */
    @JsonProperty("out_travelers")
    private String outTravelers;
    /**
     * out_travelers操作方式：cover=覆盖，append=追加，remove=移除
     *
     */
    @JsonProperty("operate_type")
    private String operateType;
    /**
     * 外部出行人对象，实际使用的时候会自动转换为json字符串赋值到out_travelers
     *
     */
    @JsonProperty("out_travelers__obj__")
    private List<OutTravelerItem> outTravelersObj;
    /**
     * 归属企业名称（集团账户）
     *
     */
    @JsonProperty("belong_enterprise_name")
    private String belongEnterpriseName;
    /**
     * 纳税人识别号（集团账户）
     *
     */
    @JsonProperty("taxpayer_no")
    private String taxpayerNo;
    /**
     * 公司主体编码（集团账户）
     *
     */
    @JsonProperty("out_legal_entity_id")
    private String outLegalEntityId;
}

