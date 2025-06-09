package com.xiaoju.open.sdk.didies.service.afterapproval.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.afterapproval.v1.model.GetPersonalReceiptOrderRecord;
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
public class GetPersonalReceiptOrderReply  {

    /**
     * 申请应用时分配的AppKey
     * 
     */
    @JsonProperty("total")
    private Integer total;
    /**
     * 审批订单列表
     * 
     */
    @JsonProperty("records")
    private List<GetPersonalReceiptOrderRecord> records;
}

