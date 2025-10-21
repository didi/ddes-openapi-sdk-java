package com.xiaoju.open.sdk.didies.utils;

import com.xiaoju.open.sdk.didies.core.enums.EncryptTypeEnum;

public class AesUtils {

  /**
   * 加密
   *
   * @param content     待加密内容
   * @param key         密钥
   * @param encryptType 加密类型
   * @return 加密后内容
   */
  public static String encrypt(String content, String key, EncryptTypeEnum encryptType) {
    switch (encryptType) {
      case AES256:
        return AES256Utils.encrypt(content, key);
      case AES128:
        return AES128Utils.encrypt(content, key);
      default:
        return content;
    }
  }

  /**
   * 解密
   *
   * @param content     待解密内容
   * @param key         密钥
   * @param encryptType 加密类型
   * @return 解密后内容
   */
  public static String decrypt(String content, String key, EncryptTypeEnum encryptType) {
    switch (encryptType) {
      case AES256:
        return AES256Utils.decrypt(content, key);
      case AES128:
      default:
        return AES128Utils.decrypt(content, key);
    }
  }

}
