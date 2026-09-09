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
public class CreateMemberReply  {

    /**
     * 员工在滴滴侧的 ID
     * 
     */
    @JsonProperty("id")
    private Long id;
    /**
     * 员工手机号
     *
     */
    @JsonProperty("phone")
    private String phone;
    /**
     * 员工已存在场景返回的员工在滴滴侧的 ID
     *
     */
    @JsonProperty("member_id")
    private Long memberId;
    /**
     * 员工已存在场景返回的员工状态，0 停用，1 启用
     *
     */
    @JsonProperty("status")
    private Integer status;
}

