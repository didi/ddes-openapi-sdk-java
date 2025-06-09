package com.xiaoju.open.sdk.didies.core;

import com.xiaoju.open.sdk.didies.core.enums.EncryptTypeEnum;
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum;
import com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum;
import com.xiaoju.open.sdk.didies.core.request.IHttpTransport;
import com.xiaoju.open.sdk.didies.core.request.RestHttpTransport;
import com.xiaoju.open.sdk.didies.core.request.RestTemplates;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.concurrent.TimeUnit;

@Data
@Builder
@EqualsAndHashCode(exclude = {"httpTransport"})
public class Config {

  private String clientId;
  private String clientSecret;
  private String signKey;
  private String baseUrl = "https://api.es.xiaojukeji.com";
  private String grantType = "client_credentials";
  /**
   * 因token失效接口请求重试次数
   */
  private Integer unauthorizedRetryTimes = 2;
  /**
   * 因token失效接口请求重试间隔时间,单位为毫秒
   */
  private Integer unauthorizedRetryInterval = 1000;
  /**
   * 自定义http请求实现
   */
  private IHttpTransport httpTransport;
  /**
   * 连接超时时间
   */
  private Long connectTimeout = 3000L;
  /**
   * 调用超时时间
   */
  private Long callTimeOut = 15000L;
  /**
   * 超时时间单位，默认毫秒
   */
  private TimeUnit timeoutUnit = TimeUnit.MILLISECONDS;
  /**
   * 签名方法;默认MD5
   */
  private SignMethodEnum signMethod = SignMethodEnum.MD5;
  /**
   * 是否开启自动换成token，默认开启
   */
  private Boolean enableHoldToken = true;
  /**
   * 是否开启请求日志打印
   */
  private Boolean enableRequestLog;
  /**
   * 请求日志打印级别
   */
  private LogLevelEnum logLevel;
  /**
   * 是否开启AES加密，默认不开启
   */
  private Boolean enableAES = false;
  /**
   * AES加密key
   */
  private String aesKey;
  /**
   * AES加密长度，默认AES128
   */
  private EncryptTypeEnum encryptType = EncryptTypeEnum.NORMAL;

  public IHttpTransport getHttpTransport() {
    if (httpTransport == null) {
      httpTransport = new RestHttpTransport(RestTemplates.noneUrlEncodeRestTemplate(this));
    }
    return httpTransport;
  }

}
