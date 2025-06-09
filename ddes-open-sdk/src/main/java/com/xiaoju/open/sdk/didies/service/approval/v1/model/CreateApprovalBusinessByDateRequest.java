package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.BudgetCenterListItem;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.BusinessTripDetailByDate;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.ExtendFieldList;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.OutTripInfo;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.TravelBudget;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.TravelManagement;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.TripPassenger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;




@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateApprovalBusinessByDateRequest extends BaseReq  {

    /**
     * 滴滴公司 ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 外部tripid，用于滴滴首页合并卡片展示
     * 
     */
    @JsonProperty("out_trip_id")
    private String outTripId;
    /**
     * 申批单类型，枚举值数字：1:差旅单；2: 行前审批-按次数；3: 行前审批-按日期
     * 
     */
    @JsonProperty("approval_type")
    private Integer approvalType;
    /**
     * (差旅/行前)申请单对应的需审批制度ID regulation_id与policy_type、policy_type_value至少有一组有值
     * 
     */
    @JsonProperty("regulation_id")
    private String regulationId;
    /**
     * 执行政策指定项类型，1：out_rank_id 外部职级编号；2：employee_number 员工工号；3：employee_phone 员工手机号；4：employee_email 员工邮箱；5：regulation_id 制度I，指定生效policy_type_value内对应的值
     * 
     */
    @JsonProperty("policy_type")
    private Integer policyType;
    /**
     * 执行政策指定项
     * 
     */
    @JsonProperty("policy_type_value")
    private String policyTypeValue;
    /**
     * 外部申请单ID，客户侧申请单ID，不大于 120 字符。eg: TA_100002，与返回中的approvalid一一对应
     * 
     */
    @JsonProperty("out_approval_id")
    private String outApprovalId;
    /**
     * 滴滴侧成本中心ID，获取方式接口返回的 ID（可为项目/部门ID)，关联部门 时， id和out_budget_id 优先处理id关联项目时 id和 out_budget_id与 name 组合唯一值时 优先处理id ，out_budget_id与 name 同时有值时按照项目处理，out_budget_id有值且name为空时，按照部门处理。
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 部门/项目名称，不大于 200 字符
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 编号，长度限制：≤ 64 字符
     * 
     */
    @JsonProperty("out_budget_id")
    private String outBudgetId;
    /**
     * 申请原因，申请原因，限制 200 字符；默认为空字符，eg: 北京出差，行程维度事由。使用卡片事由时，可以为空。
     * 
     */
    @JsonProperty("reason")
    private String reason;
    /**
     * 申请人唯一键类型，枚举值数字：0：手机号，phone 必填；1：工号，employee_number 必填；2：邮箱，email 必填；默认为0
     * 
     */
    @JsonProperty("member_type")
    private Integer memberType;
    /**
     * 申请人手机号，申请人手机号；默认为空字符；member_type不传 或者member_type 为0时phone必传
     * 
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * 申请人工号，申请人工号，默认为空字符
     * 
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
    /**
     * 申请人邮箱，申请人邮箱；默认为空字符
     * 
     */
    @JsonProperty("email")
    private String email;
    /**
     * 代订执行制度类型，枚举值数字：0: 执行申请人制度；1: 执行外部出行人不限差标:（需要passenger_list都是外部出行人）；2: 执行出行人制度，作用于预订时生效的差标。；3: 执行多人多差标制度
     * 
     */
    @JsonProperty("executive_regulation_type")
    private Integer executiveRegulationType;
    /**
     * 代订执行人的制度，代订执行人的制度，executive_regulation_type&#x3D;2 时选填，传了就生效，不传：选择 executive_regulation_member 最新绑定的一条制度
     * 
     */
    @JsonProperty("executive_regulation_id")
    private String executiveRegulationId;
    /**
     * 代订执行人标识类型，枚举值数字：0：手机号，executive_regulation_member 为执行人手机号；1：工号，executive_regulation_member 为执行人工号；2：邮箱：executive_regulation_member 为执行人邮箱；默认为0
     * 
     */
    @JsonProperty("executive_regulation_member_type")
    private Integer executiveRegulationMemberType;
    /**
     * 代订执行人(手机号/工号/邮箱)，代订执行人(手机号/工号/邮箱)；默认手机号，注意：执行出行人制度的时候，需要是出行人passenger_list里的员工，executive_regulation_type&#x3D;2时必传， 只能是内部员工
     * 
     */
    @JsonProperty("executive_regulation_member")
    private String executiveRegulationMember;
    /**
     * 外部trip信息，用于滴滴首页合并卡片展示
     * 
     */
    @JsonProperty("out_trip_info")
    private String outTripInfo;
    /**
     * 扩展信息，扩展信息，自定义字段；最长不大于 500 字符；(必须为json字符串)；默认为空字符
     * 
     */
    @JsonProperty("extra_info")
    private String extraInfo;
    /**
     * 扩展信息list，自定义字段，最长不大于 500 字符，将extend_field_list转为 json 字符串，三个字段仅作为备注性字段。详见extend_field_list
     * 
     */
    @JsonProperty("extend_field_list")
    private String extendFieldList;
    /**
     * 行前行程信息, 将 business_trip_detail转为 json 字符串approval_type &#x3D; 2 或 approval_type &#x3D; 3 必填。详见 [business_trip_detail](#business_trip_detail （按次数）
     * 
     */
    @JsonProperty("business_trip_detail")
    private String businessTripDetail;
    /**
     * 差旅预算总额，差旅预算控制，一个申请单对应一个总预算纬度，一次只能全部或者选择部分品类。
     * 
     */
    @JsonProperty("travel_budget")
    private String travelBudget;
    /**
     * 差旅管控，差旅管控，目前仅支持市内用车每日限额设置（为json字符串类型，具体看请求示例）
     * 
     */
    @JsonProperty("travel_management")
    private String travelManagement;
    /**
     * 出行人信息，出行人信息，不传时默认出行人为申请人，将passenger_list 转为 json 数组字符串。详见passenger_list
     * 
     */
    @JsonProperty("passenger_list")
    private String passengerList;
    /**
     * 多成本中心(array)，序号1对应远成本中心字段，依然支持滴滴内部主键ID。使用部门CODE主键，和项目时名称和code作为主键。
     * 
     */
    @JsonProperty("budget_center_list")
    private String budgetCenterList;
    /**
     * outTripInfoObj
     * 
     */
    @JsonProperty("out_trip_info_obj")
    private OutTripInfo outTripInfoObj;
    /**
     * 扩展信息。转成json赋值给extra_info字段
     * 
     */
    @JsonProperty("extra_info__obj__")
    private Map<String, String> extraInfoObj;
    /**
     * extendFieldListObj
     * 
     */
    @JsonProperty("extend_field_list__obj__")
    private ExtendFieldList extendFieldListObj;
    /**
     * businessTripDetailObj
     * 
     */
    @JsonProperty("business_trip_detail__obj__")
    private BusinessTripDetailByDate businessTripDetailObj;
    /**
     * travelBudgetObj
     * 
     */
    @JsonProperty("travel_budget__obj__")
    private TravelBudget travelBudgetObj;
    /**
     * travelManagementObj
     * 
     */
    @JsonProperty("travel_management__obj__")
    private TravelManagement travelManagementObj;
    /**
     * 出行人信息,可使用脚本将其转换为json后赋值给 passenger_list 字段
     * 
     */
    @JsonProperty("passenger_list__obj__")
    private List<TripPassenger> passengerListObj;
    /**
     * 差旅预算总额,可使用脚本将其转换为json后赋值给 budget_center_list 字段
     * 
     */
    @JsonProperty("budget_center_list__obj__")
    private List<BudgetCenterListItem> budgetCenterListObj;
}

