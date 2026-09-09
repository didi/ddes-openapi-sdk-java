package com.xiaoju.open.sdk.didies.service.member.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMemberReply  {

    /**
     * 更新结果涉及员工的滴滴侧 ID
     *
     */
    @JsonProperty("member_id")
    private Long memberId;
    /**
     * 员工手机号
     *
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * 员工状态，0 停用，1 启用
     *
     */
    @JsonProperty("status")
    private Integer status;
}
