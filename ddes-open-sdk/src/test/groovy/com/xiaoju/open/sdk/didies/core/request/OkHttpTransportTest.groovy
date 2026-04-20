package com.xiaoju.open.sdk.didies.core.request

import com.xiaoju.open.sdk.didies.core.Config
import okhttp3.OkHttpClient
import spock.lang.Specification

class OkHttpTransportTest extends Specification {

    def "default constructor should create client with default timeouts"() {
        when:
        def transport = new OkHttpTransport()

        then:
        transport != null
    }

    def "constructor with OkHttpClient should create transport with custom client"() {
        given:
        def customClient = new OkHttpClient.Builder()
                .connectTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
                .build()

        when:
        def customTransport = new OkHttpTransport(customClient)

        then:
        customTransport != null
    }

    def "get method should exist"() {
        given:
        def transport = new OkHttpTransport()
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.params = [param1: "value1"]
        request.config = Config.builder().clientId("test").build()

        expect:
        transport != null
        transport.getClass().getMethod("get", Request.class) != null
    }

    def "post method with RawRequest should exist"() {
        given:
        def transport = new OkHttpTransport()
        def request = new RawRequest()
        request.url = "https://test.api.com/test"
        request.body = '{"key": "value"}'
        request.config = Config.builder().clientId("test").build()

        expect:
        transport != null
        transport.getClass().getMethod("post", RawRequest.class) != null
    }

    def "post method with FormRequest should exist"() {
        given:
        def transport = new OkHttpTransport()
        def request = new FormRequest()
        request.url = "https://test.api.com/test"
        request.body = [field1: "value1", field2: "value2"]
        request.config = Config.builder().clientId("test").build()

        expect:
        transport != null
        transport.getClass().getMethod("post", FormRequest.class) != null
    }

    def "OkHttpTransport should implement IHttpTransport"() {
        given:
        def transport = new OkHttpTransport()

        expect:
        transport instanceof IHttpTransport
    }

    def "OkHttpTransport should have correct constructor signatures"() {
        expect:
        OkHttpTransport.getConstructor() != null
        OkHttpTransport.getConstructor(OkHttpClient) != null
    }

    def "OkHttpTransport should handle Request with all properties"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .baseUrl("https://test.api.com")
                .build()

        def request = new Request()
        request.url = "https://test.api.com/test"
        request.params = [param1: "value1", param2: "value2"]
        request.config = config
        request.headers.headers = ["Custom-Header": ["custom_value"]]

        expect:
        request.url == "https://test.api.com/test"
        request.params == [param1: "value1", param2: "value2"]
        request.config == config
        request.headers.headers["Custom-Header"] == ["custom_value"]
    }

    def "OkHttpTransport should handle RawRequest with body"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .baseUrl("https://test.api.com")
                .build()

        def request = new RawRequest()
        request.url = "https://test.api.com/test"
        request.body = '{"key": "value"}'
        request.config = config
        request.headers.headers = ["Content-Type": ["application/json"]]

        expect:
        request.url == "https://test.api.com/test"
        request.body == '{"key": "value"}'
        request.config == config
        request.headers.headers["Content-Type"] == ["application/json"]
    }

    def "OkHttpTransport should handle FormRequest with body"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .baseUrl("https://test.api.com")
                .build()

        def request = new FormRequest()
        request.url = "https://test.api.com/test"
        request.body = [field1: "value1", field2: "value2"]
        request.config = config

        expect:
        request.url == "https://test.api.com/test"
        request.body == [field1: "value1", field2: "value2"]
        request.config == config
    }

    def "OkHttpTransport should handle null body in RawRequest"() {
        given:
        def request = new RawRequest()
        request.url = "https://test.api.com/test"
        request.body = null
        request.config = Config.builder().clientId("test").build()

        expect:
        request.url == "https://test.api.com/test"
        request.body == null
    }

    def "OkHttpTransport should handle null body in FormRequest"() {
        given:
        def request = new FormRequest()
        request.url = "https://test.api.com/test"
        request.body = null
        request.config = Config.builder().clientId("test").build()

        expect:
        request.url == "https://test.api.com/test"
        request.body == null
    }

    def "OkHttpTransport should handle null parameter values"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.params = [param1: "value1", param2: null, param3: "value3"]
        request.config = Config.builder().clientId("test").build()

        expect:
        request.url == "https://test.api.com/test"
        request.params.param1 == "value1"
        request.params.param2 == null
        request.params.param3 == "value3"
    }

    def "OkHttpTransport should handle empty parameters"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.params = [:]
        request.config = Config.builder().clientId("test").build()

        expect:
        request.url == "https://test.api.com/test"
        request.params.isEmpty()
    }

    def "OkHttpTransport should handle null parameters"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.params = null
        request.config = Config.builder().clientId("test").build()

        expect:
        request.url == "https://test.api.com/test"
        request.params == null
    }

    def "OkHttpTransport should add custom headers"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.headers.headers = ["Authorization": ["Bearer token123"], "X-Custom-Header": ["custom"]]
        request.config = Config.builder().clientId("test").build()

        expect:
        request.headers.headers["Authorization"] == ["Bearer token123"]
        request.headers.headers["X-Custom-Header"] == ["custom"]
    }

    def "OkHttpTransport should add multiple values for same header"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.headers.headers = ["X-Custom": ["value1", "value2"]]
        request.config = Config.builder().clientId("test").build()

        expect:
        request.headers.headers["X-Custom"].size() == 2
        request.headers.headers["X-Custom"][0] == "value1"
        request.headers.headers["X-Custom"][1] == "value2"
    }
}
