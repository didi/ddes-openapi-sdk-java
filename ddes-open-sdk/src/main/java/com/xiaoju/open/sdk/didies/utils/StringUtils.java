package com.xiaoju.open.sdk.didies.utils;

import java.util.Collection;

/**
 * StringUtils
 *
 * @author didi
 */
public class StringUtils {

  /**
   * 拼接字符串
   *
   * @param list      字符串集合
   * @param separator 分隔符
   * @return 拼接后的字符串
   */
  public static String join(Collection<String> list, String separator) {
    if (list != null && !list.isEmpty() && isNotEmpty(separator)) {
      return String.join(separator, list);
    }
    return null;
  }

  /**
   * 判断字符串是否为空
   *
   * @param str 字符串
   * @return 是否为空
   */
  public static boolean isEmpty(String str) {
    return (str == null || "".equals(str));
  }

  /**
   * 判断字符串是否不为空
   *
   * @param str 字符串
   * @return !isEmpty(str)
   */
  public static boolean isNotEmpty(String str) {
    return !isEmpty(str);
  }

}