package com.xiaoju.open.sdk.didies.service.member.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;



@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GetMemberQuotaReply  {

    /**
     * 员工在滴滴企业平台的ID
     * 
     */
    @JsonProperty("member_id")
    private Long memberId;
    /**
     * 限额开始日期，月限额时为自然月开始日 格式为 yyyy-MM-dd
     * 
     */
    @JsonProperty("quota_start_date")
    private String quotaStartDate;
    /**
     * 限额结束日期，月限额时为自然月结束日 格式为 yyyy-MM-dd
     * 
     */
    @JsonProperty("quota_end_date")
    private String quotaEndDate;
    /**
     * 限额类型，枚举值数字 0 不限期 1 自然月
     * 
     */
    @JsonProperty("quota_cycle")
    private Integer quotaCycle;
    /**
     * 总限额，单位：元
     * 
     */
    @JsonProperty("total_quota")
    private BigDecimal totalQuota;
    /**
     * 可用额度，单位：元
     * 
     */
    @JsonProperty("available_quota")
    private BigDecimal availableQuota;
}

