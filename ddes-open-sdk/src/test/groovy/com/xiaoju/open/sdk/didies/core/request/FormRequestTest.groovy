package com.xiaoju.open.sdk.didies.core.request

import spock.lang.Specification
import spock.lang.Unroll

class FormRequestTest extends Specification {

    def "FormRequest should extend Request"() {
        expect:
        new FormRequest() instanceof Request
    }

    def "FormRequest should have default values"() {
        when:
        def request = new FormRequest()

        then:
        request.body == null
        request.url == null
        request.params == null
        request.config == null
    }

    def "FormRequest should set and get body"() {
        given:
        def request = new FormRequest()
        def body = [username: "john", password: "secret123"]

        when:
        request.body = body

        then:
        request.body == body
        request.body.username == "john"
        request.body.password == "secret123"
    }

    def "FormRequest should handle empty body map"() {
        given:
        def request = new FormRequest()
        def body = [:]

        when:
        request.body = body

        then:
        request.body.isEmpty()
    }

    def "FormRequest should handle null body"() {
        given:
        def request = new FormRequest()

        when:
        request.body = null

        then:
        request.body == null
    }

    def "FormRequest should handle body with string values"() {
        given:
        def request = new FormRequest()
        def body = [name: "John Doe", email: "john@example.com"]

        when:
        request.body = body

        then:
        request.body.name == "John Doe"
        request.body.email == "john@example.com"
    }

    def "FormRequest should handle body with numeric values"() {
        given:
        def request = new FormRequest()
        def body = [age: 30, price: 99.99, count: 100L]

        when:
        request.body = body

        then:
        request.body.age == 30
        request.body.price == 99.99
        request.body.count == 100L
    }

    def "FormRequest should handle body with collection values"() {
        given:
        def request = new FormRequest()
        def body = [tags: ["tag1", "tag2", "tag3"], ids: [1, 2, 3]]

        when:
        request.body = body

        then:
        request.body.tags == ["tag1", "tag2", "tag3"]
        request.body.ids == [1, 2, 3]
    }

    def "FormRequest should handle body with null values"() {
        given:
        def request = new FormRequest()
        def body = [key1: "value1", key2: null, key3: "value3"]

        when:
        request.body = body

        then:
        request.body.key1 == "value1"
        request.body.key2 == null
        request.body.key3 == "value3"
    }

    def "FormRequest should handle body with boolean values"() {
        given:
        def request = new FormRequest()
        def body = [active: true, deleted: false, verified: true]

        when:
        request.body = body

        then:
        request.body.active == true
        request.body.deleted == false
        request.body.verified == true
    }

    @Unroll
    def "FormRequest should handle various form data - #description"() {
        given:
        def request = new FormRequest()

        when:
        request.body = formData

        then:
        request.body == formData

        where:
        description            | formData
        "single field"         | [field1: "value1"]
        "multiple fields"      | [field1: "value1", field2: "value2", field3: "value3"]
        "with numbers"         | [count: "10", price: "99.99"]
        "with special chars"   | [email: "test@example.com", phone: "+1-234-567-8900"]
        "with unicode"         | [name: "张三", emoji: "😀"]
        "empty values"         | [field1: "", field2: "value"]
        "mixed types"          | [name: "test", age: 30, active: true]
    }

    def "FormRequest should allow setting all properties including body"() {
        given:
        def request = new FormRequest()

        when:
        request.url = "https://test.api.com/submit"
        request.params = [param: "value"]
        request.body = [username: "john", password: "secret"]
        request.headers.headers = ["Content-Type": ["application/x-www-form-urlencoded"]]

        then:
        request.url == "https://test.api.com/submit"
        request.params.param == "value"
        request.body.username == "john"
        request.body.password == "secret"
        request.headers.headers["Content-Type"] == ["application/x-www-form-urlencoded"]
    }

    def "FormRequest should be modifiable after creation"() {
        given:
        def request = new FormRequest()
        request.body = [field1: "value1"]

        when:
        request.body = [field2: "value2"]

        then:
        request.body.field2 == "value2"
        request.body.field1 == null
    }

    def "FormRequest should work with Lombok @Data annotation"() {
        given:
        def request1 = new FormRequest()
        request1.url = "https://test.api.com"
        request1.body = [field: "value"]

        and:
        def request2 = new FormRequest()
        request2.url = "https://test.api.com"
        request2.body = [field: "value"]

        expect:
        request1.url == request2.url
        request1.body == request2.body
    }

    def "FormRequest should work with Lombok @ToString annotation"() {
        given:
        def request = new FormRequest()
        request.body = [field: "value"]

        when:
        def str = request.toString()

        then:
        str.contains("FormRequest")
        str.contains("body")
    }

    def "FormRequest should work with Lombok @EqualsAndHashCode annotation"() {
        given:
        def request1 = new FormRequest()
        request1.url = "https://test.api.com"
        request1.body = [field: "value"]

        def request2 = new FormRequest()
        request2.url = "https://test.api.com"
        request2.body = [field: "value"]

        expect:
        request1.equals(request2)
        request1.hashCode() == request2.hashCode()
    }

    def "FormRequest with different body should not be equal"() {
        given:
        def request1 = new FormRequest()
        request1.body = [field: "value1"]

        def request2 = new FormRequest()
        request2.body = [field: "value2"]

        expect:
        request1 != request2
    }

    def "FormRequest should inherit all Request properties"() {
        given:
        def request = new FormRequest()

        expect:
        request.hasProperty("url")
        request.hasProperty("params")
        request.hasProperty("config")
        request.hasProperty("headers")
        request.hasProperty("body")
    }

    def "FormRequest should handle body updates multiple times"() {
        given:
        def request = new FormRequest()
        request.body = [version: "1"]

        when:
        request.body = [version: "2"]

        then:
        request.body.version == "2"

        when:
        request.body = [version: "3"]

        then:
        request.body.version == "3"
    }

    def "FormRequest should handle complex nested structures in body"() {
        given:
        def request = new FormRequest()
        def body = [
                user_id: "12345",
                username: "john_doe",
                tags: ["developer", "admin", "active"],
                metadata: ["key1": "value1", "key2": "value2"]
        ]

        when:
        request.body = body

        then:
        request.body.user_id == "12345"
        request.body.username == "john_doe"
        request.body.tags.size() == 3
    }

    def "FormRequest should handle URL-encoded content"() {
        given:
        def request = new FormRequest()
        def body = [
                query: "hello world",
                email: "user+tag@example.com",
                special: "a&b=c"
        ]

        when:
        request.body = body

        then:
        request.body.query == "hello world"
        request.body.email == "user+tag@example.com"
        request.body.special == "a&b=c"
    }

    def "FormRequest should handle large number of fields"() {
        given:
        def request = new FormRequest()
        def body = [:]
        for (int i = 0; i < 100; i++) {
            body["field${i}"] = "value${i}"
        }

        when:
        request.body = body

        then:
        request.body.size() == 100
        request.body.field0 == "value0"
        request.body.field99 == "value99"
    }
}
