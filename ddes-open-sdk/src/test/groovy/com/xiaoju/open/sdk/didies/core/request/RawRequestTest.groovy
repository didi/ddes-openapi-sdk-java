package com.xiaoju.open.sdk.didies.core.request

import spock.lang.Specification
import spock.lang.Unroll

class RawRequestTest extends Specification {

    def "RawRequest should extend Request"() {
        expect:
        new RawRequest() instanceof Request
    }

    def "RawRequest should have default values"() {
        when:
        def request = new RawRequest()

        then:
        request.body == null
        request.url == null
        request.params == null
        request.config == null
    }

    def "RawRequest should set and get body"() {
        given:
        def request = new RawRequest()

        when:
        request.body = '{"key": "value"}'

        then:
        request.body == '{"key": "value"}'
    }

    def "RawRequest should handle empty JSON body"() {
        given:
        def request = new RawRequest()

        when:
        request.body = '{}'

        then:
        request.body == '{}'
    }

    def "RawRequest should handle null body"() {
        given:
        def request = new RawRequest()

        when:
        request.body = null

        then:
        request.body == null
    }

    def "RawRequest should handle large body"() {
        given:
        def request = new RawRequest()
        def largeBody = '{"data": "' + 'x' * 10000 + '"}'

        when:
        request.body = largeBody

        then:
        request.body == largeBody
        request.body.length() > 10000
    }

    def "RawRequest should handle special characters in body"() {
        given:
        def request = new RawRequest()
        def specialBody = '{"message": "Hello\\nWorld\\t!", "emoji": "\uD83D\uDE00"}'

        when:
        request.body = specialBody

        then:
        request.body == specialBody
    }

    def "RawRequest should handle unicode in body"() {
        given:
        def request = new RawRequest()
        def unicodeBody = '{"text": "你好世界", "emoji": "😀"}'

        when:
        request.body = unicodeBody

        then:
        request.body == unicodeBody
    }

    @Unroll
    def "RawRequest should handle various JSON bodies - #description"() {
        given:
        def request = new RawRequest()

        when:
        request.body = jsonBody

        then:
        request.body == jsonBody

        where:
        description              | jsonBody
        "simple object"          | '{"name": "test"}'
        "nested object"          | '{"user": {"name": "test", "age": 30}}'
        "array"                  | '{"items": [1, 2, 3]}'
        "mixed"                  | '{"name": "test", "values": [1, 2, 3], "nested": {"key": "value"}}'
        "empty string"           | ''
        "whitespace only"        | '   '
        "valid JSON with spaces" | '{ "key" : "value" }'
    }

    def "RawRequest should allow setting all properties including body"() {
        given:
        def request = new RawRequest()

        when:
        request.url = "https://test.api.com/test"
        request.params = [param: "value"]
        request.body = '{"request": "data"}'
        request.headers.headers = ["Content-Type": ["application/json"]]

        then:
        request.url == "https://test.api.com/test"
        request.params.param == "value"
        request.body == '{"request": "data"}'
        request.headers.headers["Content-Type"] == ["application/json"]
    }

    def "RawRequest should be modifiable after creation"() {
        given:
        def request = new RawRequest()
        request.body = '{"original": "data"}'

        when:
        request.body = '{"modified": "data"}'

        then:
        request.body == '{"modified": "data"}'
    }

    def "RawRequest should work with Lombok @Data annotation"() {
        given:
        def request1 = new RawRequest()
        request1.url = "https://test.api.com"
        request1.body = '{"test": "data"}'

        and:
        def request2 = new RawRequest()
        request2.url = "https://test.api.com"
        request2.body = '{"test": "data"}'

        expect:
        request1.url == request2.url
        request1.body == request2.body
    }

    def "RawRequest should work with Lombok @ToString annotation"() {
        given:
        def request = new RawRequest()
        request.body = '{"test": "data"}'

        when:
        def str = request.toString()

        then:
        str.contains("RawRequest")
        str.contains("body")
    }

    def "RawRequest should work with Lombok @EqualsAndHashCode annotation"() {
        given:
        def request1 = new RawRequest()
        request1.url = "https://test.api.com"
        request1.body = '{"test": "data"}'

        def request2 = new RawRequest()
        request2.url = "https://test.api.com"
        request2.body = '{"test": "data"}'

        expect:
        request1.equals(request2)
        request1.hashCode() == request2.hashCode()
    }

    def "RawRequest with different body should not be equal"() {
        given:
        def request1 = new RawRequest()
        request1.body = '{"body": "1"}'

        def request2 = new RawRequest()
        request2.body = '{"body": "2"}'

        expect:
        request1 != request2
    }

    def "RawRequest should inherit all Request properties"() {
        given:
        def request = new RawRequest()

        expect:
        request.hasProperty("url")
        request.hasProperty("params")
        request.hasProperty("config")
        request.hasProperty("headers")
        request.hasProperty("body")
    }

    def "RawRequest should handle body updates multiple times"() {
        given:
        def request = new RawRequest()
        request.body = '{"version": 1}'

        when:
        request.body = '{"version": 2}'

        then:
        request.body == '{"version": 2}'

        when:
        request.body = '{"version": 3}'

        then:
        request.body == '{"version": 3}'
    }
}
