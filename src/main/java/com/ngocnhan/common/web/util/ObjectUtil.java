package com.ngocnhan.common.web.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ObjectUtil {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  /**
   * <pre>
   * ObjectUtil.getIfNull(null, null)      = null
   * ObjectUtil.getIfNull(null, "")        = ""
   * ObjectUtil.getIfNull(null, "zz")      = "zz"
   * ObjectUtil.getIfNull("abc", *)        = "abc"
   * ObjectUtil.getIfNull(Boolean.TRUE, *) = Boolean.TRUE
   * </pre>
   *
   * @param <T>           the type of the object
   * @param object        the {@link Object} to test, may be {@code null}
   * @param defaultObject the default value to return, may be {@code null}
   * @return {@code object} if it is not {@code null}, defaultObject otherwise
   */
  public static <T> T getIfNull(T object, T defaultObject) {
    return object == null
        ? defaultObject
        : object;
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