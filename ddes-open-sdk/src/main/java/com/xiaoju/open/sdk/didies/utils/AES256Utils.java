package com.xiaoju.open.sdk.didies.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AES256Utils {

  private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

  public static String encrypt(String data, String hexKey) {
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
      throw new RuntimeException("Encryption failed", e);
    }
  }

  public static String decrypt(String encryptedData, String hexKey) {
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
      throw new RuntimeException("Decryption failed", e);
    }
  }

  // Java密钥处理（与PHP的hex2bin对应）
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

  // 编码：替换 +/ 为 -_，保留 =
  private static String base64UrlEncode(byte[] data) {
    String base64 = Base64.getEncoder().encodeToString(data);
    return base64.replace('+', '-').replace('/', '_');
  }

  // 解码：替换 -_ 为 +/，自动补全 =
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

  public static void main(String[] args) {
    // 测试用例
    String hexKey = "0495ad3bc8f9e8e9d425fde24af5ca03225465ef37e242c6243df32baf79f48e";
    String original = "ent=2&companyId=1125909874810584&company_id=1125909874810584&timestamp=1741774912437&offset=0&length=100";

    // 加密
    String encrypted = encrypt(original, hexKey);
    System.out.println("加密结果: " + encrypted); // 例如：JzETiB6sW8R3wKwN...

    // 解密
    String decrypted = decrypt(encrypted, hexKey);
    System.out.println("解密结果: " + decrypted); // 应与原始输入相同
  }
}
