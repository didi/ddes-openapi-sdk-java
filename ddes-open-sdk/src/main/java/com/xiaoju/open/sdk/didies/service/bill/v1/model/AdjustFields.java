package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AdjustFields  {

    /**
     * 部门名称相关（对于用车是下单人部门名称，对于商旅是预订人部门名称）
     * 
     */
    @JsonProperty("bookingDepName")
    private String bookingDepName;
    /**
     * 部门代码相关（对于用车是下单人部门代码，对于商旅是预订人部门代码）
     * 
     */
    @JsonProperty("bookingDepCode")
    private String bookingDepCode;
    /**
     * 成本中心名称
     * 
     */
    @JsonProperty("budgetCenterName")
    private String budgetCenterName;
    /**
     * 成本中心代码
     * 
     */
    @JsonProperty("budgetCenterCode")
    private String budgetCenterCode;
    /**
     * 所属公司名称相关（对于用车是下单人所属公司名称，对于商旅是预订人所属公司名称）
     * 
     */
    @JsonProperty("legalEntityName")
    private String legalEntityName;
    /**
     * 所属公司代码相关（对于用车是下单人所属公司代码，对于商旅是预订人所属公司代码）
     * 
     */
    @JsonProperty("legalEntityCode")
    private String legalEntityCode;
    /**
     * 项目自定义信息
     * 
     */
    @JsonProperty("projectExtInfo")
    private String projectExtInfo;
    /**
     * 自定义扩展信息 01
     * 
     */
    @JsonProperty("exInfo01")
    private String exInfo01;
    /**
     * 自定义扩展信息 02
     * 
     */
    @JsonProperty("exInfo02")
    private String exInfo02;
    /**
     * 自定义扩展信息 03
     * 
     */
    @JsonProperty("exInfo03")
    private String exInfo03;
    /**
     * 自定义扩展信息 04
     * 
     */
    @JsonProperty("exInfo04")
    private String exInfo04;
    /**
     * 自定义扩展信息 05
     * 
     */
    @JsonProperty("exInfo05")
    private String exInfo05;
    /**
     * 自定义扩展信息 06
     * 
     */
    @JsonProperty("exInfo06")
    private String exInfo06;
    /**
     * 自定义扩展信息 07
     * 
     */
    @JsonProperty("exInfo07")
    private String exInfo07;
    /**
     * 自定义扩展信息 08
     * 
     */
    @JsonProperty("exInfo08")
    private String exInfo08;
    /**
     * 下单人部门 不直接传递,请bookingDepName+bookingDepCode匹配;name支持传递或&gt;进行路径连接,code请直接传递;会尝试 或者+并且+有效 进行逻辑得到唯一匹配项,若不是则报错
     * 
     */
    @JsonProperty("bookingDepId")
    private String bookingDepId;
    /**
     * 成本中心名称 不直接传递,用名称+code匹配,逻辑同bookingDepId
     * 
     */
    @JsonProperty("budgetCenterId")
    private String budgetCenterId;
    /**
     * 下单人所属公司 不直接传递,用名称+code匹配,逻辑同bookingDepId
     * 
     */
    @JsonProperty("legalEntityId")
    private String legalEntityId;
    /**
     * 自定义(开票主体等信息)
     * 
     */
    @JsonProperty("extendInfo")
    private String extendInfo;
    /**
     * 审批自定义
     * 
     */
    @JsonProperty("approvalInfo")
    private String approvalInfo;
    /**
     * 用车制度 会check是否存在
     * 
     */
    @JsonProperty("institutionName")
    private String institutionName;
    /**
     * 用车权限 会check是否存在
     * 
     */
    @JsonProperty("ruleName")
    private String ruleName;
    /**
     * 入住人部门 不直接传递,用名称+code匹配,逻辑同网约车bookingDepId
     * 
     */
    @JsonProperty("passengerDepId")
    private String passengerDepId;
    /**
     * 入住人所属公司名称 不直接传递,用名称+code匹配,逻辑同网约车bookingDepId
     * 
     */
    @JsonProperty("passengerLegalEntityId")
    private String passengerLegalEntityId;
    /**
     * 审批自定义
     * 
     */
    @JsonProperty("extraInfo")
    private String extraInfo;
    /**
     * 入住人所属公司代码 [商旅字段]
     * 
     */
    @JsonProperty("passengerLegalEntityCode")
    private String passengerLegalEntityCode;
    /**
     * 入住人部门名称 [商旅字段]
     * 
     */
    @JsonProperty("passengerDepName")
    private String passengerDepName;
    /**
     * 入住人部门代码 [商旅字段]
     * 
     */
    @JsonProperty("passengerDepCode")
    private String passengerDepCode;
    /**
     * 入住人所属公司名称 [商旅字段]
     * 
     */
    @JsonProperty("passengerLegalEntityName")
    private String passengerLegalEntityName;
}

