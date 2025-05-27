package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
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
public class SearchTime  {

    /**
     * 时间类型，枚举值英文code，order_type 为 all 时，该字段可以传all.此时机票，酒店，火车为更新时间，用车为 pay_time,refund_time 支付时间、退款时间、个人支付转个人垫付时间，用于客户每天轮询订单数据落地使用；order_type 不为 all 时生效：机票条件：book_time 预订时间，exchange_time 改签时间 （多张票时，有一张票的改签成功时间满足就返回。），refund_time 退票时间 （多张票时，有一张票的退票成功时间满足就返回。），change_time 更新时间；酒店条件：book_time 预订时间，change_time 更新时间；火车票条件：book_time 预订时间，refund_time 退票时间 (多张票时，有一张票的退票成功时间满足就返回。），change_time 更新时间 ；用车：pay_time 支付时间，refund_time 退款时间
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * 开始时间，格式：yyyy-MM-dd HH:mm:ss 时间范围最大30天 最早时间距今不超过两年时间跨度
     * 
     */
    @JsonProperty("start_time")
    private String startTime;
    /**
     * 结束时间，格式：yyyy-MM-dd HH:mm:ss 可查询的最早时间范围截止为当前时间往前300秒
     * 
     */
    @JsonProperty("end_time")
    private String endTime;
}

