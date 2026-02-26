package com.xiaoju.open.sdk.didies.core.request

import com.xiaoju.open.sdk.didies.core.Config
import com.xiaoju.open.sdk.didies.core.enums.LogLevelEnum
import com.xiaoju.open.sdk.didies.core.exception.ServerTimeoutException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification
import spock.lang.Unroll

import java.util.HashMap

class RestHttpTransportTest extends Specification {

    RestTemplate mockRestTemplate
    RestHttpTransport transport
    Config testConfig

    def setup() {
        mockRestTemplate = Mock(RestTemplate)
        transport = new RestHttpTransport(mockRestTemplate)
        testConfig = Config.builder()
                .clientId("test_client")
                .clientSecret("test_secret")
                .baseUrl("https://test.api.com")
                .build()
    }

    def "get should send GET request and return response"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.params = [param1: "value1", param2: "value2"]
        request.config = testConfig

        def responseBody = '{"result": "success"}'
        def responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK)

        when:
        def result = transport.get(request)

        then:
        1 * mockRestTemplate.exchange(
                { it.toString().contains("param1=value1") && it.toString().contains("param2=value2") },
                _,
                _,
                _
        ) >> responseEntity
        result.statusCode == 200
        result.body == responseBody
    }

    def "get should handle collection parameters"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.params = [ids: ["1", "2", "3"]]
        request.config = testConfig

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.OK)

        when:
        transport.get(request)

        then:
        1 * mockRestTemplate.exchange(_, _, _, _) >> responseEntity
    }

    def "get should handle empty parameters"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.params = [:]
        request.config = testConfig

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.OK)

        when:
        transport.get(request)

        then:
        1 * mockRestTemplate.exchange(
                { it == "https://test.api.com/test" },
                _,
                _,
                _
        ) >> responseEntity
    }

    def "get should handle null parameters"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.params = null
        request.config = testConfig

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.OK)

        when:
        transport.get(request)

        then:
        1 * mockRestTemplate.exchange(
                { it == "https://test.api.com/test" },
                _,
                _,
                _
        ) >> responseEntity
    }

    def "get should throw ServerTimeoutException on 504 status"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.config = testConfig

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.GATEWAY_TIMEOUT)

        when:
        transport.get(request)

        then:
        1 * mockRestTemplate.exchange(_, _, _, _) >> responseEntity
        def e = thrown(RuntimeException)
        e.cause instanceof ServerTimeoutException
    }

    def "post with RawRequest should send POST request with JSON body"() {
        given:
        def request = new RawRequest()
        request.url = "https://test.api.com/test"
        request.body = '{"key": "value"}'
        request.config = testConfig

        def responseBody = '{"result": "success"}'
        def responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK)

        when:
        def result = transport.post(request)

        then:
        1 * mockRestTemplate.postForEntity(_, _, _) >> responseEntity
        result.statusCode == 200
        result.body == responseBody
    }

    def "post with RawRequest should handle null body"() {
        given:
        def request = new RawRequest()
        request.url = "https://test.api.com/test"
        request.body = null
        request.config = testConfig

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.OK)

        when:
        def result = transport.post(request)

        then:
        1 * mockRestTemplate.postForEntity(_, _, _) >> responseEntity
        result.statusCode == 200
    }

    def "post with RawRequest should throw ServerTimeoutException on 504 status"() {
        given:
        def request = new RawRequest()
        request.url = "https://test.api.com/test"
        request.body = '{"test": "data"}'
        request.config = testConfig

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.GATEWAY_TIMEOUT)

        when:
        transport.post(request)

        then:
        1 * mockRestTemplate.postForEntity(_, _, _) >> responseEntity
        def e = thrown(RuntimeException)
        e.cause instanceof ServerTimeoutException
    }

    def "post with FormRequest should send POST request with form data"() {
        given:
        def request = new FormRequest()
        request.url = "https://test.api.com/test"
        request.body = [field1: "value1", field2: "value2"]
        request.config = testConfig

        def responseBody = '{"result": "success"}'
        def responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK)

        when:
        def result = transport.post(request)

        then:
        1 * mockRestTemplate.postForEntity(_, _, _) >> responseEntity
        result.statusCode == 200
        result.body == responseBody
    }

    def "post with FormRequest should handle collection values"() {
        given:
        def request = new FormRequest()
        request.url = "https://test.api.com/test"
        request.body = [tags: ["tag1", "tag2", "tag3"]]
        request.config = testConfig

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.OK)

        when:
        transport.post(request)

        then:
        1 * mockRestTemplate.postForEntity(_, _, _) >> responseEntity
    }

    def "post with FormRequest should handle null body"() {
        given:
        def request = new FormRequest()
        request.url = "https://test.api.com/test"
        request.body = null
        request.config = testConfig

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.OK)

        when:
        def result = transport.post(request)

        then:
        1 * mockRestTemplate.postForEntity(_, _, _) >> responseEntity
        result.statusCode == 200
    }

    def "post with FormRequest should throw ServerTimeoutException on 504 status"() {
        given:
        def request = new FormRequest()
        request.url = "https://test.api.com/test"
        request.body = [field: "value"]
        request.config = testConfig

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.GATEWAY_TIMEOUT)

        when:
        transport.post(request)

        then:
        1 * mockRestTemplate.postForEntity(_, _, _) >> responseEntity
        def e = thrown(RuntimeException)
        e.cause instanceof ServerTimeoutException
    }

    def "post with FormRequest should handle empty body"() {
        given:
        def request = new FormRequest()
        request.url = "https://test.api.com/test"
        request.body = [:]
        request.config = testConfig

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.OK)

        when:
        transport.post(request)

        then:
        1 * mockRestTemplate.postForEntity(_, _, _) >> responseEntity
    }

    def "should copy response headers correctly"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.config = testConfig

        def responseBody = '{"result": "success"}'
        def headers = new org.springframework.http.HttpHeaders()
        headers.add("Content-Type", "application/json")
        headers.add("Custom-Header", "custom_value")
        def responseEntity = new ResponseEntity<>(responseBody, headers, HttpStatus.OK)

        when:
        def result = transport.get(request)

        then:
        1 * mockRestTemplate.exchange(_, _, _, _) >> responseEntity
        result.headers["Content-Type"] == ["application/json"]
        result.headers["Custom-Header"] == ["custom_value"]
    }

    @Unroll
    def "should handle HTTP status code #statusCode"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.config = testConfig

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.valueOf(statusCode))

        when:
        def result = transport.get(request)

        then:
        1 * mockRestTemplate.exchange(_, _, _, _) >> responseEntity
        result.statusCode == statusCode

        where:
        statusCode << [200, 201, 400, 401, 403, 404, 500]
    }

    def "should wrap exceptions in RuntimeException"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.config = testConfig

        when:
        transport.get(request)

        then:
        1 * mockRestTemplate.exchange(_, _, _, _) >> { throw new IOException("Network error") }
        thrown(RuntimeException)
    }

    def "should log request when enableRequestLog is true with INFO level"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .baseUrl("https://test.api.com")
                .enableRequestLog(true)
                .logLevel(LogLevelEnum.INFO)
                .build()
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.config = config

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.OK)

        when:
        transport.get(request)

        then:
        1 * mockRestTemplate.exchange(_, _, _, _) >> responseEntity
    }

    def "should not log request when enableRequestLog is false"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .baseUrl("https://test.api.com")
                .enableRequestLog(false)
                .build()
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.config = config

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.OK)

        when:
        transport.get(request)

        then:
        1 * mockRestTemplate.exchange(_, _, _, _) >> responseEntity
    }

    def "should build URL with query parameters correctly"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.params = [key1: "value1", key2: "value2"]
        request.config = testConfig

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.OK)

        when:
        transport.get(request)

        then:
        1 * mockRestTemplate.exchange(
                { it ->
                    it.contains("key1=value1") && it.contains("key2=value2")
                },
                _, _, _
        ) >> responseEntity
    }

    def "should handle URL encoding in query parameters"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com/test"
        request.params = [query: "hello world", special: "a&b"]
        request.config = testConfig

        def responseEntity = new ResponseEntity<>("{}", HttpStatus.OK)

        when:
        transport.get(request)

        then:
        1 * mockRestTemplate.exchange(_, _, _, _) >> responseEntity
    }
}
