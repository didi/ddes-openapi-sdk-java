package com.xiaoju.open.sdk.didies.utils;

import com.xiaoju.open.sdk.didies.core.exception.DataDecryptException;
import com.xiaoju.open.sdk.didies.core.exception.DataEncryptException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AES128Utils {
  private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

  /**
   * AES加密
   *
   * @param input 明文
   * @param key   密钥
   * @return 密文
   * @throws DataEncryptException 数据加密异常
   */
  public static String encrypt(String input, String key) throws DataEncryptException {
    try {
      SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
      Cipher cipher = Cipher.getInstance(ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      byte[] encrypted = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
      return Base64.getEncoder().encodeToString(encrypted);
    } catch (Exception e) {
      throw new DataEncryptException("数据加密失败！", e);
    }

  }

  /**
   * AES解密
   *
   * @param cipher 密文
   * @param key    密钥
   * @return 明文
   * @throws DataDecryptException 数据解密异常
   */
  public static String decrypt(String cipher, String key) throws DataDecryptException {
    try {
      SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
      Cipher decipher = Cipher.getInstance(ALGORITHM);
      decipher.init(Cipher.DECRYPT_MODE, secretKey);
      byte[] decrypted = decipher.doFinal(Base64.getDecoder().decode(cipher));
      return new String(decrypted, StandardCharsets.UTF_8).trim();
    } catch (Exception e) {
      throw new DataDecryptException("aes解密异常", e);
    }
  }
}
