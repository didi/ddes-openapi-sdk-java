package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.BudgetCenterListItem;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.ExtendFieldList;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.TravelBudget;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.TravelDetail;
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
public class UpdateApprovalRequest extends BaseReq  {

    /**
     * 滴滴公司 ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 申批单类型，枚举值数字：1:差旅单；2: 行前审批-按次数；3: 行前审批-按日期
     * 
     */
    @JsonProperty("approval_type")
    private Integer approvalType;
    /**
     * 滴滴申请单ID。approval_id与out_approval_id至少需要传一个
     * 
     */
    @JsonProperty("approval_id")
    private String approvalId;
    /**
     * 外部申请单ID，外部申请单ID approval_id优先级大于out_approval_id
     * 
     */
    @JsonProperty("out_approval_id")
    private String outApprovalId;
    /**
     * 申请原因，申请原因，限制 200 字符；默认为空字符 eg: 北京出差，行程维度事由。使用卡片事由时，可以为空
     * 
     */
    @JsonProperty("reason")
    private String reason;
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
     * 差旅预算总额，差旅预算控制，一个申请单对应一个总预算纬度，一次只能全部或者选择部分品类。字段不传输，修改不处理，字段传输，空对象时处理为清空。给值为修改
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
     * 扩展信息，扩展信息，自定义字段；最长不大于 500 字符；(必须为json字符串)；默认为空字符
     * 
     */
    @JsonProperty("extra_info")
    private String extraInfo;
    /**
     * 差旅单行程信息，差旅单行程信息，将travel_detail的值转为 json 字符串，approval_type &#x3D; 1 时必传
     * 
     */
    @JsonProperty("travel_detail")
    private String travelDetail;
    /**
     * 出行人信息，出行人信息，不传时默认出行人为申请人，将passenger_list 转为 json 数组字符串。详见passenger_list
     * 
     */
    @JsonProperty("passenger_list")
    private String passengerList;
    /**
     * 多成本中心
     * 
     */
    @JsonProperty("budget_center_list")
    private String budgetCenterList;
    /**
     * 扩展信息list，自定义字段，最长不大于 500 字符，将extend_field_list转为 json 字符串，三个字段仅作为备注性字段。详见extend_field_list
     * 
     */
    @JsonProperty("extend_field_list")
    private String extendFieldList;
    /**
     * 滴滴侧成本中心ID，滴滴侧成本中心ID；获取方式接口返回的 ID（可为项目/部门ID) eg : 1125920020961744 关联部门 时， id和out_budget_id 优先处理id关联项目时 id和 out_budget_id与 name 组合唯一值时 优先处理id ，out_budget_id与 name 同时有值时按照项目处理，out_budget_id有值且name为空时，按照部门处理
     * 
     */
    @JsonProperty("budget_center_id")
    private String budgetCenterId;
    /**
     * 差旅预算总额,可使用脚本将其转换为json后赋值给 travel_budget 字段
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
     * 扩展信息,可使用脚本将其转换为json后赋值给 extra_info 字段
     * 
     */
    @JsonProperty("extra_info__obj__")
    private Map<String, String> extraInfoObj;
    /**
     * travelDetailObj
     * 
     */
    @JsonProperty("travel_detail__obj__")
    private TravelDetail travelDetailObj;
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
    /**
     * extendFieldListObj
     * 
     */
    @JsonProperty("extend_field_list__obj__")
    private ExtendFieldList extendFieldListObj;
}

