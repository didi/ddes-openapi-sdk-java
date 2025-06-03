package com.xiaoju.open.sdk.didies.utils;

import com.xiaoju.open.sdk.didies.core.enums.EncryptTypeEnum;

public class AesUtils {

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
