package com.xiaoju.open.sdk.didies.core;

import com.xiaoju.open.sdk.didies.ApiClient;
import com.xiaoju.open.sdk.didies.core.exception.AuthorizeException;
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeApiReply;
import com.xiaoju.open.sdk.didies.service.auth.v1.model.AuthorizeRequest;
import com.xiaoju.open.sdk.didies.utils.StringUtils;
import lombok.RequiredArgsConstructor;

/**
 * 本地token holder
 */
@RequiredArgsConstructor
public class LocalTokenHolder implements ITokenHolder {
  /**
   * 默认token过期时间，单位：秒
   * 1800秒 = 30分钟
   */
  private static final long DEFAULT_EXPIRES_IN = 1800L;
  /**
   * token超时时间，单位：毫秒
   */
  private static final long TOKEN_TIMEOUT = DEFAULT_EXPIRES_IN * 1000;
  /**
   * client
   */
  private final ApiClient client;
  /**
   * accessToken
   */
  private String accessToken;
  /**
   * AccessToken 生成时的时间戳
   */
  private long generateAccessTokenTime;

  /**
   * 设置accessToken结果
   *
   * @param resp resp
   */
  void setAccessTokenResult(AuthorizeApiReply resp) {
    accessToken = resp.getAccessToken();
    generateAccessTokenTime = System.currentTimeMillis() - (DEFAULT_EXPIRES_IN - resp.getExpiresIn()) * 1000L;
  }

  /**
   * 判断是否过期
   */
  @Override
  public boolean isExpired() {
    long now = System.currentTimeMillis();
    return (now - generateAccessTokenTime) > TOKEN_TIMEOUT;
  }

  /**
   * 获取 token
   *
   * @return token
   */
  @Override
  public String getAccessToken() {
    if (StringUtils.isEmpty(accessToken) || isExpired()) {
      try {
        generateAccessToken();
      } catch (Exception e) {
        throw new RuntimeException("获取accessToken失败！", e);
      }
    }
    return accessToken;
  }

  /**
   * 生成accessToken
   *
   * @throws Exception 异常
   */
  private synchronized void generateAccessToken() throws Exception {
    AuthorizeRequest esApiAuthAuthorizeRequest = new AuthorizeRequest();
    Config config = client.getConfig();
    esApiAuthAuthorizeRequest.setClientId(config.getClientId());
    esApiAuthAuthorizeRequest.setClientSecret(config.getClientSecret());
    esApiAuthAuthorizeRequest.setGrantType(config.getGrantType());

    AuthorizeApiReply resp = client.auth().v1().authorize(esApiAuthAuthorizeRequest);
    if (resp == null || org.springframework.util.StringUtils.isEmpty(resp.getAccessToken())) {
      throw new AuthorizeException("生成accessToken失败！");
    }
    setAccessTokenResult(resp);
  }
}

