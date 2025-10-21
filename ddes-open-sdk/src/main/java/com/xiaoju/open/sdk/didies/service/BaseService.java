package com.xiaoju.open.sdk.didies.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.Constants;
import com.xiaoju.open.sdk.didies.core.ITokenHolder;
import com.xiaoju.open.sdk.didies.core.enums.EncryptTypeEnum;
import com.xiaoju.open.sdk.didies.core.exception.AccessTokenNotGivenException;
import com.xiaoju.open.sdk.didies.core.exception.SystemException;
import com.xiaoju.open.sdk.didies.core.model.BaseResp;
import com.xiaoju.open.sdk.didies.core.request.IHttpTransport;
import com.xiaoju.open.sdk.didies.core.request.RawRequest;
import com.xiaoju.open.sdk.didies.core.request.RawResponse;
import com.xiaoju.open.sdk.didies.utils.*;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

/**
 * 基础服务类
 */
public abstract class BaseService {

  /**
   * 令牌
   */
  protected ITokenHolder tokenHolder;

  /**
   * 配置
   */
  protected Config config;

  /**
   * 发送post请求
   *
   * @param req        请求参数
   * @param apiPath    请求路径
   * @param clazz      响应的类型
   * @param retryTimes 重试次数
   * @param <R>        响应结果泛型参数
   * @param <P>        请求参数泛型参数
   * @return 请求结果
   */
  protected <P, R extends BaseResp> R doPost(P req, String apiPath, Class<R> clazz, Integer retryTimes) {
    boolean isAuth = Constants.AUTH_URI.equals(apiPath);
    IHttpTransport httpTransport = config.getHttpTransport();
    String url = config.getBaseUrl() + apiPath;
    RawRequest request = new RawRequest();
    request.setConfig(config);
    request.setUrl(url);

    Map<String, Object> requestBody = buildReqWithSign(req, false, isAuth);
    boolean enableAES = Boolean.TRUE.equals(config.getEnableAES()) && !EncryptTypeEnum.NORMAL.equals(config.getEncryptType()) && !isAuth;
    if (enableAES) {
      Map<String, Object> aesBody = buildAesRequestParam(requestBody);
      request.setBody(JacksonUtils.toJson(aesBody));
    } else {
      request.setBody(JacksonUtils.toJson(requestBody));
    }
    setAgentHeader(request);
    RawResponse response = httpTransport.post(request);
    R result = buildResult(response, clazz);
    if (isTokenInvalid(result)) {
      return doPost(req, apiPath, clazz, getRetryTimes(retryTimes));
    }
    return result;
  }

  /**
   * 发送get请求
   *
   * @param req        请求参数
   * @param apiPath    请求路径
   * @param clazz      响应对象的类型
   * @param retryTimes 重试次数
   * @param <R>        响应结果的泛型参数
   * @param <P>        请求参数泛型参数
   * @return 请求结果
   */
  protected <P, R extends BaseResp> R doGet(P req, String apiPath, Class<R> clazz, Integer retryTimes) {
    IHttpTransport httpTransport = config.getHttpTransport();
    String url = config.getBaseUrl() + apiPath;
    RawRequest request = new RawRequest();
    request.setConfig(config);
    request.setUrl(url);
    Map<String, Object> requestParam = buildReqWithSign(req, true, false);
    if (Boolean.TRUE.equals(config.getEnableAES()) && !EncryptTypeEnum.NORMAL.equals(config.getEncryptType())) {
      Map<String, Object> aesBody = buildAesRequestParam(requestParam);
      request.setParams(urlEncoderParam(aesBody));
    } else {
      request.setParams(requestParam);
    }
    setAgentHeader(request);
    RawResponse response = httpTransport.get(request);
    R result = buildResult(response, clazz);
    if (isTokenInvalid(result)) {
      return doGet(req, apiPath, clazz, getRetryTimes(retryTimes));
    }
    return result;
  }

  /*================================================  private utils ================================================*/

  /**
   * 构建请求参数
   *
   * @param response 响应对象
   * @param clazz    响应对象的类型
   * @param <T>      响应结果的泛型参数
   * @return 响应结果
   */
  private <T extends BaseResp> T buildResult(RawResponse response, Class<T> clazz) {
    String result = null;
    if (response.getBody() != null) {
      result = response.getBody();
    }
    if (result != null) {
      T responseBody = JacksonUtils.toObj(result, clazz);
      if (responseBody.getEncryptData() != null && !StringUtils.isEmpty(responseBody.getEncryptData())) {
        return setDecryptData(clazz, responseBody);
      }
      return responseBody;
    }
    return null;
  }

