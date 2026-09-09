package com.xiaoju.open.sdk.didies.service.legalentity.v1.model;

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
public class GetLegalEntityReply  {

    /**
     * 总数据条数
     * 
     */
    @JsonProperty("total")
    private Integer total;
    /**
     * 公司列表
     *
     */
    @JsonProperty("records")
    private List<LegalEntityRecord> records;
    /**
     * 下一页的token，集团账户【上级公司统一对接】场景使用，为空字符串或null说明没有下一页
     *
     */
    @JsonProperty("next_token")
    private String nextToken;
}

