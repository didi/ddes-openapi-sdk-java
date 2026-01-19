package com.xiaoju.open.sdk.didies.core.model

import spock.lang.Specification

class BaseRespTest extends Specification {

    def "BaseResp should create instance with builder"() {
        when:
        def resp = BaseResp.builder()
                .errno(0)
                .errmsg("success")
                .encryptData("encrypted")
                .requestId("req-123")
                .build()

        then:
        resp != null
        resp.errno == 0
        resp.errmsg == "success"
        resp.encryptData == "encrypted"
        resp.requestId == "req-123"
    }

    def "BaseResp should create instance with no-args constructor"() {
        when:
        def resp = new BaseResp()

        then:
        resp != null
        resp.errno == null
        resp.errmsg == null
        resp.encryptData == null
        resp.requestId == null
    }

    def "BaseResp should create instance with all-args constructor"() {
        when:
        def resp = new BaseResp(401, "unauthorized", "data", "req-456")

        then:
        resp != null
        resp.errno == 401
        resp.errmsg == "unauthorized"
        resp.encryptData == "data"
        resp.requestId == "req-456"
    }

    def "BaseResp should have working getters and setters"() {
        given:
        def resp = new BaseResp()

        when:
        resp.setErrno(500)
        resp.setErrmsg("server error")
        resp.setEncryptData("secret")
        resp.setRequestId("req-789")

        then:
        resp.getErrno() == 500
        resp.getErrmsg() == "server error"
        resp.getEncryptData() == "secret"
        resp.getRequestId() == "req-789"
    }

    def "BaseResp should handle null values"() {
        when:
        def resp = BaseResp.builder()
                .errno(null)
                .errmsg(null)
                .encryptData(null)
                .requestId(null)
                .build()

        then:
        resp != null
        resp.errno == null
        resp.errmsg == null
        resp.encryptData == null
        resp.requestId == null
    }

    def "BaseResp should handle zero errno"() {
        when:
        def resp = BaseResp.builder()
                .errno(0)
                .build()

        then:
        resp.errno == 0
    }

    def "BaseResp should handle negative errno"() {
        when:
        def resp = BaseResp.builder()
                .errno(-1)
                .build()

        then:
        resp.errno == -1
    }

    def "BaseResp should handle empty strings"() {
        when:
        def resp = BaseResp.builder()
                .errmsg("")
                .encryptData("")
                .requestId("")
                .build()

        then:
        resp.errmsg == ""
        resp.encryptData == ""
        resp.requestId == ""
    }

    def "BaseResp equals should work correctly"() {
        given:
        def resp1 = BaseResp.builder().errno(0).errmsg("test").build()
        def resp2 = BaseResp.builder().errno(0).errmsg("test").build()
        def resp3 = BaseResp.builder().errno(1).errmsg("test").build()

        expect:
        resp1 == resp2
        resp1 != resp3
        resp1.hashCode() == resp2.hashCode()
    }

    def "BaseResp toString should contain field values"() {
        given:
        def resp = BaseResp.builder()
                .errno(200)
                .errmsg("OK")
                .requestId("123")
                .build()

        when:
        def str = resp.toString()

        then:
        str != null
        str.contains("200") || str.contains("OK") || str.contains("123")
    }

    def "BaseResp should support canEqual method"() {
        given:
        def resp = BaseResp.builder().errno(0).build()
        def other = BaseResp.builder().errno(0).build()

        expect:
        resp.canEqual(other)
        other.canEqual(resp)
    }

    def "BaseResp builder should be reusable"() {
        given:
        def builder = BaseResp.builder()
                .errmsg("error")

        when:
        def resp1 = builder.errno(400).build()
        def resp2 = builder.errno(500).build()

        then:
        resp1.errno == 400
        resp1.errmsg == "error"
        resp2.errno == 500
        resp2.errmsg == "error"
    }

    def "BaseResp should handle special characters in errmsg"() {
        when:
        def resp = BaseResp.builder()
                .errmsg("错误信息 \"quoted\" and \n new line")
                .build()

        then:
        resp.errmsg.contains("错误信息")
    }

    def "BaseResp should handle long requestId"() {
        given:
        def longId = "req-" + "a" * 100

        when:
        def resp = BaseResp.builder()
                .requestId(longId)
                .build()

        then:
        resp.requestId == longId
    }

    def "BaseResp should handle unicode in errmsg"() {
        when:
        def resp = BaseResp.builder()
                .errmsg("测试中文🎉")
                .build()

        then:
        resp.errmsg == "测试中文🎉"
    }
}
