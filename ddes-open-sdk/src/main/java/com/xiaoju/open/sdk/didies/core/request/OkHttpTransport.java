package com.xiaoju.open.sdk.didies.core.request;

import com.xiaoju.open.sdk.didies.core.Config;
import lombok.RequiredArgsConstructor;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * OkHttp-based transport implementation for testing with MockWebServer
 */
@RequiredArgsConstructor
public class OkHttpTransport implements IHttpTransport {

    private final OkHttpClient httpClient;

    public OkHttpTransport() {
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public RawResponse get(Request request) {
        try {
            HttpUrl url = buildUrl(request.getUrl(), request.getParams());
            okhttp3.Request.Builder requestBuilder = new okhttp3.Request.Builder()
                    .url(url)
                    .get();

            addHeaders(requestBuilder, request);

            okhttp3.Request okRequest = requestBuilder.build();
            okhttp3.Response okResponse = httpClient.newCall(okRequest).execute();

            return buildRawResponse(okResponse);
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute GET request", e);
        }
    }

    @Override
    public RawResponse post(RawRequest request) {
        try {
            HttpUrl url = HttpUrl.parse(request.getUrl());
            okhttp3.Request.Builder requestBuilder = new okhttp3.Request.Builder()
                    .url(url)
                    .post(RequestBody.create(
                            MediaType.parse("application/json; charset=utf-8"),
                            request.getBody() != null ? request.getBody() : ""
                    ));

            addHeaders(requestBuilder, request);

            okhttp3.Request okRequest = requestBuilder.build();
            okhttp3.Response okResponse = httpClient.newCall(okRequest).execute();

            return buildRawResponse(okResponse);
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute POST request", e);
        }
    }

    @Override
    public RawResponse post(FormRequest request) {
        try {
            HttpUrl url = buildUrl(request.getUrl(), request.getParams());

            FormBody.Builder formBuilder = new FormBody.Builder();
            if (request.getBody() != null) {
                for (Map.Entry<String, Object> entry : request.getBody().entrySet()) {
                    Object value = entry.getValue();
                    if (value != null) {
                        formBuilder.add(entry.getKey(), value.toString());
                    }
                }
            }

            okhttp3.Request.Builder requestBuilder = new okhttp3.Request.Builder()
                    .url(url)
                    .post(formBuilder.build());

            addHeaders(requestBuilder, request);

            okhttp3.Request okRequest = requestBuilder.build();
            okhttp3.Response okResponse = httpClient.newCall(okRequest).execute();

            return buildRawResponse(okResponse);
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute POST form request", e);
        }
    }

    private HttpUrl buildUrl(String baseUrl, Map<String, Object> params) {
        HttpUrl url = HttpUrl.parse(baseUrl);
        HttpUrl.Builder urlBuilder = url.newBuilder();

        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    urlBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString());
                }
            }
        }

        return urlBuilder.build();
    }

    private void addHeaders(okhttp3.Request.Builder builder, Headers headers) {
        if (headers.getHeaders() != null) {
            for (Map.Entry<String, java.util.List<String>> entry : headers.getHeaders().entrySet()) {
                for (String value : entry.getValue()) {
                    builder.addHeader(entry.getKey(), value);
                }
            }
        }
    }

    private RawResponse buildRawResponse(okhttp3.Response response) throws IOException {
        RawResponse rawResponse = new RawResponse();
        rawResponse.setStatusCode(response.code());
        rawResponse.setBody(response.body() != null ? response.body().string() : null);

        // Copy headers
        for (Map.Entry<String, java.util.List<String>> entry : response.headers().toMultimap().entrySet()) {
            rawResponse.getHeaders().put(entry.getKey(), entry.getValue());
        }

        return rawResponse;
    }
}
