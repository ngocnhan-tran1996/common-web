package com.ngocnhan.common.web.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringUtil {

  /**
   * <pre>
   * StringUtil.getIfBlank(null, "NULL")  = "NULL"
   * StringUtil.getIfBlank("", "NULL")    = "NULL"
   * StringUtil.getIfBlank(" ", "NULL")   = "NULL"
   * StringUtil.getIfBlank("bat", "NULL") = "bat"
   * StringUtil.getIfBlank("", null)      = null
   * </pre>
   *
   * @param text        the String to check, may be null
   * @param defaultText the default String to return
   *                    if the input is whitespace, empty ("") or {@code null}, may be null
   * @return the passed in String, or the default
   */
  public static String getIfBlank(final String text, final String defaultText) {
    return isBlank(text) ? defaultText : text;
  }

  /**
   * <pre>
   * StringUtil.isBlank(null)      = true
   * StringUtil.isBlank("")        = true
   * StringUtil.isBlank(" ")       = true
   * StringUtil.isBlank("bob")     = false
   * StringUtil.isBlank("  bob  ") = false
   * </pre>
   *
   * @param text the String to check, may be null
   * @return {@code true} if the String is null, empty or whitespace only
   */
  public static boolean isBlank(final String text) {

    return text == null || text.isBlank();
  }

  /**
   * <pre>
   * StringUtil.isNotBlank(null)      = false
   * StringUtil.isNotBlank("")        = false
   * StringUtil.isNotBlank(" ")       = false
   * StringUtil.isNotBlank("bob")     = true
   * StringUtil.isNotBlank("  bob  ") = true
   * </pre>
   *
   * @param text the CharSequence to check, may be null
   * @return {@code true} if the CharSequence is
   * not empty and not null and not whitespace only
   */
  public static boolean isNotBlank(final String text) {

    return !isBlank(text);
  }
}