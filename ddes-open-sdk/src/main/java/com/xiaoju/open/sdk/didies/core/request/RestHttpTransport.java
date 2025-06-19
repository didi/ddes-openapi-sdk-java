package com.xiaoju.open.sdk.didies.core.request;

import com.xiaoju.open.sdk.didies.core.Config;
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum;
import com.xiaoju.open.sdk.didies.core.exception.ServerTimeoutException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * rest http transport
 */
@Slf4j
@RequiredArgsConstructor
public class RestHttpTransport implements IHttpTransport {

  /**
   * rest template
   */
  private final RestTemplate restTemplate;

  /**
   * get请求实现
   *
   * @param request request
   * @return response
   */
  @Override
  public RawResponse get(Request request) {
    try {
      HttpHeaders headers = buildHeaders(request);
      String reqUrl = buildUrl(request.getUrl(), request.getParams());
      HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
      writeRequestLog(request, reqUrl, httpEntity);
      ResponseEntity<String> responseEntity = restTemplate.exchange(reqUrl, HttpMethod.GET, httpEntity, String.class);
      writeResponseLog(request, reqUrl, httpEntity, responseEntity);
      RawResponse rawResponse = buildRawResponse(responseEntity);
      // 服务端超时
      if (rawResponse.getStatusCode() == 504) {
        log.error(String.format("httpMethod:%s, httpPath:%s, server time out", HttpMethod.GET, reqUrl));
        throw new ServerTimeoutException();
      }
      return rawResponse;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * post请求实现
   *
   * @param request request
   * @return response
   */
  @Override
  public RawResponse post(RawRequest request) {
    try {
      HttpHeaders headers = buildRawHeaders(request);
      String reqUrl = buildUrl(request.getUrl(), request.getParams());
      HttpEntity<String> httpEntity = new HttpEntity<>(request.getBody(), headers);
      writeRequestLog(request, reqUrl, httpEntity);
      ResponseEntity<String> responseEntity = restTemplate.postForEntity(reqUrl, httpEntity, String.class);
      writeResponseLog(request, reqUrl, httpEntity, responseEntity);
      RawResponse rawResponse = buildRawResponse(responseEntity);
      // 服务端超时
      if (rawResponse.getStatusCode() == 504) {
        log.error("httpMethod:{}, httpPath:{}, server time out", HttpMethod.GET, reqUrl);
        throw new ServerTimeoutException();
      }
      return rawResponse;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * post请求实现
   *
   * @param request request
   * @return response
   */
  @Override
  public RawResponse post(FormRequest request) {
    try {
      HttpHeaders headers = buildHeaders(request);
      String reqUrl = buildUrl(request.getUrl(), request.getParams());
      MultiValueMap<String, String> body = buildFormBody(request);
      HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(body, headers);
      writeRequestLog(request, reqUrl, httpEntity);
      ResponseEntity<String> responseEntity = restTemplate.postForEntity(reqUrl, httpEntity, String.class);
      writeResponseLog(request, reqUrl, httpEntity, responseEntity);
      RawResponse rawResponse = buildRawResponse(responseEntity);
      // 服务端超时
      if (rawResponse.getStatusCode() == 504) {
        log.error("httpMethod:{}, httpPath:{}, server time out", HttpMethod.POST, reqUrl);
        throw new ServerTimeoutException();
      }
      return rawResponse;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 构建headers
   *
   * @param request request
   * @return headers
   */
  private HttpHeaders buildHeaders(Request request) {
    return buildHeaders(request, MediaType.APPLICATION_FORM_URLENCODED);
  }

  /**
   * 构建headers
   *
   * @param request request
   * @return headers
   */
  private HttpHeaders buildRawHeaders(RawRequest request) {
    return buildHeaders(request, MediaType.APPLICATION_JSON);
  }

  /**
   * 构建headers
   *
   * @param request            request
   * @param defaultContentType defaultContentType
   * @return headers
   */
  private HttpHeaders buildHeaders(Headers headers, MediaType defaultContentType) {
    HttpHeaders httpHeaders = new HttpHeaders();
    if (headers.getHeaders() == null || headers.getHeaders().isEmpty()) {
      httpHeaders.setContentType(defaultContentType);
    } else {
      for (Map.Entry<String, List<String>> entry : headers.getHeaders().entrySet()) {
        for (String value : entry.getValue()) {
          httpHeaders.add(entry.getKey(), value);
        }
      }
      if (headers.getContentType() == null) {
        httpHeaders.setContentType(defaultContentType);
      }
    }
    return httpHeaders;
  }

  /**
   * 构建url
   *
   * @param url    url
   * @param params params
   * @return url
   */
  private String buildUrl(String url, Map<String, Object> params) {
    if (params == null || params.isEmpty()) {
      return url;
    }
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
    for (Map.Entry<String, Object> entry : params.entrySet()) {
      if (entry.getValue() instanceof Collection) {
        builder.queryParam(entry.getKey(), (Collection<?>) entry.getValue());
      } else {
        builder.queryParam(entry.getKey(), entry.getValue());
      }
    }
    return builder.build().toUriString();
  }

  /**
   * 构建表单请求体
   *
   * @param request request
   * @return body
   */
  private MultiValueMap<String, String> buildFormBody(FormRequest request) {
    if (request.getBody() == null) {
      return null;
    }
    MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
    for (Map.Entry<String, Object> entry : request.getBody().entrySet()) {
      if (entry.getValue() instanceof Collection) {
        ((Collection<?>) entry.getValue()).forEach(it -> body.add(entry.getKey(), it.toString()));
      } else {
        body.add(entry.getKey(), entry.getValue().toString());
      }
    }
    return body;
  }

  /**
   * 构建原始响应
   *
   * @param responseEntity responseEntity
   * @return rawResponse
   */
  private RawResponse buildRawResponse(ResponseEntity<String> responseEntity) {
    RawResponse rawResponse = new RawResponse();
    HttpHeaders httpHeaders = responseEntity.getHeaders();
    for (Map.Entry<String, List<String>> entry : httpHeaders.entrySet()) {
      rawResponse.getHeaders().put(entry.getKey(), entry.getValue());
    }
    rawResponse.setStatusCode(responseEntity.getStatusCodeValue());
    rawResponse.setBody(responseEntity.getBody());
    return rawResponse;
  }

  /**
   * 写请求日志
   *
   * @param request    request
   * @param url        url
   * @param httpEntity httpEntity
   */
  private void writeRequestLog(Request request, String url, HttpEntity httpEntity) {
    if (request.getConfig() != null && Boolean.TRUE.equals(request.getConfig().getEnableRequestLog())) {
      Config config = request.getConfig();
      LogLevelEnum logLevel = config.getLogLevel();
      if (LogLevelEnum.INFO.equals(logLevel)) {
        log.info("请求开始! url={}, request={}", url, httpEntity);
      } else {
        log.debug("请求开始！ url={}, request={}", url, httpEntity);
      }
    }

  }

  /**
   * 写响应日志
   *
   * @param request    request
   * @param url        url
   * @param httpEntity httpEntity
   * @param response   response
   */
  private void writeResponseLog(Request request, String url, HttpEntity httpEntity, ResponseEntity<String> response) {
    if (request.getConfig() != null && Boolean.TRUE.equals(request.getConfig().getEnableRequestLog())) {
      Config config = request.getConfig();
      LogLevelEnum logLevel = config.getLogLevel();
      if (LogLevelEnum.INFO.equals(logLevel)) {
        log.info("请求结束！url={}, request={}, response={}", url, httpEntity, response);
      } else {
        log.debug("请求结束！url={}, request={}, response={}", url, httpEntity, response);
      }
    }
  }
}