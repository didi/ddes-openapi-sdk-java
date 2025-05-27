package com.xiaoju.open.sdk.didies.service.approval.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.approval.v1.model.BusinessCity;
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
public class BusinessTripDetailByDate  {

    /**
     * 开始时间，需要大于等于接口调用当前时间。时间格式为：2015-06-16 12:00:09，必填
     * 
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * 结束时间，需大于等于开始时间。时间格式为：2015-06-16 12:00:09，必填
     * 
     */
    @JsonProperty("end_time")
    private String endTime;
    /**
     * 用车城市列表，创建规则时如果选择了“由员工填写”则必填，制度配置为无需填写城市时，传了城市列表也不生效，示例：[{ \&quot;city_id\&quot;: 1, \&quot;city\&quot;: \&quot;北京\&quot; },{ \&quot;city_id\&quot;: 2, \&quot;city\&quot;: \&quot;上海\&quot; }]
     * 
     */
    @JsonProperty("trips")
    private List<BusinessCity> trips;
    /**
     * 用车金额，单位：【分】（100表示100分，也就是1块钱。大于100生效，小于100为不限，选填
     * 
     */
    @JsonProperty("trip_amount")
    private Integer tripAmount;
    /**
     * 用车次数，非必传只在制度配置为【由员工填写时】生效，不传、传空报错，建议传大于0的整数，若想不限次数可以传负数比如 -1，选填
     * 
     */
    @JsonProperty("trip_times")
    private Integer tripTimes;
    /**
     * 每单限额。单位：【分】（100表示100分，也就是1块钱）。1、es 后台制度配置为【由员工填写】时：该参数必须要传，且参数值要大于0。参数值大于100才生效，参数值小于100时不限制用车金额 （建议研发人员针对员工填写的参数做一下处理，比如说员工填写100元，该参数传10000）；2. es 后台制度配置为【不限】或者【限制 每单企业支付不超过xx元】时，即使接口传了该参数，该参数也不会生效，以后台配置为主，选填
     * 
     */
    @JsonProperty("perorder_money_quota")
    private Integer perorderMoneyQuota;
}

