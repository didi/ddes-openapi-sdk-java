package com.xiaoju.open.sdk.didies.core.request

import spock.lang.Specification
import spock.lang.Unroll

class RawResponseTest extends Specification {

    def "RawResponse should extend Headers"() {
        expect:
        new RawResponse() instanceof Headers
    }

    def "RawResponse should have default values"() {
        when:
        def response = new RawResponse()

        then:
        response.statusCode == 0
        response.body == null
        response.headers != null
        response.headers.isEmpty()
    }

    def "RawResponse should set and get statusCode"() {
        given:
        def response = new RawResponse()

        when:
        response.statusCode = 200

        then:
        response.statusCode == 200
    }

    def "RawResponse should set and get body"() {
        given:
        def response = new RawResponse()

        when:
        response.body = '{"result": "success"}'

        then:
        response.body == '{"result": "success"}'
    }

    def "RawResponse should inherit headers from Headers"() {
        given:
        def response = new RawResponse()

        when:
        response.headers = ["Content-Type": ["application/json"], "Content-Length": ["123"]]

        then:
        response.headers["Content-Type"] == ["application/json"]
        response.headers["Content-Length"] == ["123"]
    }

    def "RawResponse should get Content-Type through inheritance"() {
        given:
        def response = new RawResponse()
        response.headers = ["Content-Type": ["application/json"]]

        when:
        def contentType = response.getContentType()

        then:
        contentType == "application/json"
    }

    @Unroll
    def "RawResponse should handle various HTTP status codes - #code #description"() {
        given:
        def response = new RawResponse()

        when:
        response.statusCode = code

        then:
        response.statusCode == code

        where:
        code | description
        100  | "Continue"
        200  | "OK"
        201  | "Created"
        204  | "No Content"
        301  | "Moved Permanently"
        302  | "Found"
        304  | "Not Modified"
        400  | "Bad Request"
        401  | "Unauthorized"
        403  | "Forbidden"
        404  | "Not Found"
        500  | "Internal Server Error"
        502  | "Bad Gateway"
        503  | "Service Unavailable"
        504  | "Gateway Timeout"
    }

    def "RawResponse should handle empty JSON body"() {
        given:
        def response = new RawResponse()

        when:
        response.body = '{}'

        then:
        response.body == '{}'
    }

    def "RawResponse should handle null body"() {
        given:
        def response = new RawResponse()

        when:
        response.body = null

        then:
        response.body == null
    }

    def "RawResponse should handle large body"() {
        given:
        def response = new RawResponse()
        def largeBody = '{"data": "' + 'x' * 10000 + '"}'

        when:
        response.body = largeBody

        then:
        response.body == largeBody
        response.body.length() > 10000
    }

    def "RawResponse should handle unicode in body"() {
        given:
        def response = new RawResponse()
        def unicodeBody = '{"message": "你好世界", "emoji": "😀🎉"}'

        when:
        response.body = unicodeBody

        then:
        response.body == unicodeBody
    }

    @Unroll
    def "RawResponse should handle various response bodies - #description"() {
        given:
        def response = new RawResponse()

        when:
        response.body = responseBody

        then:
        response.body == responseBody

        where:
        description          | responseBody
        "simple JSON"        | '{"status": "ok"}'
        "complex JSON"       | '{"user": {"name": "test", "age": 30}, "items": [1, 2, 3]}'
        "HTML response"      | '<html><body>Hello</body></html>'
        "XML response"       | '<?xml version="1.0"?><root>test</root>'
        "plain text"         | 'This is plain text'
        "empty string"       | ''
        "whitespace"         | '   '
        "newlines"           | 'line1\nline2\nline3'
    }

    def "RawResponse should allow setting all properties"() {
        given:
        def response = new RawResponse()

        when:
        response.statusCode = 201
        response.body = '{"created": true}'
        response.headers = [
                "Content-Type": ["application/json"],
                "Content-Length": ["18"],
                "Location": ["/resource/123"]
        ]

        then:
        response.statusCode == 201
        response.body == '{"created": true}'
        response.headers["Content-Type"] == ["application/json"]
        response.headers["Content-Length"] == ["18"]
        response.headers["Location"] == ["/resource/123"]
    }

