package com.xiaoju.open.sdk.didies.core.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 原始响应
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RawResponse extends Headers {
  /**
   * http 状态码
   */
  private int statusCode;
  /**
   * 响应体
   */
  private String body;
}
