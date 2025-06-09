package com.xiaoju.open.sdk.didies.core;


public abstract class Constants {
  public final static String VERSION = "1.0.0";

  public final static String USER_AGENT = "User-Agent";

  public final static String DIDI_AGENT = "didies-open-sdk-java/" + VERSION;

  public final static Integer INVALID_ACCESS_TOKEN_CODE = 401;

  public final static String AUTH_URI = "/river/Auth/authorize";

  public final static String OBJECT_SUFFIX = "__obj__";

  public final static BaseReqName BASE_REQ_NAMES = new BaseReqName();

  public static class BaseReqName {
    public final String ACCESS_TOKEN = "access_token";
    public final String CLIENT_ID = "client_id";
    public final String TIMESTAMP = "timestamp";
    public final String SIGN = "sign";
    public final String ENCRYPT_CONTENT = "encrypt_content";
    public final String ENT = "ent";
  }
}
