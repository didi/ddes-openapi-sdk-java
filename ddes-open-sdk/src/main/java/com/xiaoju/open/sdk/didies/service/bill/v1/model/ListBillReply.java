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
public class ListBillReply  {

    /**
     * 记录总数
     * 
     */
    @JsonProperty("total")
    private Integer total;
    /**
     * 账单记录列表
     * 
     */
    @JsonProperty("records")
    private List<BillRecord> records;
    /**
     * 本次查询结果的最后一条记录ID
     * 
     */
    @JsonProperty("lastId")
    private Integer lastId;
}

