package com.xiaoju.open.sdk.didies.core.request

import spock.lang.Specification
import spock.lang.Unroll

class HeadersTest extends Specification {

    def "Headers should initialize with empty map"() {
        when:
        def headers = new Headers()

        then:
        headers.headers != null
        headers.headers.isEmpty()
    }

    def "Headers should set and get headers map"() {
        given:
        def headers = new Headers()
        def headerMap = ["Authorization": ["Bearer token"], "Content-Type": ["application/json"]]

        when:
        headers.headers = headerMap

        then:
        headers.headers == headerMap
        headers.headers["Authorization"] == ["Bearer token"]
        headers.headers["Content-Type"] == ["application/json"]
    }

    def "Headers should get Content-Type when present"() {
        given:
        def headers = new Headers()
        headers.headers = ["Content-Type": ["application/json"]]

        when:
        def contentType = headers.getContentType()

        then:
        contentType == "application/json"
    }

    def "Headers should get first Content-Type value when multiple present"() {
        given:
        def headers = new Headers()
        headers.headers = ["Content-Type": ["application/json", "text/html"]]

        when:
        def contentType = headers.getContentType()

        then:
        contentType == "application/json"
    }

    def "Headers should return null when Content-Type not present"() {
        given:
        def headers = new Headers()
        headers.headers = ["Authorization": ["Bearer token"]]

        when:
        def contentType = headers.getContentType()

        then:
        contentType == null
    }

    def "Headers should return null when headers map is empty"() {
        given:
        def headers = new Headers()

        when:
        def contentType = headers.getContentType()

        then:
        contentType == null
    }

    def "Headers should return null when Content-Type value list is empty"() {
        given:
        def headers = new Headers()
        headers.headers = ["Content-Type": []]

        when:
        def contentType = headers.getContentType()

        then:
        contentType == null
    }

    def "Headers should return null when Content-Type value list contains null"() {
        given:
        def headers = new Headers()
        headers.headers = ["Content-Type": [null]]

        when:
        def contentType = headers.getContentType()

        then:
        contentType == null
    }

    def "Headers should handle case-sensitive Content-Type"() {
        given:
        def headers = new Headers()

        when:
        headers.headers = ["Content-Type": ["application/json"]]
        def contentType1 = headers.getContentType()

        then:
        contentType1 == "application/json"

        when:
        headers.headers = ["content-type": ["text/html"]]
        def contentType2 = headers.getContentType()

        then:
        contentType2 == null // Case-sensitive, so this won't match
    }

    def "Headers should handle multiple values for same header"() {
        given:
        def headers = new Headers()
        headers.headers = ["X-Custom": ["value1", "value2", "value3"]]

        expect:
        headers.headers["X-Custom"].size() == 3
        headers.headers["X-Custom"][0] == "value1"
        headers.headers["X-Custom"][1] == "value2"
        headers.headers["X-Custom"][2] == "value3"
    }

    def "Headers should handle setting multiple headers"() {
        given:
        def headers = new Headers()

        when:
        headers.headers = [
                "Authorization": ["Bearer token123"],
                "Content-Type": ["application/json"],
                "Accept": ["application/json"],
                "User-Agent": ["TestClient/1.0"]
        ]

        then:
        headers.headers.size() == 4
        headers.headers["Authorization"] == ["Bearer token123"]
        headers.headers["Content-Type"] == ["application/json"]
        headers.headers["Accept"] == ["application/json"]
        headers.headers["User-Agent"] == ["TestClient/1.0"]
    }

    @Unroll
    def "Headers should handle various Content-Type values - #contentType"() {
        given:
        def headers = new Headers()

        when:
        headers.headers = ["Content-Type": [contentType]]

        then:
        headers.getContentType() == contentType

        where:
        contentType << [
                "application/json",
                "application/x-www-form-urlencoded",
                "text/html",
                "text/plain",
                "application/xml",
                "multipart/form-data"
        ]
    }

    def "Headers should handle empty string Content-Type"() {
        given:
        def headers = new Headers()
        headers.headers = ["Content-Type": [""]]

        when:
        def contentType = headers.getContentType()

        then:
        contentType == ""
    }

    def "Headers should allow modifying headers after creation"() {
        given:
        def headers = new Headers()
        headers.headers = ["Authorization": ["Bearer token1"]]

        when:
        headers.headers = ["Authorization": ["Bearer token2"]]

        then:
        headers.headers["Authorization"] == ["Bearer token2"]
    }

    def "Headers should allow adding to existing headers"() {
        given:
        def headers = new Headers()
        headers.headers = ["Header1": ["value1"]]

        when:
        headers.headers["Header2"] = ["value2"]

        then:
        headers.headers["Header1"] == ["value1"]
        headers.headers["Header2"] == ["value2"]
    }

    def "Headers should work with Lombok @Data annotation"() {
        given:
        def headers1 = new Headers()
        headers1.headers = ["Custom": ["value1"]]

        and:
        def headers2 = new Headers()
        headers2.headers = ["Custom": ["value1"]]

        expect:
        headers1.headers == headers2.headers
        headers1.getContentType() == headers2.getContentType()
    }

    def "Headers should work with Lombok @ToString annotation"() {
        given:
        def headers = new Headers()
        headers.headers = ["Custom": ["value"]]

        when:
        def str = headers.toString()

        then:
        str.contains("Headers")
        str.contains("headers")
    }

    def "Headers should handle special characters in header values"() {
        given:
        def headers = new Headers()
        headers.headers = [
                "X-Special": ["value with spaces"],
                "X-Unicode": ["中文"],
                "X-Emoji": ["😀"]
        ]

        expect:
        headers.headers["X-Special"] == ["value with spaces"]
        headers.headers["X-Unicode"] == ["中文"]
        headers.headers["X-Emoji"] == ["😀"]
    }

    def "Headers should handle null header value in list"() {
        given:
        def headers = new Headers()
        headers.headers = ["X-Mixed": ["value1", null, "value3"]]

        expect:
        headers.headers["X-Mixed"].size() == 3
        headers.headers["X-Mixed"][0] == "value1"
        headers.headers["X-Mixed"][1] == null
        headers.headers["X-Mixed"][2] == "value3"
    }

    def "Headers should handle replacing entire headers map"() {
        given:
        def headers = new Headers()
        headers.headers = ["Header1": ["value1"]]

        when:
        headers.headers = ["Header2": ["value2"]]

        then:
        headers.headers.size() == 1
        headers.headers["Header2"] == ["value2"]
        headers.headers["Header1"] == null
    }

    def "Headers should preserve header value order"() {
        given:
        def headers = new Headers()
        def values = ["value1", "value2", "value3"]
        headers.headers = ["X-Order": values]

        expect:
        headers.headers["X-Order"] == values
    }

    def "Headers should handle HTTP standard headers"() {
        given:
        def headers = new Headers()
        headers.headers = [
                "Accept": ["application/json"],
                "Accept-Encoding": ["gzip, deflate"],
                "Authorization": ["Bearer token"],
                "Cache-Control": ["no-cache"],
                "Connection": ["keep-alive"],
                "Content-Type": ["application/json"],
                "User-Agent": ["MyApp/1.0"]
        ]

        expect:
        headers.getContentType() == "application/json"
        headers.headers.size() == 7
    }

    def "Headers should be compatible with HashMap operations"() {
        given:
        def headers = new Headers()

        when:
        headers.headers.put("New-Header", ["new-value"])
        headers.headers.remove("New-Header")

        then:
        headers.headers["New-Header"] == null
    }
}
