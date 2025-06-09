package com.xiaoju.open.sdk.didies.service.bill.v1.model;

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
public class GetBillDetailOfTrainTicketReply  {

    /**
     * 总条数
     * 
     */
    @JsonProperty("total")
    private Long total;
    /**
     * 最后一页标记字段，是否最后一页 true：是 false：否
     * 
     */
    @JsonProperty("is_last")
    private Boolean isLast;
    /**
     * 本次查询结果的最后一条记录的order_id
     * 
     */
    @JsonProperty("last_id")
    private String lastId;
    /**
     * 账单明细列表()
     * 
     */
    @JsonProperty("orders")
    private List<BillDetailOfTrainTicketItem> orders;
}

