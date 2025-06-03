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

public class JacksonUtils {

  private static class ObjectMapperHandler {
    private static final ObjectMapper MAPPER = objectMapper();

    private static ObjectMapper objectMapper() {
      return new ObjectMapper()
          .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
          .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
          .setSerializationInclusion(Include.NON_NULL);
    }

    private static final ObjectMapper MAPPER_WITH_NULL = objectMapperWithNull();

    private static ObjectMapper objectMapperWithNull() {
      return new ObjectMapper()
          .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
          .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
  }

  public static ObjectMapper getObjectMapper() {
    return ObjectMapperHandler.MAPPER;
  }

  public static String toJson(Object obj) {
    try {
      return ObjectMapperHandler.MAPPER.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public static String toJsonWithNull(Object obj) {
    try {
      return ObjectMapperHandler.MAPPER_WITH_NULL.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public static <T> T toObj(String json, Class<T> cls) {
    try {
      return ObjectMapperHandler.MAPPER.readValue(json, cls);
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public static <T> List<T> parseList(String json, Class<T> clazz) {
    TypeFactory typeFactory = ObjectMapperHandler.MAPPER.getTypeFactory();
    try {
      return ObjectMapperHandler.MAPPER.readValue(json,
          typeFactory.constructCollectionType(List.class, clazz));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public static <T> Set<T> parseSet(String json, Class<T> clazz) {
    TypeFactory typeFactory = ObjectMapperHandler.MAPPER.getTypeFactory();
    try {
      return ObjectMapperHandler.MAPPER.readValue(json,
          typeFactory.constructCollectionType(Set.class, clazz));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

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