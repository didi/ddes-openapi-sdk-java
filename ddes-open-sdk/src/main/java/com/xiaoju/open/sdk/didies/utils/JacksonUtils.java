package com.xiaoju.open.sdk.didies.utils;


import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * JacksonUtils
 *
 * @author didi
 */
public class JacksonUtils {

  /**
   * 单例
   */
  private static class ObjectMapperHandler {

    /**
     * objectMapper
     */
    private static final ObjectMapper MAPPER = objectMapper();

    /**
     * objectMapper
     */
    private static ObjectMapper objectMapper() {
      return new ObjectMapper()
          .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
          .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
          .setSerializationInclusion(Include.NON_NULL);
    }

    /**
     * objectMapper
     */
    private static final ObjectMapper MAPPER_WITH_NULL = objectMapperWithNull();

    /**
     * objectMapper
     */
    private static ObjectMapper objectMapperWithNull() {
      return new ObjectMapper()
          .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
          .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
  }

  /**
   * 获取objectMapper
   *
   * @return ObjectMapper
   */
  public static ObjectMapper getObjectMapper() {
    return ObjectMapperHandler.MAPPER;
  }


  /**
   * obj 转 json string；不包含 null 值
   * @param obj 对象
   * @return 序列化后的字符串
   */
  public static String toJson(Object obj) {
    try {
      return ObjectMapperHandler.MAPPER.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e.getMessage());
    }
  }


    /**
     * obj 到 json string 包含 null 值
     * @param obj 对象
     * @return 序列化后的字符串
     */
  public static String toJsonWithNull(Object obj) {
    try {
      return ObjectMapperHandler.MAPPER_WITH_NULL.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e.getMessage());
    }
  }


    /**
     * json 到 obj
     * @param json JSON字符串
     * @param cls class类
     * @return 对象
     * @param <T> 泛型
     */
  public static <T> T toObj(String json, Class<T> cls) {
    try {
      return ObjectMapperHandler.MAPPER.readValue(json, cls);
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * to list
   * @param json  JSON字符串
   * @param clazz class类
   * @return 泛型
   * @param <T> 泛型
   */
  public static <T> List<T> parseList(String json, Class<T> clazz) {
    TypeFactory typeFactory = ObjectMapperHandler.MAPPER.getTypeFactory();
    try {
      return ObjectMapperHandler.MAPPER.readValue(json,
          typeFactory.constructCollectionType(List.class, clazz));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * to set
   * @param json JSON字符串
   * @param clazz class
   * @return 对象
   * @param <T> 泛型
   */
  public static <T> Set<T> parseSet(String json, Class<T> clazz) {
    TypeFactory typeFactory = ObjectMapperHandler.MAPPER.getTypeFactory();
    try {
      return ObjectMapperHandler.MAPPER.readValue(json,
          typeFactory.constructCollectionType(Set.class, clazz));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * to map
   * @param json  JSON字符串
   * @param clazz class
   * @return 对象
   * @param <T> 泛型
   */
  public static <T> Map<String, T> parseMap(String json, Class<T> clazz) {
    TypeFactory typeFactory = ObjectMapperHandler.MAPPER.getTypeFactory();
    try {
      return ObjectMapperHandler.MAPPER.readValue(json,
          typeFactory.constructMapType(Map.class, String.class, clazz));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}