package com.xiaoju.open.sdk.didies.utils;

import com.xiaoju.open.sdk.didies.core.enums.SignMethodEnum;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUtils {

  public static String mapToSign(Map<String, String> map, SignMethodEnum signMethod) {

    List<Map.Entry<String, String>> entries = new ArrayList<>(map.entrySet());
    entries.sort(Map.Entry.comparingByKey());

    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, String> entry : entries) {
      if (sb.length() > 0) {
        sb.append("&");
      }
      sb.append(entry.getKey()).append("=").append(entry.getValue().trim());
    }
    if (SignMethodEnum.MD5.equals(signMethod)) {
      return md5(sb.toString());
    }
    return sha256Hex(sb.toString());
  }

  public static String mapParamsToSign(Map<String, Object> params, String signKey, SignMethodEnum signMethod) {
    Map<String, String> map = new HashMap<>();
    for (Map.Entry<String, Object> entry : params.entrySet()) {
      String k = entry.getKey();
      Object v = entry.getValue();
      if (StringUtils.isEmpty(k) || v == null) {
        continue;
      }
      if (v instanceof String) {
        map.put(k, (String) v);
        continue;
      }
      map.put(k, JacksonUtils.toJson(v));
    }
    map.put("sign_key", signKey);
    return mapToSign(map, signMethod);
  }

  //java md5算法
  public static String md5(String plainText) {
    byte[] secretBytes;
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(plainText.getBytes(StandardCharsets.UTF_8));
      secretBytes = md.digest();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("no such algorithm！");
    }


    StringBuilder md5code = new StringBuilder(new BigInteger(1, secretBytes).toString(16));
    int length = md5code.length();
    for (int i = 0; i < 32 - length; i++) {
      md5code.insert(0, "0");
    }
    return md5code.toString();
  }

  //java sha256算法
  public static String sha256Hex(String input) {
    try {
      // 创建一个MessageDigest实例，并指定使用SHA-256算法
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      // 将输入字符串转换为字节数组，并更新摘要
      byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

      // 将字节数组转换为十六进制字符串
      StringBuilder hexString = new StringBuilder();
      for (byte b : hash) {
        String hex = Integer.toHexString(0xff & b);
        if (hex.length() == 1) {
          hexString.append('0');
        }
        hexString.append(hex);
      }
      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

}