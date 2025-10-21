package com.xiaoju.open.sdk.didies.core.request;

/**
 * 自定义请求接口
 */
public interface IHttpTransport {

  /**
   * GET 一般请求，通过URL传参
   * 默认 Content-Type = application/x-www-form-urlencoded
   *
   * @param request 请求参数
   * @return 响应结果
   */
  RawResponse get(Request request);

  /**
   * POST 字符串
   * 默认 Content-Type = application/json
   *
   * @param request 请求参数
   * @return 响应结果
   */
  RawResponse post(RawRequest request);

  /**
   * POST 表单
   * 默认 Content-Type = application/x-www-form-urlencoded
   *
   * @param request 请求参数
   * @return 响应结果
   */
  RawResponse post(FormRequest request);
}
