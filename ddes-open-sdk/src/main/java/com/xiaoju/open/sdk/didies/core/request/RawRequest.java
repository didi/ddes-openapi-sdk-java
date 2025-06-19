package com.xiaoju.open.sdk.didies.core.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * 原始请求
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RawRequest extends Request {
  /**
   * 请求体
   */
  private String body;
}
