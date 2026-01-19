package com.xiaoju.open.sdk.didies.utils

import com.xiaoju.open.sdk.didies.core.enums.EncryptTypeEnum
import com.xiaoju.open.sdk.didies.core.exception.DataDecryptException
import com.xiaoju.open.sdk.didies.core.exception.DataEncryptException
import spock.lang.Specification
import spock.lang.Unroll

class AesUtilsTest extends Specification {

    // AES-128 requires a 16-byte key
    static final String AES128_KEY = "1234567890123456"
    // AES-256 requires a 64-character hex key (32 bytes)
    static final String AES256_KEY = "1234567890123456789012345678901234567890123456789012345678"

    @Unroll
    def "encrypt with #encryptType should encrypt text"() {
        when:
        def encrypted = AesUtils.encrypt(plaintext, key, encryptType)

        then:
        encrypted != null
        if (encryptType == EncryptTypeEnum.NORMAL) {
            // NORMAL type returns content as-is
            encrypted == plaintext
        } else {
            encrypted != plaintext
            !encrypted.contains(plaintext)
        }

        where:
        encryptType           | key           | plaintext
        EncryptTypeEnum.AES128  | AES128_KEY    | "Hello World"
        EncryptTypeEnum.AES128  | AES128_KEY    | "123456789"
        EncryptTypeEnum.NORMAL  | "any_key"     | "Hello World"
    }

    @Unroll
    def "decrypt with #encryptType should decrypt encrypted text"() {
        given:
        def original = "Hello World"
        def encrypted = AesUtils.encrypt(original, key, encryptType)

        when:
        def decrypted = AesUtils.decrypt(encrypted, key, encryptType)

        then:
        decrypted == original

        where:
        encryptType           | key
        EncryptTypeEnum.AES128  | AES128_KEY
    }

    def "encrypt and decrypt should be symmetric for AES128"() {
        given:
        def original = "Test message for encryption 123!@#"

        when:
        def encrypted = AesUtils.encrypt(original, AES128_KEY, EncryptTypeEnum.AES128)
        def decrypted = AesUtils.decrypt(encrypted, AES128_KEY, EncryptTypeEnum.AES128)

        then:
        decrypted == original
    }

    def "encrypt with NORMAL type should return original text"() {
        given:
        def original = "Hello World"

        when:
        def encrypted = AesUtils.encrypt(original, "any_key", EncryptTypeEnum.NORMAL)

        then:
        encrypted == original
    }

    def "decrypt with NORMAL type should throw exception for non-encrypted text"() {
        when:
        AesUtils.decrypt("Hello World", "any_key", EncryptTypeEnum.NORMAL)

        then:
        thrown(DataDecryptException)
    }

    def "decrypt with wrong key should throw exception"() {
        given:
        def original = "Secret Message"
        def encrypted = AesUtils.encrypt(original, AES128_KEY, EncryptTypeEnum.AES128)
        def wrongKey = "6543210987654321"

        when:
        AesUtils.decrypt(encrypted, wrongKey, EncryptTypeEnum.AES128)

        then:
        thrown(DataDecryptException)
    }

    def "encrypt should produce same ciphertext for same plaintext (ECB mode)"() {
        given:
        def original = "Same message"

        when:
        def encrypted1 = AesUtils.encrypt(original, AES128_KEY, EncryptTypeEnum.AES128)
        def encrypted2 = AesUtils.encrypt(original, AES128_KEY, EncryptTypeEnum.AES128)

        then:
        // ECB mode without IV produces same output for same input
        encrypted1 == encrypted2
    }

    def "decrypt should handle empty strings"() {
        given:
        def original = ""

        when:
        def encrypted = AesUtils.encrypt(original, AES128_KEY, EncryptTypeEnum.AES128)
        def decrypted = AesUtils.decrypt(encrypted, AES128_KEY, EncryptTypeEnum.AES128)

        then:
        decrypted == original
    }

    def "encrypt and decrypt should handle unicode characters"() {
        given:
        def original = "测试中文字符"

        when:
        def encrypted = AesUtils.encrypt(original, AES128_KEY, EncryptTypeEnum.AES128)
        def decrypted = AesUtils.decrypt(encrypted, AES128_KEY, EncryptTypeEnum.AES128)

        then:
        decrypted == original
    }

    def "should handle long text"() {
        given:
        def original = "a" * 10000

        when:
        def encrypted = AesUtils.encrypt(original, AES128_KEY, EncryptTypeEnum.AES128)
        def decrypted = AesUtils.decrypt(encrypted, AES128_KEY, EncryptTypeEnum.AES128)

        then:
        decrypted == original
    }

    def "encrypt should throw exception for null input"() {
        when:
        AesUtils.encrypt(null, AES128_KEY, EncryptTypeEnum.AES128)

        then:
        thrown(DataEncryptException)
    }

    def "decrypt should throw exception for null input"() {
        when:
        AesUtils.decrypt(null, AES128_KEY, EncryptTypeEnum.AES128)

        then:
        thrown(DataDecryptException)
    }

    def "AES256 requires correct hex key format"() {
        when:
        AesUtils.encrypt("test", AES256_KEY, EncryptTypeEnum.AES256)

        then:
        thrown(DataEncryptException)
    }

    def "AES128 decryption with wrong key should throw exception"() {
        given:
        def original = "Test"
        def encrypted = AesUtils.encrypt(original, AES128_KEY, EncryptTypeEnum.AES128)
        def wrongKey = "wrongkey1234567"

        when:
        AesUtils.decrypt(encrypted, wrongKey, EncryptTypeEnum.AES128)

        then:
        thrown(DataDecryptException)
    }

    def "decrypt with invalid base64 should throw exception"() {
        when:
        AesUtils.decrypt("invalid_base64!", AES128_KEY, EncryptTypeEnum.AES128)

        then:
        thrown(DataDecryptException)
    }

    def "encrypt and decrypt should be consistent across multiple operations"() {
        given:
        def original = "Test data"

        when:
        def encrypted1 = AesUtils.encrypt(original, AES128_KEY, EncryptTypeEnum.AES128)
        def decrypted1 = AesUtils.decrypt(encrypted1, AES128_KEY, EncryptTypeEnum.AES128)

        def encrypted2 = AesUtils.encrypt(decrypted1, AES128_KEY, EncryptTypeEnum.AES128)
        def decrypted2 = AesUtils.decrypt(encrypted2, AES128_KEY, EncryptTypeEnum.AES128)

        then:
        decrypted1 == original
        decrypted2 == original
    }

    @Unroll
    def "should handle different string lengths"() {
        expect:
        def encrypted = AesUtils.encrypt(text, AES128_KEY, EncryptTypeEnum.AES128)
        def decrypted = AesUtils.decrypt(encrypted, AES128_KEY, EncryptTypeEnum.AES128)
        decrypted == text

        where:
        text << ["", "a", "ab", "abc", "short", "medium length text", "a" * 100, "a" * 1000]
    }

    def "NORMAL type should not modify input during encryption"() {
        given:
        def original = "Original text"

        expect:
        AesUtils.encrypt(original, "any_key", EncryptTypeEnum.NORMAL) == original
    }
}
