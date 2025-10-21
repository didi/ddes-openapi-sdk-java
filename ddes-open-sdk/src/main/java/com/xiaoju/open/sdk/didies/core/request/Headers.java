package com.xiaoju.open.sdk.didies.core.request;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求 headers
 *
 * @author didi
 */
@Data
public class Headers {

  /**
   * 请求 headers
   */
  private Map<String, List<String>> headers = new HashMap<>();

  /**
   * 获取 Content-Type
   *
   * @return Content-Type
   */
  public String getContentType() {
    if (headers.isEmpty()) {
      return null;
    }

    List<String> value = headers.get("Content-Type");
    if (value == null || value.isEmpty()) {
      return null;
    }
    return value.get(0);
  }
}