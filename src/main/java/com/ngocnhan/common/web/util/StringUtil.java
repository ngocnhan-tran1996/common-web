package com.ngocnhan.common.web.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringUtil {

  public static String getIfBlank(final String text, final String defaultText) {
    return isBlank(text) ? defaultText : text;
  }

  public static boolean isBlank(final String text) {

    return text == null || text.isBlank();
  }
}