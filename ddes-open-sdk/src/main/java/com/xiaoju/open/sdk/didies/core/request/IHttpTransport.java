package com.xiaoju.open.sdk.didies.core.request;

public interface IHttpTransport {

  /**
   * GET 一般请求，通过URL传参
   * 默认 Content-Type = application/x-www-form-urlencoded
   */
  RawResponse get(Request request);

  /**
   * POST 字符串
   * 默认 Content-Type = application/json
   */
  RawResponse post(RawRequest request);

  /**
   * POST 表单
   * 默认 Content-Type = application/x-www-form-urlencoded
   */
  RawResponse post(FormRequest request);
}
