package com.xiaoju.open.sdk.didies.utils;

import com.xiaoju.open.sdk.didies.core.exception.DataDecryptException;
import com.xiaoju.open.sdk.didies.core.exception.DataEncryptException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AES256Utils {

  private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

  /**
   * 加密方法
   *
   * @param data   待加密的数据
   * @param hexKey 十六进制密钥（256位）
   * @return 加密后的数据
   * @throws DataEncryptException 数据加密异常
   */
  public static String encrypt(String data, String hexKey) throws DataEncryptException {
    try {
      // 十六进制转字节数组
      byte[] keyBytes = hexToBytes(hexKey);

      // 验证密钥长度
      if (keyBytes.length != 32) {
        throw new IllegalArgumentException("Key must be 32 bytes (256 bits) long.");
      }

      // 初始化加密器
      SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
      Cipher cipher = Cipher.getInstance(ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);

      // 执行加密
      byte[] encrypted = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));

      // URL安全Base64编码
      return base64UrlEncode(encrypted);
    } catch (Exception e) {
      throw new DataEncryptException("Encryption failed", e);
    }
  }

  /**
   * 解密方法
   *
   * @param encryptedData 加密后的数据
   * @param hexKey        十六进制密钥（256位）
   * @return 解密后的数据
   * @throws DataDecryptException 数据解密异常
   */
  public static String decrypt(String encryptedData, String hexKey) throws DataDecryptException {
    try {
      // 十六进制转字节数组
      byte[] keyBytes = hexToBytes(hexKey);

      // 验证密钥长度
      if (keyBytes.length != 32) {
        throw new IllegalArgumentException("Key must be 32 bytes (256 bits) long.");
      }

      // Base64解码
      byte[] decoded = base64UrlDecode(encryptedData);

      // 初始化解密器
      SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
      Cipher cipher = Cipher.getInstance(ALGORITHM);
      cipher.init(Cipher.DECRYPT_MODE, secretKey);
      // 执行解密
      byte[] decrypted = cipher.doFinal(decoded);
      return new String(decrypted, StandardCharsets.UTF_8).trim();
    } catch (Exception e) {
      throw new DataDecryptException("Decryption failed", e);
    }
  }

  /**
   * 十六进制转字节数组
   *
   * @param hex 十六进制字符串
   * @return 字节数组
   */
  public static byte[] hexToBytes(String hex) {
    if (hex.length() % 2 != 0) {
      throw new IllegalArgumentException();
    }
    byte[] bytes = new byte[hex.length() / 2];
    for (int i = 0; i < hex.length(); i += 2) {
      bytes[i / 2] = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
    }
    return bytes;
  }

  /**
   * Base64URL编码
   *
   * @param data 待编码的数据
   * @return Base64URL编码后的字符串
   */
  private static String base64UrlEncode(byte[] data) {
    String base64 = Base64.getEncoder().encodeToString(data);
    return base64.replace('+', '-').replace('/', '_');
  }

  /**
   * Base64URL解码
   *
   * @param input Base64URL编码的字符串
   * @return 解码后的字节数组
   */
  private static byte[] base64UrlDecode(String input) {
    String replaced = input.replace('-', '+').replace('_', '/');
    // 补全缺失的 = 号（兼容 Java 8）
    int padding = (4 - (replaced.length() % 4)) % 4;
    StringBuilder sb = new StringBuilder(replaced);
    for (int i = 0; i < padding; i++) {
      sb.append('=');
    }
    return Base64.getDecoder().decode(sb.toString());
  }
}
