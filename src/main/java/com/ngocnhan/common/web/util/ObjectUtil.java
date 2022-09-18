package com.ngocnhan.common.web.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ObjectUtil {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static <T> T getIfNull(T object, T defaultObject) {
    return object == null
        ? defaultObject
        : object;
  }

  @SafeVarargs
  public static <T> T firstNonNull(final T... values) {

    return Stream.ofNullable(values)
        .flatMap(Arrays::stream)
        .filter(Objects::nonNull)
        .findFirst()
        .orElse(null);
  }

  public static String toString(Object obj) {

    if (obj == null) {
      return null;
    }

    try {
      if (obj instanceof String) {
        Map<String, Object> map = objectMapper.readValue((String) obj, new TypeReference<>() {
        });
        return objectMapper.writeValueAsString(map);
      }

      return objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      return Objects.toString(obj);
    }
  }
}