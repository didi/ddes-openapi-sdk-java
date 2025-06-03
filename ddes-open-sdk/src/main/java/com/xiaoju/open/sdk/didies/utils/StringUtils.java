package com.xiaoju.open.sdk.didies.utils;

import java.util.Collection;

public class StringUtils {

  public static String join(Collection<String> list, String separator) {
    if (list != null && !list.isEmpty() && isNotEmpty(separator)) {
      return String.join(separator, list);
    }
    return null;
  }

  public static boolean isEmpty(Object str) {
    return (str == null || "".equals(str));
  }

  public static boolean isNotEmpty(Object str) {
    return !isEmpty(str);
  }

}