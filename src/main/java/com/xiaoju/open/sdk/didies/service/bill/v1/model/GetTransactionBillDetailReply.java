package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.TransactionOfWangYCItem;
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
public class GetTransactionBillDetailReply  {

    /**
     * 符合查询条件的总条数
     * 
     */
    @JsonProperty("total")
    private Long total;
    /**
     * 本次查询最后一条数据的偏移量
     * 
     */
    @JsonProperty("last_id")
    private Long lastId;
    /**
     * 交易列表
     * 
     */
    @JsonProperty("transaction_list")
    private List<TransactionOfWangYCItem> transactionList;
}

