package com.xiaoju.open.sdk.didies.replay

import com.xiaoju.open.sdk.didies.ApiClient
import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.request.OkHttpTransport
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import spock.lang.Specification

import java.util.logging.Level
import java.util.logging.Logger

/**
 * 回放基建：精简 Spock 基类（对齐 design D3）。
 *
 * 仅封装回放所需三样：起 MockWebServer、mock auth 端点返回占位 token、
 * Config.builder().httpTransport(OkHttpTransport()) 注入指向 mock 的 ApiClient。
 *
 * 不引用、不复制 ddes-open-sdk/src/test 的 BaseMockTest（Maven test 类不跨模块可见，
 * 复制会引入 verifyHeaders/getQueryParams 等回放用不上的死代码）；
 * 不下沉任何类到 ddes-open-sdk/src/main（避免污染发布产物）。
 */
abstract class ReplayBase extends Specification {

    static final String AUTH_PATH = "/river/Auth/authorize"

    /** auth 端点固定返回的占位 token（回放不校验 sign，token 仅用于通过 SDK 鉴权链路） */
    static final String AUTH_RESP = """{
        "errno": 0,
        "errmsg": "success",
        "request_id": "replay_auth",
        "access_token": "replay_access_token",
        "expires_in": 7200,
        "token_type": "Bearer"
    }"""

    MockWebServer mockWebServer
    /** uri -> 当前响应 out（逐条回放时 setOut 切换） */
    Map<String, Map<String, Object>> outMap = [:]
    Config replayConfig
    ApiClient apiClient

    def setup() {
        // 关闭 MockWebServer 的请求日志（java.util.logging），避免逐条回放时日志刷屏拖慢
        Logger.getLogger(MockWebServer.class.name).setLevel(Level.OFF)
        mockWebServer = new MockWebServer()
        // 用 Dispatcher 按 path 路由：auth 路径返回占位 token，业务路径返回当前 out。
        // 这样逐条 setOut(uri, out) 切换业务响应，auth 端点不受影响。
        mockWebServer.setDispatcher(new Dispatcher() {
            @Override
            MockResponse dispatch(RecordedRequest request) {
                String path = request.path
                // path 可能带 query，取 ? 之前
                String pure = path.contains("?") ? path.substring(0, path.indexOf("?")) : path
                if (pure == AUTH_PATH) {
                    return okJson(AUTH_RESP)
                }
                Map<String, Object> out = outMap.get(pure)
                if (out == null) {
                    return new MockResponse().setResponseCode(404)
                }
                return okJson(groovy.json.JsonOutput.toJson(out))
            }
        })
        mockWebServer.start()

        replayConfig = Config.builder()
                .clientId("replay_client_id")
                .clientSecret("replay_client_secret")
                .signKey("replay_sign_key_only")
                .baseUrl("http://localhost:" + mockWebServer.port)
                .enableHoldToken(true)
                .httpTransport(new OkHttpTransport())
                .build()
        apiClient = new ApiClient(replayConfig)
    }

    def cleanup() {
        mockWebServer.shutdown()
    }

    /** 切换 uri 的当前响应 out（逐条回放用） */
    void setOut(String uri, Map<String, Object> out) {
        outMap[uri] = out
    }

    private static MockResponse okJson(String body) {
        return new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(body)
    }
}
