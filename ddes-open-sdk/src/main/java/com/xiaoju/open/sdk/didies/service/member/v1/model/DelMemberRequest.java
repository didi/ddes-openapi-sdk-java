package com.xiaoju.open.sdk.didies.service.member.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaoju.open.sdk.didies.core.model.BaseReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;




@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DelMemberRequest extends BaseReq  {

    /**
     * 企业ID
     * 
     */
    @JsonProperty("company_id")
    private String companyId;
    /**
     * 员工在滴滴企业的ID，员工在滴滴企业的ID（同员工新增接口中返回的id；删除多个员工时，员工号需要以\&quot;_\&quot;隔开，一次最多删除100条）member_id与employee_number同时存在以member_id为准
     * 
     */
    @JsonProperty("member_id")
    private String memberId;
    /**
     * 员工在滴滴企业的工号，json 字符串（一次最多删除100条），member_id和employee_number仅有一个生效，不能同时为空，member_id 优先级高于employee_number, 示例： [\&quot;D1001\&quot;, \&quot;D1002\&quot;, \&quot;D1003\&quot;]
     * 
     */
    @JsonProperty("employee_number")
    private String employeeNumber;
    /**
     * 员工手机号列表，json 字符串（一次最多删除100条），集团账户【上级公司统一对接】及批量删除场景使用
     *
     */
    @JsonProperty("employee_phone")
    private String employeePhone;
    /**
     * employeePhoneObj，SDK 便捷字段，自动序列化为 employee_phone json 字符串
     *
     */
    @JsonProperty("employee_phone__obj__")
    private List<String> employeePhoneObj;
    /**
     * 员工邮箱列表，json 字符串（一次最多删除100条），集团账户【上级公司统一对接】及批量删除场景使用
     *
     */
    @JsonProperty("employee_email")
    private String employeeEmail;
    /**
     * employeeEmailObj，SDK 便捷字段，自动序列化为 employee_email json 字符串
     *
     */
    @JsonProperty("employee_email__obj__")
    private List<String> employeeEmailObj;
    /**
     * 归属企业名称，集团账户【上级公司统一对接】场景使用
     *
     */
    @JsonProperty("belong_enterprise_name")
    private String belongEnterpriseName;
    /**
     * 纳税人识别号，集团账户【上级公司统一对接】场景使用，与belong_enterprise_name二选一
     *
     */
    @JsonProperty("taxpayer_no")
    private String taxpayerNo;
}

