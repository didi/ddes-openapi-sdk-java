package com.xiaoju.open.sdk.didies.service.role.v1.model;

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





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ListRoleReply  {

    /**
     * 角色ID
     * 
     */
    @JsonProperty("id")
    private String id;
    /**
     * 角色中文名称
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 角色英文别名
     * 
     */
    @JsonProperty("alias")
    private String alias;
}

