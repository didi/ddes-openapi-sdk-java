package com.xiaoju.open.sdk.didies.service.member.v1.model;

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
public class ListMemberReply  {

    /**
     * 此次查询符合条件的员工总数
     * 
     */
    @JsonProperty("total")
    private Integer total;
    /**
     * 员工集合
     * 
     */
    @JsonProperty("records")
    private List<MemberRecord> records;
}