  /**
   * 构建解密后的响应对象
   *
   * @param clazz        响应对象的类型
   * @param responseBody 响应对象
   * @param <T>          响应结果的泛型参数
   * @return 响应结果
   */
  private <T extends BaseResp> T setDecryptData(Class<T> clazz, T responseBody) {
    if (config.getEnableAES() && !EncryptTypeEnum.NORMAL.equals(config.getEncryptType())) {
      if (!StringUtils.isEmpty(responseBody.getEncryptData())) {
        String decryptJson = AesUtils.decrypt(responseBody.getEncryptData(), config.getAesKey(), config.getEncryptType());
        return JacksonUtils.toObj(decryptJson, clazz);
      }
    }
    return responseBody;
  }

  /**
   * 对象转 map
   *
   * @param bean 对象
   * @return map
   */
  private Map<String, Object> beanToMap(Object bean) {
    if (bean == null) {
      return null;
    }
    return JacksonUtils.parseMap(JacksonUtils.toJson(bean), Object.class);
  }

  /**
   * 对参数签名并设置
   *
   * @param req          请求参数
   * @param isQueryParam 是否是查询参数
   * @param isAuth       是否是授权请求
   * @param <P>          请求参数泛型参数
   * @return 请求参数
   */
  private <P> Map<String, Object> buildReqWithSign(P req, boolean isQueryParam, boolean isAuth) {
    Map<String, Object> signMap = convertMap(req);

    Set<String> keySet = signMap.keySet();

    resetObjToJson(signMap, keySet);


    signMap.put(Constants.BASE_REQ_NAMES.CLIENT_ID, config.getClientId());
    if (!isAuth) {
      if (config.getEnableHoldToken()) {
        signMap.put(Constants.BASE_REQ_NAMES.ACCESS_TOKEN, tokenHolder.getAccessToken());
      } else {
        if (!signMap.containsKey(Constants.BASE_REQ_NAMES.ACCESS_TOKEN)) {
          throw new AccessTokenNotGivenException();
        }
      }
    }
    signMap.put(Constants.BASE_REQ_NAMES.TIMESTAMP, System.currentTimeMillis() / 1000);
    Map<String, Object> reqMap = new HashMap<>();
    if (isQueryParam) {
      reqMap.putAll(urlEncoderParam(signMap));
    } else {
      reqMap.putAll(signMap);
    }
    reqMap.put(Constants.BASE_REQ_NAMES.SIGN, SignUtils.mapParamsToSign(signMap, config.getSignKey(), config.getSignMethod()));
    return reqMap;
  }

  /**
   * 重置对象为json字符串
   *
   * @param signMap 签名串
   * @param keySet  key集合
   */
  private void resetObjToJson(Map<String, Object> signMap, Set<String> keySet) {

    List<String> removeKeys = new ArrayList<>();
    Map<String, String> originKeyMap = new HashMap<>();
    for (String s : keySet) {
      if (s.endsWith(Constants.OBJECT_SUFFIX)) {
        String originKey = s.replace(Constants.OBJECT_SUFFIX, "");
        if (signMap.containsKey(originKey) && signMap.get(originKey) != null) {
          continue;
        }
        originKeyMap.put(originKey, JacksonUtils.toJson(signMap.get(s)));
        removeKeys.add(s);
      }
    }
    if (!removeKeys.isEmpty()) {
      for (String removeKey : removeKeys) {
        signMap.remove(removeKey);
      }
    }
    if (!originKeyMap.isEmpty()) {
      signMap.putAll(originKeyMap);
    }
  }

  /**
   * 将入参转换为ma
   *
   * @param 入参
   * @param <P> 入参泛型参数
   * @return
   */
  private <P> Map<String, Object> convertMap(P req) {
    Map<String, Object> reqMap = new HashMap<>();
    if (req == null) {
      return reqMap;
    }
    if (req instanceof Map) {
      reqMap.putAll((Map<? extends String, ?>) req);
      return reqMap;
    }
    Map<String, Object> stringObjectMap = beanToMap(req);
    buildReqMap(stringObjectMap, reqMap, req.getClass());
    buildReqMap(stringObjectMap, reqMap, req.getClass().getSuperclass());
    return reqMap;
  }

  /**
   * 构建请求参数
   *
   * @param stringObjectMap 请求参数
   * @param reqMap          请求参数
   * @param clazz           类型
   */
  private void buildReqMap(Map<String, Object> stringObjectMap, Map<String, Object> reqMap, Class<?> clazz) {
    Field[] superFields = clazz.getDeclaredFields();
    for (Field field : superFields) {
      Object value;
      String keyName;
      if (hasJsonPropertyAnnotation(clazz, field.getName())) {
        JsonProperty annotation = field.getAnnotation(JsonProperty.class);
        keyName = annotation.value();
        value = stringObjectMap.get(keyName);
      } else {
        keyName = field.getName();
        value = stringObjectMap.get(field.getName());
      }
      if (value != null) {
        reqMap.put(keyName, value);
      }
    }
  }

