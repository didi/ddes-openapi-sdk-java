package com.xiaoju.open.sdk.didies.core.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class RawResponse extends Headers {
    /**
    * http 状态码
    */
    private int statusCode;
    private String body;
}
