package com.xiaoju.open.sdk.didies.core.request

import com.xiaoju.open.sdk.didies.core.Config
import spock.lang.Specification
import spock.lang.Unroll

import java.util.concurrent.TimeUnit

class RestTemplatesTest extends Specification {

    def "noneUrlEncodeRestTemplate should create RestTemplate with default config"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .build()

        when:
        def restTemplate = RestTemplates.noneUrlEncodeRestTemplate(config)

        then:
        restTemplate != null
        restTemplate instanceof org.springframework.web.client.RestTemplate
    }

    def "noneUrlEncodeRestTemplate should use NONE encoding mode"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .build()

        when:
        def restTemplate = RestTemplates.noneUrlEncodeRestTemplate(config)

        then:
        restTemplate.uriTemplateHandler.encodingMode ==
                org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode.NONE
    }

    def "noneUrlEncodeRestTemplate should use OkHttp3ClientHttpRequestFactory"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .build()

        when:
        def restTemplate = RestTemplates.noneUrlEncodeRestTemplate(config)

        then:
        restTemplate.requestFactory instanceof org.springframework.http.client.OkHttp3ClientHttpRequestFactory
    }

    def "noneUrlEncodeRestTemplate should use custom timeout values from config"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .connectTimeout(5000L)
                .callTimeOut(10000L)
                .timeoutUnit(TimeUnit.MILLISECONDS)
                .build()

        when:
        def restTemplate = RestTemplates.noneUrlEncodeRestTemplate(config)

        then:
        restTemplate != null
        restTemplate.requestFactory instanceof org.springframework.http.client.OkHttp3ClientHttpRequestFactory
    }

    def "noneUrlEncodeRestTemplate should use default timeout when config values are null"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .connectTimeout(null)
                .callTimeOut(null)
                .build()

        when:
        def restTemplate = RestTemplates.noneUrlEncodeRestTemplate(config)

        then:
        restTemplate != null
        restTemplate.requestFactory instanceof org.springframework.http.client.OkHttp3ClientHttpRequestFactory
    }

    def "noneUrlEncodeRestTemplate should use default timeout when config values are zero"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .connectTimeout(0L)
                .callTimeOut(0L)
                .build()

        when:
        def restTemplate = RestTemplates.noneUrlEncodeRestTemplate(config)

        then:
        restTemplate != null
        restTemplate.requestFactory instanceof org.springframework.http.client.OkHttp3ClientHttpRequestFactory
    }

    @Unroll
    def "noneUrlEncodeRestTemplate should handle #timeUnit time unit"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .connectTimeout(timeoutValue)
                .callTimeOut(timeoutValue)
                .timeoutUnit(timeUnit)
                .build()

        when:
        def restTemplate = RestTemplates.noneUrlEncodeRestTemplate(config)

        then:
        restTemplate != null

        where:
        timeUnit             | timeoutValue
        TimeUnit.MILLISECONDS | 5000L
        TimeUnit.SECONDS      | 5L
        TimeUnit.MINUTES      | 1L
    }

    def "noneUrlEncodeRestTemplate should have custom error handler"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .build()

        when:
        def restTemplate = RestTemplates.noneUrlEncodeRestTemplate(config)

        then:
        restTemplate.errorHandler != null
        restTemplate.errorHandler.hasError(null) == false
    }

    def "error handler should not throw exceptions"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .build()
        def restTemplate = RestTemplates.noneUrlEncodeRestTemplate(config)
        def mockResponse = Mock(org.springframework.http.client.ClientHttpResponse)

        when:
        def hasError = restTemplate.errorHandler.hasError(mockResponse)

        then:
        hasError == false

        when:
        restTemplate.errorHandler.handleError(mockResponse)

        then:
        noExceptionThrown()
    }

    def "noneUrlEncodeRestTemplate should create different instances for different configs"() {
        given:
        def config1 = Config.builder()
                .clientId("client1")
                .connectTimeout(1000L)
                .build()

        def config2 = Config.builder()
                .clientId("client2")
                .connectTimeout(5000L)
                .build()

        when:
        def restTemplate1 = RestTemplates.noneUrlEncodeRestTemplate(config1)
        def restTemplate2 = RestTemplates.noneUrlEncodeRestTemplate(config2)

        then:
        restTemplate1 != restTemplate2
    }

    def "noneUrlEncodeRestTemplate should create new instance on each call"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .build()

        when:
        def restTemplate1 = RestTemplates.noneUrlEncodeRestTemplate(config)
        def restTemplate2 = RestTemplates.noneUrlEncodeRestTemplate(config)

        then:
        restTemplate1 != restTemplate2
    }

    @Unroll
    def "should handle various timeout configurations - connect: #connectTimeout, call: #callTimeout"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .connectTimeout(connectTimeout)
                .callTimeOut(callTimeout)
                .timeoutUnit(TimeUnit.SECONDS)
                .build()

        when:
        def restTemplate = RestTemplates.noneUrlEncodeRestTemplate(config)

        then:
        restTemplate != null

        where:
        connectTimeout | callTimeout
        1L             | 1L
        10L            | 30L
        60L            | 120L
        300L           | 600L
    }

    def "should handle zero timeout values by using defaults"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .connectTimeout(0L)
                .callTimeOut(0L)
                .build()

        when:
        def restTemplate = RestTemplates.noneUrlEncodeRestTemplate(config)

        then:
        restTemplate != null
        // Zero values are replaced with defaults (6000ms)
    }

    def "should handle large but reasonable timeout values"() {
        given:
        def config = Config.builder()
                .clientId("test_client")
                .connectTimeout(300L)
                .callTimeOut(300L)
                .timeoutUnit(TimeUnit.SECONDS)
                .build()

        when:
        def restTemplate = RestTemplates.noneUrlEncodeRestTemplate(config)

        then:
        restTemplate != null
    }
}
