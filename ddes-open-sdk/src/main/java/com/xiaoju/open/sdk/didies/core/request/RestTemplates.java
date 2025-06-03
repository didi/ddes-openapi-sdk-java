package com.xiaoju.open.sdk.didies.core.request;

import com.xiaoju.open.sdk.didies.core.Config;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.concurrent.TimeUnit;

public class RestTemplates {

  public static RestTemplate noneUrlEncodeRestTemplate(Config config) {
    OkHttp3ClientHttpRequestFactory factory = buildOkHttp3ClientHttpRequestFactory(config);
    RestTemplate restTemplate = new RestTemplate(factory);
    DefaultUriBuilderFactory builderFactory = new DefaultUriBuilderFactory();
    builderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
    restTemplate.setUriTemplateHandler(builderFactory);
    restTemplate.setErrorHandler(new ResponseErrorHandler() {
      @Override
      public boolean hasError(ClientHttpResponse response) {
        return false;
      }

      @Override
      public void handleError(ClientHttpResponse response) {
      }
    });
    return restTemplate;
  }

  private static OkHttp3ClientHttpRequestFactory buildOkHttp3ClientHttpRequestFactory(Config config) {

    long connectTimeout = config.getConnectTimeout() == null || config.getConnectTimeout() == 0L ? 6000L : config.getConnectTimeout();
    long callTimeout = config.getCallTimeOut() == null || config.getCallTimeOut() == 0L ? 6000L : config.getCallTimeOut();
    TimeUnit timeoutUnit = config.getTimeoutUnit() == null ? TimeUnit.MILLISECONDS : config.getTimeoutUnit();

    OkHttpClient.Builder builder = (new OkHttpClient.Builder())
        .callTimeout(callTimeout, timeoutUnit)
        .connectTimeout(connectTimeout, timeoutUnit)
        .writeTimeout(10000, TimeUnit.MILLISECONDS)
        .readTimeout(10000, TimeUnit.MILLISECONDS)
        .connectionPool(new ConnectionPool(100, 30000, TimeUnit.MILLISECONDS));
    OkHttpClient client = builder.build();
    return new OkHttp3ClientHttpRequestFactory(client);
  }
}
