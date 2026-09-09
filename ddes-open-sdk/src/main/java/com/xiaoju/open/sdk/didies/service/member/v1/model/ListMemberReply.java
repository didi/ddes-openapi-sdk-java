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
    /**
     * 游标分页标志位，仅当请求传了last_id时返回
     *
     */
    @JsonProperty("last_id")
    private String lastId;
    /**
     * 下一页的token，集团账户【上级公司统一对接】场景使用，为空字符串或null说明没有下一页
     *
     */
    @JsonProperty("next_token")
    private String nextToken;
}

