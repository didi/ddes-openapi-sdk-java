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
public class GetNotGenBillDetailOfHotelReply  {

    /**
     * 符合查询条件的总条数
     * 
     */
    @JsonProperty("total")
    private Long total;
    /**
     * 本次查询结果的最后一条记录的order_id
     * 
     */
    @JsonProperty("last_id")
    private String lastId;
    /**
     * 未出账单明细列表
     * 
     */
    @JsonProperty("detail_list")
    private List<NotGenBDOfDomesticHotelItem> detailList;
}

