package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.Approval;
import com.xiaoju.open.sdk.didies.service.order.v1.model.Booker;
import com.xiaoju.open.sdk.didies.service.order.v1.model.BudgetCenter;
import com.xiaoju.open.sdk.didies.service.order.v1.model.InvoiceInfo;
import com.xiaoju.open.sdk.didies.service.order.v1.model.Passenger;
import com.xiaoju.open.sdk.didies.service.order.v1.model.PayInfo;
import com.xiaoju.open.sdk.didies.service.order.v1.model.SearchTime;
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
public class ParamJsonObj  {

    /**
     * 订单类型，枚举值英文code：all 所有类别，domesticflight 国内机票，internationalflight 国际机票，domestichotel 国内酒店，internationalhotel 国际酒店，train 火车票，car 用车
     * 
     */
    @JsonProperty("order_type")
    private String orderType;
    /**
     * searchTime
     * 
     */
    @JsonProperty("search_time")
    private SearchTime searchTime;
    /**
     * approval
     * 
     */
    @JsonProperty("approval")
    private Approval approval;
    /**
     * booker
     * 
     */
    @JsonProperty("booker")
    private Booker booker;
    /**
     * passenger
     * 
     */
    @JsonProperty("passenger")
    private Passenger passenger;
    /**
     * budgetCenter
     * 
     */
    @JsonProperty("budget_center")
    private BudgetCenter budgetCenter;
    /**
     * payInfo
     * 
     */
    @JsonProperty("pay_info")
    private PayInfo payInfo;
    /**
     * invoiceInfo
     * 
     */
    @JsonProperty("invoice_info")
    private InvoiceInfo invoiceInfo;
    /**
     * 当前页，当前页，从1开始
     * 
     */
    @JsonProperty("cur_page")
    private Integer curPage;
    /**
     * 每页条数，每页查询多少条(限制100)，可支持的分页最大返回10000条，超过部分不返回。单次超过查询范围，请减少查询时间范围。最多单次单品类返回10000条
     * 
     */
    @JsonProperty("limit")
    private Integer limit;
}

