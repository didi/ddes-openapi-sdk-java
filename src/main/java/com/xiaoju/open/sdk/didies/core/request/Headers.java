package com.xiaoju.open.sdk.didies.core.request;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Headers {

  private Map<String, List<String>> headers = new HashMap<>();

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