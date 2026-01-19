package com.xiaoju.open.sdk.didies.utils

import com.xiaoju.open.sdk.didies.core.exception.DataDecryptException
import com.xiaoju.open.sdk.didies.core.exception.DataEncryptException
import spock.lang.Specification
import spock.lang.Unroll

class AES256UtilsTest extends Specification {

    // AES-256 requires a 64-character hex key (32 bytes)
    static final String VALID_HEX_KEY = "1234567890abcdef1234567890abcdef1234567890abcdef1234567890abcdef"

    def "encrypt should encrypt data with valid hex key"() {
        given:
        def data = "Hello World"

        when:
        def encrypted = AES256Utils.encrypt(data, VALID_HEX_KEY)

        then:
        encrypted != null
        encrypted != data
        !encrypted.contains(data)
        encrypted.length() > 0
    }

    def "decrypt should decrypt encrypted data"() {
        given:
        def original = "Test message for encryption 123!@#"

        when:
        def encrypted = AES256Utils.encrypt(original, VALID_HEX_KEY)
        def decrypted = AES256Utils.decrypt(encrypted, VALID_HEX_KEY)

        then:
        decrypted == original
    }

    def "encrypt and decrypt should be symmetric"() {
        given:
        def original = "测试中文数据"

        when:
        def encrypted = AES256Utils.encrypt(original, VALID_HEX_KEY)
        def decrypted = AES256Utils.decrypt(encrypted, VALID_HEX_KEY)

        then:
        decrypted == original
    }

    def "encrypt should produce same ciphertext for same plaintext (ECB mode)"() {
        given:
        def original = "Same message"

        when:
        def encrypted1 = AES256Utils.encrypt(original, VALID_HEX_KEY)
        def encrypted2 = AES256Utils.encrypt(original, VALID_HEX_KEY)

        then:
        encrypted1 == encrypted2
    }

    def "encrypt should throw exception for invalid key length"() {
        when:
        AES256Utils.encrypt("test", "short_key")

        then:
        thrown(DataEncryptException)
    }

    def "decrypt should throw exception for invalid key length"() {
        when:
        AES256Utils.decrypt("encrypted_data", "short_key")

        then:
        thrown(DataDecryptException)
    }

    def "decrypt with wrong key should throw exception"() {
        given:
        def original = "Secret Message"
        def encrypted = AES256Utils.encrypt(original, VALID_HEX_KEY)
        def wrongKey = "fedcba0987654321fedcba0987654321fedcba0987654321fedcba0987654321"

        when:
        AES256Utils.decrypt(encrypted, wrongKey)

        then:
        thrown(DataDecryptException)
    }

    def "decrypt with invalid base64 should throw exception"() {
        when:
        AES256Utils.decrypt("invalid_base64!", VALID_HEX_KEY)

        then:
        thrown(DataDecryptException)
    }

    def "encrypt should handle empty strings"() {
        given:
        def original = ""

        when:
        def encrypted = AES256Utils.encrypt(original, VALID_HEX_KEY)
        def decrypted = AES256Utils.decrypt(encrypted, VALID_HEX_KEY)

        then:
        decrypted == original
    }

    def "encrypt and decrypt should handle unicode characters"() {
        given:
        def original = "测试中文🎉😀"

        when:
        def encrypted = AES256Utils.encrypt(original, VALID_HEX_KEY)
        def decrypted = AES256Utils.decrypt(encrypted, VALID_HEX_KEY)

        then:
        decrypted == original
    }

    def "should handle long text"() {
        given:
        def original = "a" * 10000

        when:
        def encrypted = AES256Utils.encrypt(original, VALID_HEX_KEY)
        def decrypted = AES256Utils.decrypt(encrypted, VALID_HEX_KEY)

        then:
        decrypted == original
    }

    def "encrypt should throw exception for null input"() {
        when:
        AES256Utils.encrypt(null, VALID_HEX_KEY)

        then:
        thrown(DataEncryptException)
    }

    def "decrypt should throw exception for null input"() {
        when:
        AES256Utils.decrypt(null, VALID_HEX_KEY)

        then:
        thrown(DataDecryptException)
    }

    def "encrypt and decrypt should be consistent across multiple operations"() {
        given:
        def original = "Test data"

        when:
        def encrypted1 = AES256Utils.encrypt(original, VALID_HEX_KEY)
        def decrypted1 = AES256Utils.decrypt(encrypted1, VALID_HEX_KEY)

        def encrypted2 = AES256Utils.encrypt(decrypted1, VALID_HEX_KEY)
        def decrypted2 = AES256Utils.decrypt(encrypted2, VALID_HEX_KEY)

        then:
        decrypted1 == original
        decrypted2 == original
    }

    @Unroll
    def "should handle different string lengths"() {
        expect:
        def encrypted = AES256Utils.encrypt(text, VALID_HEX_KEY)
        def decrypted = AES256Utils.decrypt(encrypted, VALID_HEX_KEY)
        decrypted == text

        where:
        text << ["", "a", "ab", "abc", "short", "medium length text", "a" * 100, "a" * 1000]
    }

    def "hexToBytes should convert hex string to bytes"() {
        when:
        def bytes = AES256Utils.hexToBytes("48656c6c6f")

        then:
        bytes.length == 5
        new String(bytes, "UTF-8") == "Hello"
    }

    def "hexToBytes should throw exception for odd length hex"() {
        when:
        AES256Utils.hexToBytes("abc")

        then:
        thrown(IllegalArgumentException)
    }

    def "encrypt should use URL-safe base64 encoding"() {
        when:
        def encrypted = AES256Utils.encrypt("test", VALID_HEX_KEY)

        then:
        // URL-safe base64 doesn't contain '+' or '/' in the encoded data
        // It replaces '+' with '-' and '/' with '_'
        encrypted.contains('-') || encrypted.contains('_') || (!encrypted.contains('+') && !encrypted.contains('/'))
    }

    def "should handle special characters"() {
        given:
        def original = "Test \"quoted\" and \n new line \t tab"

        when:
        def encrypted = AES256Utils.encrypt(original, VALID_HEX_KEY)
        def decrypted = AES256Utils.decrypt(encrypted, VALID_HEX_KEY)

        then:
        decrypted == original
    }
}
