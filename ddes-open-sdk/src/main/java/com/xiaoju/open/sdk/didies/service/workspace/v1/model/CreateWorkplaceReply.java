package com.xiaoju.open.sdk.didies.service.workspace.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;





@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateWorkplaceReply  {

    /**
     * 职场id
     * 
     */
    @JsonProperty("id")
    private String id;
}

