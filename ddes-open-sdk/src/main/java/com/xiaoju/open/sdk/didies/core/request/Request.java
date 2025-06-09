package com.xiaoju.open.sdk.didies.core.request;

import com.xiaoju.open.sdk.didies.core.Config;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Request extends Headers {
  /**
   * 请求地址
   */
  private String url;
  /**
   * query 参数
   */
  private Map<String, Object> params;
  /**
   * 配置
   */
  private Config config;
}
