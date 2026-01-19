package com.xiaoju.open.sdk.didies.utils

import spock.lang.Specification
import spock.lang.Unroll

class JacksonUtilsTest extends Specification {

    static class TestModel {
        String name
        Integer age
        Boolean active
        List<String> tags
        Map<String, Object> metadata

        @Override
        boolean equals(o) {
            if (this.is(o)) return true
            if (getClass() != o.class) return false
            TestModel testModel = (TestModel) o
            if (active != testModel.active) return false
            if (age != testModel.age) return false
            if (metadata != testModel.metadata) return false
            if (name != testModel.name) return false
            if (tags != testModel.tags) return false
            return true
        }

        @Override
        int hashCode() {
            int result
            result = (name != null ? name.hashCode() : 0)
            result = 31 * result + (age != null ? age.hashCode() : 0)
            result = 31 * result + (active != null ? active.hashCode() : 0)
            result = 31 * result + (tags != null ? tags.hashCode() : 0)
            result = 31 * result + (metadata != null ? metadata.hashCode() : 0)
            return result
        }
    }

    def "toJson should serialize object to JSON"() {
        given:
        def model = new TestModel(
                name: "John",
                age: 30,
                active: true,
                tags: ["tag1", "tag2"]
        )

        when:
        def json = JacksonUtils.toJson(model)

        then:
        json != null
        json.contains('"name":"John"')
        json.contains('"age":30')
        json.contains('"active":true')
        json.contains('"tags":["tag1","tag2"]')
    }

    def "toJson should exclude null values"() {
        given:
        def model = new TestModel(
                name: "John",
                age: null,
                active: true
        )

        when:
        def json = JacksonUtils.toJson(model)

        then:
        json != null
        json.contains('"name":"John"')
        json.contains('"active":true')
        !json.contains('"age"')
    }

    def "toJsonWithNull should include null values"() {
        given:
        def model = new TestModel(
                name: "John",
                age: null,
                active: true
        )

        when:
        def json = JacksonUtils.toJsonWithNull(model)

        then:
        json != null
        json.contains('"name":"John"')
        json.contains('"active":true')
        json.contains('"age":null')
    }

    def "toObj should deserialize JSON to object"() {
        given:
        def json = '{"name":"John","age":30,"active":true}'

        when:
        def model = JacksonUtils.toObj(json, TestModel)

        then:
        model != null
        model.name == "John"
        model.age == 30
        model.active == true
    }

    def "toObj should handle complex objects"() {
        given:
        def json = '''{"name":"John","age":30,"active":true,"tags":["tag1","tag2"],
                      "metadata":{"key1":"value1","key2":123}}'''

        when:
        def model = JacksonUtils.toObj(json, TestModel)

        then:
        model != null
        model.name == "John"
        model.tags.size() == 2
        model.tags[0] == "tag1"
        model.metadata["key1"] == "value1"
    }

    def "toJson and toObj should be symmetric"() {
        given:
        def originalModel = new TestModel(
                name: "Alice",
                age: 25,
                active: false,
                tags: ["a", "b", "c"],
                metadata: [key: "value"]
        )

        when:
        def json = JacksonUtils.toJson(originalModel)
        def deserializedModel = JacksonUtils.toObj(json, TestModel)

        then:
        deserializedModel == originalModel
    }

    def "parseList should deserialize JSON array to List"() {
        given:
        def json = '[{"name":"John","age":30},{"name":"Alice","age":25}]'

        when:
        def list = JacksonUtils.parseList(json, TestModel)

        then:
        list != null
        list.size() == 2
        list[0].name == "John"
        list[0].age == 30
        list[1].name == "Alice"
        list[1].age == 25
    }

    def "parseList should handle empty array"() {
        given:
        def json = '[]'

        when:
        def list = JacksonUtils.parseList(json, TestModel)

        then:
        list != null
        list.isEmpty()
    }

    def "parseList should handle string arrays"() {
        given:
        def json = '["a","b","c"]'

        when:
        def list = JacksonUtils.parseList(json, String)

        then:
        list != null
        list.size() == 3
        list[0] == "a"
        list[1] == "b"
        list[2] == "c"
    }

    def "parseSet should deserialize JSON array to Set"() {
        given:
        def json = '[{"name":"John","age":30},{"name":"Alice","age":25}]'

        when:
        def set = JacksonUtils.parseSet(json, TestModel)

        then:
        set != null
        set.size() == 2
    }

    def "parseMap should deserialize JSON object to Map"() {
        given:
        def json = '{"key1":{"name":"John","age":30},"key2":{"name":"Alice","age":25}}'

        when:
        def map = JacksonUtils.parseMap(json, TestModel)

        then:
        map != null
        map.size() == 2
        map["key1"].name == "John"
        map["key1"].age == 30
        map["key2"].name == "Alice"
        map["key2"].age == 25
    }

    def "parseMap should handle string values"() {
        given:
        def json = '{"key1":"value1","key2":"value2"}'

        when:
        def map = JacksonUtils.parseMap(json, String)

        then:
        map != null
        map.size() == 2
        map["key1"] == "value1"
        map["key2"] == "value2"
    }

    def "getObjectMapper should return non-null ObjectMapper"() {
        when:
        def mapper = JacksonUtils.getObjectMapper()

        then:
        mapper != null
    }

    @Unroll
    def "toJson should handle primitives"() {
        expect:
        JacksonUtils.toJson(value) == expectedJson

        where:
        value   || expectedJson
        "test"  || '"test"'
        123     || '123'
        true    || 'true'
        false   || 'false'
        null    || 'null'
    }

    def "toObj should handle primitives"() {
        expect:
        JacksonUtils.toObj(json, type) == expectedValue

        where:
        json         | type       || expectedValue
        '"test"'     | String     || "test"
        '123'        | Integer    || 123
        'true'       | Boolean    || true
        'false'      | Boolean    || false
    }

    def "should handle special characters in JSON"() {
        given:
        def model = new TestModel(name: 'Test "quoted" and \n new line')

        when:
        def json = JacksonUtils.toJson(model)
        def deserialized = JacksonUtils.toObj(json, TestModel)

        then:
        deserialized.name == model.name
    }

    def "should handle unicode characters"() {
        given:
        def model = new TestModel(name: "测试中文")

        when:
        def json = JacksonUtils.toJson(model)
        def deserialized = JacksonUtils.toObj(json, TestModel)

        then:
        deserialized.name == "测试中文"
    }

    def "should handle nested objects"() {
        given:
        def json = '''{"name":"John","metadata":{"nested":{"key":"value"}}}'''

        when:
        def model = JacksonUtils.toObj(json, TestModel)

        then:
        model != null
        model.metadata["nested"]["key"] == "value"
    }
}
