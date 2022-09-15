package com.ngocnhan.common.web.util;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ObjectUtil {

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

}