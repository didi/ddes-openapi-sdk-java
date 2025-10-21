package com.xiaoju.open.sdk.didies.core;


/**
 * 常量信息
 */
public abstract class Constants {
  /**
   * 版本号
   */
  public final static String VERSION = "1.0.0";
  /**
   * USER_AGENT 请求头
   */
  public final static String USER_AGENT = "User-Agent";
  /**
   * 请求头参数
   */
  public final static String DIDI_AGENT = "didies-open-sdk-java/" + VERSION;
  /**
   * token 失效异常码
   */
  public final static Integer INVALID_ACCESS_TOKEN_CODE = 401;
  /**
   * 认证地址
   */
  public final static String AUTH_URI = "/river/Auth/authorize";
  /**
   * json 对象后缀；用于 api 文档中 string 类型的 json 对象，在生成的代码中，需要使用该后缀来标识
   */
  public final static String OBJECT_SUFFIX = "__obj__";
  /**
   * 基础请求参数名
   */
  public final static BaseReqName BASE_REQ_NAMES = new BaseReqName();

  /**
   * 基础请求参数名
   */
  public static class BaseReqName {
    /**
     * access_token
     */
    public final String ACCESS_TOKEN = "access_token";
    /**
     * client_id
     */
    public final String CLIENT_ID = "client_id";
    /**
     * timestamp
     */
    public final String TIMESTAMP = "timestamp";
    /**
     * sign
     */
    public final String SIGN = "sign";
    /**
     * encrypt_content
     */
    public final String ENCRYPT_CONTENT = "encrypt_content";
    /**
     * ent
     */
    public final String ENT = "ent";
  }
}
