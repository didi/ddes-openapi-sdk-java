package com.xiaoju.open.sdk.didies.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

public class Lists {

  public Lists() {
  }

  public static <E> ArrayList<E> newArrayList() {
    return new ArrayList<>();
  }

  @SafeVarargs
  public static <E> ArrayList<E> newArrayList(E... elements) {
    if (elements != null && elements.length > 0) {
      int capacity = elements.length * 110 / 100 + 5;
      ArrayList<E> list = new ArrayList<>(capacity);
      Collections.addAll(list, elements);
      return list;
    }
    return newArrayList();
  }

  public static Field[] concat(Field[] fields, Field field) {
    Field[] result = new Field[fields.length + 1];
    System.arraycopy(fields, 0, result, 0, fields.length);
    result[fields.length] = field;
    return result;
  }
}
