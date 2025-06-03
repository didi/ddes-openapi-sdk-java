package com.xiaoju.open.sdk.didies.core.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RawRequest extends Request {
    private String body;
}
