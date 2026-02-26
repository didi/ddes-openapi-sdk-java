package com.xiaoju.open.sdk.didies.core.request

import com.xiaoju.open.sdk.didies.core.Config
import spock.lang.Specification
import spock.lang.Unroll

class RequestTest extends Specification {

    def "Request should extend Headers"() {
        expect:
        new Request() instanceof Headers
    }



    def "Request should set and get url"() {
        given:
        def request = new Request()

        when:
        request.url = "https://test.api.com/test"

        then:
        request.url == "https://test.api.com/test"
    }

    def "Request should set and get params"() {
        given:
        def request = new Request()
        def params = [param1: "value1", param2: "value2"]

        when:
        request.params = params

        then:
        request.params == params
        request.params.param1 == "value1"
        request.params.param2 == "value2"
    }

    def "Request should set and get config"() {
        given:
        def request = new Request()
        def config = Config.builder()
                .clientId("test_client")
                .build()

        when:
        request.config = config

        then:
        request.config == config
        request.config.clientId == "test_client"
    }

    def "Request should set and get headers through parent class"() {
        given:
        def request = new Request()

        when:
        request.headers.headers = ["Authorization": ["Bearer token"], "Content-Type": ["application/json"]]

        then:
        request.headers.headers["Authorization"] == ["Bearer token"]
        request.headers.headers["Content-Type"] == ["application/json"]
    }

    @Unroll
    def "Request should handle #valueType url"() {
        given:
        def request = new Request()

        when:
        request.url = urlValue

        then:
        request.url == expectedValue

        where:
        valueType    | urlValue                       | expectedValue
        "normal"      | "https://test.api.com/test"    | "https://test.api.com/test"
        "with port"   | "https://test.api.com:8080/api" | "https://test.api.com:8080/api"
        "with query"  | "https://test.api.com?foo=bar" | "https://test.api.com?foo=bar"
        "null"        | null                           | null
        "empty"       | ""                             | ""
    }

    def "Request should handle empty params map"() {
        given:
        def request = new Request()
        def params = [:]

        when:
        request.params = params

        then:
        request.params.isEmpty()
    }

    def "Request should handle params with collection values"() {
        given:
        def request = new Request()
        def params = [ids: ["1", "2", "3"], tags: ["tag1", "tag2"]]

        when:
        request.params = params

        then:
        request.params.ids == ["1", "2", "3"]
        request.params.tags == ["tag1", "tag2"]
    }

    def "Request should handle params with null values"() {
        given:
        def request = new Request()
        def params = [key1: "value1", key2: null, key3: "value3"]

        when:
        request.params = params

        then:
        request.params.key1 == "value1"
        request.params.key2 == null
        request.params.key3 == "value3"
    }

    def "Request should allow setting all properties"() {
        given:
        def request = new Request()
        def config = Config.builder()
                .clientId("test_client")
                .baseUrl("https://test.api.com")
                .build()

        when:
        request.url = "https://test.api.com/test"
        request.params = [param: "value"]
        request.config = config
        request.headers.headers = ["X-Custom": ["custom_value"]]

        then:
        request.url == "https://test.api.com/test"
        request.params.param == "value"
        request.config == config
        request.headers.headers["X-Custom"] == ["custom_value"]
    }

    def "Request should be modifiable after creation"() {
        given:
        def request = new Request()
        request.url = "https://original.api.com"

        when:
        request.url = "https://modified.api.com"

        then:
        request.url == "https://modified.api.com"
    }

    def "Request should handle multiple param modifications"() {
        given:
        def request = new Request()
        request.params = [key1: "value1"]

        when:
        request.params = [key2: "value2"]

        then:
        request.params.key2 == "value2"
        request.params.key1 == null
    }

    def "Request should work with Lombok @Data annotation"() {
        given:
        def request1 = new Request()
        request1.url = "https://test.api.com"
        request1.params = [param: "value"]
        request1.config = Config.builder().clientId("test").build()

        and:
        def request2 = new Request()
        request2.url = "https://test.api.com"
        request2.params = [param: "value"]
        request2.config = Config.builder().clientId("test").build()

        expect:
        request1.url == request2.url
        request1.params == request2.params
    }

    def "Request should work with Lombok @ToString annotation"() {
        given:
        def request = new Request()
        request.url = "https://test.api.com"
        request.params = [param: "value"]

        when:
        def str = request.toString()

        then:
        str.contains("Request")
        str.contains("url")
    }

    def "Request should work with Lombok @EqualsAndHashCode annotation"() {
        given:
        def config = Config.builder().clientId("test").build()

        def request1 = new Request()
        request1.url = "https://test.api.com"
        request1.params = [param: "value"]
        request1.config = config

        def request2 = new Request()
        request2.url = "https://test.api.com"
        request2.params = [param: "value"]
        request2.config = config

        expect:
        request1.equals(request2)
        request1.hashCode() == request2.hashCode()
    }

    def "Request with different values should not be equal"() {
        given:
        def request1 = new Request()
        request1.url = "https://test1.api.com"

        def request2 = new Request()
        request2.url = "https://test2.api.com"

        expect:
        request1 != request2
    }
}
