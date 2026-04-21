package com.xiaoju.open.sdk.didies.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Lists
 *
 * @author didi
 */
public class Lists {

  /**
   * 构造器
   */
  public Lists() {
  }

  /**
   * 新建一个ArrayList
   *
   * @param <E> 泛型
   * @return 集合
   */
  public static <E> ArrayList<E> newArrayList() {
    return new ArrayList<>();
  }

  /**
   * 新建一个ArrayList
   *
   * @param <E>      泛型
   * @param elements 元素
   * @return 集合
   */
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


  /**
   * 合并两个数组
   * @param fields 元素
   * @param field 元素
   * @return 合并后的数据
   */
  public static Field[] concat(Field[] fields, Field field) {
    Field[] result = new Field[fields.length + 1];
    System.arraycopy(fields, 0, result, 0, fields.length);
    result[fields.length] = field;
    return result;
  }
}
