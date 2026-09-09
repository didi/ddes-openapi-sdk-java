package com.xiaoju.open.sdk.didies.service.regulation.v1.model;

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
public class CarRule  {

    /**
     * 叫车方式，1-自用、2-代叫
     *
     */
    @JsonProperty("call_type")
    private List<Integer> callType;
    /**
     * 使用场景，1-市内用车、2-接送机、3-接站、4-接送其他
     *
     */
    @JsonProperty("use_scene")
    private List<Integer> useScene;
}