  /**
   * url 编码
   *
   * @param params 参数
   * @return 编码后的参数
   */
  private Map<String, Object> urlEncoderParam(Map<String, Object> params) {
    try {
      Map<String, Object> encodeMap = new HashMap<>();
      for (Map.Entry<String, Object> entry : params.entrySet()) {
        encodeMap.put(entry.getKey(), URLEncoder.encode(String.valueOf(entry.getValue()), "utf-8"));
      }
      return encodeMap;
    } catch (UnsupportedEncodingException e) {
      throw new SystemException("不支持的编码格式！");
    }
  }

  /**
   * 判断是否有 @JsonProperty 注解
   *
   * @param clazz     类型
   * @param fieldName 字段名
   * @return 是否有
   */
  private boolean hasJsonPropertyAnnotation(Class<?> clazz, String fieldName) {
    boolean hasAnnotation = false;
    try {
      Field field = clazz.getDeclaredField(fieldName);
      hasAnnotation = field.isAnnotationPresent(JsonProperty.class);
    } catch (NoSuchFieldException ignore) {
    }
    return hasAnnotation;
  }

  /**
   * 获取重试次数
   *
   * @param retryTimes 重试次数
   * @return 重试次数
   */
  private Integer getRetryTimes(Integer retryTimes) {
    if (retryTimes == null) {
      retryTimes = 0;
    }
    if (retryTimes > config.getUnauthorizedRetryTimes()) {
      throw new AccessTokenNotGivenException();
    }
    try {
      if (config.getUnauthorizedRetryInterval() != null) {
        Thread.sleep(config.getUnauthorizedRetryInterval());
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    tokenHolder.getAccessToken();
    return retryTimes + 1;
  }

  /**
   * 验证token是否失效
   *
   * @param resp 响应对象
   * @return 是否失效
   */
  private boolean isTokenInvalid(BaseResp resp) {
    return resp != null && Constants.INVALID_ACCESS_TOKEN_CODE.equals(resp.getErrno());
  }

  /**
   * 设置请求头
   *
   * @param request 请求对象
   */
  private void setAgentHeader(RawRequest request) {
    request.getHeaders().put(Constants.USER_AGENT, Lists.newArrayList(Constants.DIDI_AGENT));
  }

  /**
   * 构建AES请求参数
   *
   * @param requestParam 请求参数
   * @return AES请求参数
   */
  private Map<String, Object> buildAesRequestParam(Map<String, Object> requestParam) {
    if (StringUtils.isEmpty(config.getAesKey())) {
      throw new SystemException("开启AES加密请先未配置aesKey!");
    }
    requestParam.remove(Constants.BASE_REQ_NAMES.SIGN);
    String entContent = buildEntContent(requestParam);

    Map<String, Object> aesBody = new HashMap<>();
    aesBody.put(Constants.BASE_REQ_NAMES.ENCRYPT_CONTENT, entContent);
    aesBody.put(Constants.BASE_REQ_NAMES.ENT, config.getEncryptType().getType());
    aesBody.put(Constants.BASE_REQ_NAMES.CLIENT_ID, requestParam.get(Constants.BASE_REQ_NAMES.CLIENT_ID));
    aesBody.put(Constants.BASE_REQ_NAMES.ACCESS_TOKEN, requestParam.get(Constants.BASE_REQ_NAMES.ACCESS_TOKEN).toString());
    aesBody.put(Constants.BASE_REQ_NAMES.SIGN, SignUtils.mapParamsToSign(aesBody, config.getSignKey(), config.getSignMethod()));
    return aesBody;
  }

  /**
   * 构建加密内容
   *
   * @param requestBody 请求参数
   * @return 加密内容
   */
  private String buildEntContent(Map<String, Object> requestBody) {
    StringBuilder sb = new StringBuilder();
    Set<Map.Entry<String, Object>> entries = requestBody.entrySet();
    for (Map.Entry<String, Object> entry : entries) {
      String key = entry.getKey();
      if (Constants.BASE_REQ_NAMES.ACCESS_TOKEN.equals(key) || Constants.BASE_REQ_NAMES.CLIENT_ID.equals(key)) {
        continue;
      }
      if (sb.length() > 0) {
        sb.append("&");
      }
      sb.append(key).append("=").append(entry.getValue().toString());
    }
    return AesUtils.encrypt(sb.toString(), config.getAesKey(), config.getEncryptType());
  }
}