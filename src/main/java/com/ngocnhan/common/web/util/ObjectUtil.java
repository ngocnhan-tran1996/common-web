package com.ngocnhan.common.web.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

  /**
   * <pre>
   * ObjectUtil.toJsonString(null)                                 = null
   * ObjectUtil.getIfNull("")                                      = "\"\""
   * ObjectUtil.getIfNull("zz")                                    = "\"zz\""
   * ObjectUtil.getIfNull("{\"abc\":123}")                         = "\"{\\\"abc\\\":123}\""
   * ObjectUtil.getIfNull(new MyObject("123"))                     = "{\"name\":123}"
   * </pre>
   *
   * @param obj the {@link Object} to test, may be {@code null}
   * @return json string of {@code object} if {@code object} is valid, otherwise return null
   */
  public static String toJsonString(Object obj) {

    if (obj == null) {
      return null;
    }

    try {
      return objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      return null;
    }
  }

}