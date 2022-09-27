package com.ngocnhan.common.web.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ListUtil {

  @SafeVarargs
  public static <T> List<T> emptyIfNull(final T... array) {
    return isEmpty(array)
        ? new ArrayList<>()
        : Arrays.asList(array);
  }

  public static boolean isEmpty(final Object[] array) {
    return array == null || Array.getLength(array) == 0;
  }

}