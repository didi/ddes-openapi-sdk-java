package com.xiaoju.open.sdk.didies.service.bill.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.bill.v1.model.BillRecord;
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

