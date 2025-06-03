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
public class TransferTrainTicketData  {

    /**
     * 票张数
     * 
     */
    @JsonProperty("ticket_num")
    private String ticketNum;
    /**
     * 票价（卧铺场景，使用下铺金额）
     * 
     */
    @JsonProperty("ticket_price")
    private Integer ticketPrice;
    /**
     * 票价
     * 
     */
    @JsonProperty("par_price")
    private Integer parPrice;
    /**
     * 是否支持选座，1：是 0：否
     * 
     */
    @JsonProperty("is_support_choose_seats")
    private String isSupportChooseSeats;
    /**
     * 该席别候补状态，0 表示该席别不支持候补;1 表示该席别可候补;2 表示当前该席别候补人数已达上限，无法候补。
     * 
     */
    @JsonProperty("is_can_HB")
    private String isCanHB;
    /**
     * 坐席名称，与席别码对应
     * 
     */
    @JsonProperty("seat_type_name")
    private String seatTypeName;
    /**
     * 席别码，1:硬座,2:软座,3:硬卧,4:软卧,5:包厢硬卧,6:高级软卧,7:一等软座,8:二等软座,9:商务座,A:高级动卧,B:混编硬座,C:混编硬卧,D:包厢软座,E:特等软座,F:动卧,G:二人软包,H:一人软包,I:一等卧,J:二等卧,K:混编软座,L:混编软卧,M:一等座,O:二等座,P:特等座,Q:多功能座,S:二等包座
     * 
     */
    @JsonProperty("seat_type")
    private String seatType;
    /**
     * 该席别是否是 折扣车票，0 - 否，1 - 是
     * 
     */
    @JsonProperty("discount")
    private String discount;
    /**
     * 具体折扣，9.5表示9.5折，-表示无折扣
     * 
     */
    @JsonProperty("discount_num")
    private String discountNum;
}

