package com.xiaoju.open.sdk.didies.core.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

/**
 * 表单请求
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FormRequest extends Request {
  /**
   * 请求体
   */
  private Map<String, Object> body;
}