    def "RawResponse should be modifiable after creation"() {
        given:
        def response = new RawResponse()
        response.statusCode = 200
        response.body = '{"status": "ok"}'

        when:
        response.statusCode = 404
        response.body = '{"error": "not found"}'

        then:
        response.statusCode == 404
        response.body == '{"error": "not found"}'
    }

    def "RawResponse should work with Lombok @Data annotation"() {
        given:
        def response1 = new RawResponse()
        response1.statusCode = 200
        response1.body = '{"test": "data"}'

        and:
        def response2 = new RawResponse()
        response2.statusCode = 200
        response2.body = '{"test": "data"}'

        expect:
        response1.statusCode == response2.statusCode
        response1.body == response2.body
    }

    def "RawResponse should work with Lombok @ToString annotation"() {
        given:
        def response = new RawResponse()
        response.statusCode = 200
        response.body = '{"test": "data"}'

        when:
        def str = response.toString()

        then:
        str.contains("RawResponse")
        str.contains("statusCode")
        str.contains("body")
    }

    def "RawResponse should work with Lombok @EqualsAndHashCode annotation"() {
        given:
        def response1 = new RawResponse()
        response1.statusCode = 200
        response1.body = '{"test": "data"}'

        def response2 = new RawResponse()
        response2.statusCode = 200
        response2.body = '{"test": "data"}'

        expect:
        response1.equals(response2)
        response1.hashCode() == response2.hashCode()
    }

    def "RawResponse with different values should not be equal"() {
        given:
        def response1 = new RawResponse()
        response1.statusCode = 200
        response1.body = '{"data": "1"}'

        def response2 = new RawResponse()
        response2.statusCode = 404
        response2.body = '{"data": "2"}'

        expect:
        response1 != response2
    }

    def "RawResponse should inherit all Headers properties"() {
        given:
        def response = new RawResponse()

        expect:
        response.hasProperty("headers")
        response.hasProperty("statusCode")
        response.hasProperty("body")
    }

    def "RawResponse should handle response with multiple headers"() {
        given:
        def response = new RawResponse()
        response.statusCode = 200
        response.body = '{"success": true}'
        response.headers = [
                "Content-Type": ["application/json"],
                "Cache-Control": ["no-cache", "no-store"],
                "Set-Cookie": ["session=abc123", "token=xyz789"]
        ]

        expect:
        response.statusCode == 200
        response.body == '{"success": true}'
        response.headers["Cache-Control"].size() == 2
        response.headers["Set-Cookie"].size() == 2
    }

    def "RawResponse should handle typical success response"() {
        given:
        def response = new RawResponse()

        when:
        response.statusCode = 200
        response.body = '{"errno": 0, "errmsg": "success", "data": {"id": "123"}}'
        response.headers = ["Content-Type": ["application/json"]]

        then:
        response.statusCode == 200
        response.body.contains('"errno": 0')
        response.body.contains('"errmsg": "success"')
        response.getContentType() == "application/json"
    }

    def "RawResponse should handle typical error response"() {
        given:
        def response = new RawResponse()

        when:
        response.statusCode = 401
        response.body = '{"errno": 401, "errmsg": "unauthorized", "request_id": "abc123"}'
        response.headers = ["Content-Type": ["application/json"], "WWW-Authenticate": ["Bearer"]]

        then:
        response.statusCode == 401
        response.body.contains('"errno": 401')
        response.body.contains('"errmsg": "unauthorized"')
        response.getContentType() == "application/json"
    }

    def "RawResponse should handle special characters in body"() {
        given:
        def response = new RawResponse()
        def specialBody = '{"message": "Hello\\nWorld\\t!", "quote": "He said \\"hello\\""}'

        when:
        response.body = specialBody

        then:
        response.body == specialBody
        response.body.contains("\\n")
        response.body.contains("\\t")
        response.body.contains('\\"')
    }

    def "RawResponse should handle body updates multiple times"() {
        given:
        def response = new RawResponse()
        response.body = '{"version": 1}'

        when:
        response.body = '{"version": 2}'

        then:
        response.body == '{"version": 2}'

        when:
        response.body = '{"version": 3}'

        then:
        response.body == '{"version": 3}'
    }

    def "RawResponse should handle statusCode 0 as default"() {
        given:
        def response = new RawResponse()

        expect:
        response.statusCode == 0
    }

    def "RawResponse should handle negative status codes"() {
        given:
        def response = new RawResponse()

        when:
        response.statusCode = -1

        then:
        response.statusCode == -1
    }
}
