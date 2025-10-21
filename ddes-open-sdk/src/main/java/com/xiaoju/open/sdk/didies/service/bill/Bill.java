package com.xiaoju.open.sdk.didies.service.bill;


import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.service.BaseService;
import com.xiaoju.open.sdk.didies.service.bill.v1.V1;

public class Bill extends BaseService {
  /**
   * 令牌持有者
   */
  protected final ITokenHolder tokenHolder;
  /**
   * 配置
   */
  protected final Config config;

  /**
   * V1
   */
  private final V1 v1;

  /**
   * 构造函数
   *
   * @param tokenHolder 令牌持有者
   * @param config      配置
   */
  public Bill(ITokenHolder tokenHolder, Config config) {
      this.tokenHolder = tokenHolder;
      this.config = config;
      this.v1 = new V1(tokenHolder, config);
  }

  /**
   * 获取1.0.0
   *
   * @return 1.0.0
   */
  public V1 v1() {
      return this.v1;
  }
}

