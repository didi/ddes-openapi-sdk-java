package com.xiaoju.open.sdk.didies.service.order.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xiaoju.open.sdk.didies.service.order.v1.model.SelectCondition;
import com.xiaoju.open.sdk.didies.service.order.v1.model.TransferTrainTicketListItem;
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
public class ListTransferTrainTicketReply  {

    /**
     * 车次详细信息
     * 
     */
    @JsonProperty("list")
    private List<TransferTrainTicketListItem> _list;
    /**
     * 是否有下一页，非0则有下一页
     * 
     */
    @JsonProperty("has_more")
    private Integer hasMore;
    /**
     * selectCondition
     * 
     */
    @JsonProperty("select_condition")
    private SelectCondition selectCondition;
    /**
     * 数据请求唯一标识，系统生成
     * 
     */
    @JsonProperty("trace")
    private String trace;
    /**
     * 当前页码，默认：1，必须大于等于1
     * 
     */
    @JsonProperty("cur_page")
    private Integer curPage;
    /**
     * 每页车次条数，默认：10
     * 
     */
    @JsonProperty("page_size")
    private Integer pageSize;
}

