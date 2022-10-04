package com.ngocnhan.common.web.util;

import com.ngocnhan.common.web.constant.Strings;
import java.util.Objects;
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

  /**
   * <pre>
   * StringUtil.equals(null, null)   = true
   * StringUtil.equals(null, "abc")  = false
   * StringUtil.equals("abc", null)  = false
   * StringUtil.equals("abc", "abc") = true
   * StringUtil.equals("abc", "ABC") = false
   * </pre>
   *
   * @param text1 the first String, may be {@code null}
   * @param text2 the second String, may be {@code null}
   * @return {@code true} if the String are equal (case-sensitive), or both {@code null}
   */
  public static boolean equals(final String text1, final String text2) {

    return Objects.equals(text1, text2);
  }

  /**
   * <pre>
   * StringUtil.nonEqual(null, null)   = false
   * StringUtil.nonEqual(null, "abc")  = true
   * StringUtil.nonEqual("abc", null)  = true
   * StringUtil.nonEqual("abc", "abc") = false
   * StringUtil.nonEqual("abc", "ABC") = true
   * </pre>
   *
   * @param text1 the first String, may be {@code null}
   * @param text2 the second String, may be {@code null}
   * @return {@code true} if the String are equal (case-sensitive), or both {@code null}
   */
  public static boolean nonEqual(final String text1, final String text2) {

    return !Objects.equals(text1, text2);
  }

  /**
   * <pre>
   * StringUtil.emptyIfNull(null)  = ""
   * StringUtil.emptyIfNull("")    = ""
   * StringUtil.emptyIfNull("bat") = "bat"
   * </pre>
   *
   * @param text the String to check, may be null
   * @return the passed in String, or the {@link Strings#EMPTY} if it
   * was {@code null}
   * @see Objects#toString(Object, String)
   * @see String#valueOf(Object)
   */
  public static String emptyIfNull(final String text) {
    return Objects.toString(text, Strings.EMPTY);
  }

  /**
   * <pre>
   * StringUtil.containsNone(null, *)       = true
   * StringUtil.containsNone(*, null)       = true
   * StringUtil.containsNone("", *)         = true
   * StringUtil.containsNone("ab", '')      = true
   * StringUtil.containsNone("abab", 'xyz') = true
   * StringUtil.containsNone("ab1", 'xyz')  = true
   * StringUtil.containsNone("abz", 'xyz')  = false
   * </pre>
   *
   * @param text    the String to check, may be null
   * @param keyword the String to find, may be null
   * @return true if it contains none of the invalid chars, or is null
   */
  public static boolean containsNone(final String text, final String keyword) {

    return !contains(text, keyword);
  }

  /**
   * <pre>
   * StringUtil.contains(null, *)     = false
   * StringUtil.contains(*, null)     = false
   * StringUtil.contains("", "")      = true
   * StringUtil.contains("abc", "")   = true
   * StringUtil.contains("abc", "a")  = true
   * StringUtil.contains("abc", "z")  = false
   * </pre>
   *
   * @param text    the String to check, may be null
   * @param keyword the String to find, may be null
   * @return true if the CharSequence contains the search CharSequence,
   * false if not or {@code null} string input
   */
  public static boolean contains(final String text, final String keyword) {
    if (text == null || keyword == null) {
      return false;
    }

    return text.contains(keyword);
  }

  /**
   * <pre>
   * StringUtil.substring(null, *)   = null
   * StringUtil.substring("", *)     = ""
   * StringUtil.substring("abc", 0)  = "abc"
   * StringUtil.substring("abc", 2)  = "c"
   * StringUtil.substring("abc", 4)  = ""
   * StringUtil.substring("abc", -2) = "bc"
   * StringUtil.substring("abc", -4) = "abc"
   * </pre>
   *
   * @param text  the String to get the substring from, may be null
   * @param start the position to start from, negative means
   *              count back from the end of the String by this many characters
   * @return substring from start position, {@code null} if null String input
   */
  public static String substring(final String text, final int start) {
    if (text == null) {
      return null;
    }

    if (start > text.length()) {
      return Strings.EMPTY;
    }

    int position = 0;

    if (start < 0
        && text.length() + start > 0) {
      position = text.length() + start;
    }

    return text.substring(position);
  }

  /**
   * <pre>
   * StringUtil.substring(null, *, *)    = null
   * StringUtil.substring("", * ,  *)    = "";
   * StringUtil.substring("abc", 0, 2)   = "ab"
   * StringUtil.substring("abc", 2, 0)   = ""
   * StringUtil.substring("abc", 2, 4)   = "c"
   * StringUtil.substring("abc", 4, 6)   = ""
   * StringUtil.substring("abc", 2, 2)   = ""
   * StringUtil.substring("abc", -2, -1) = "b"
   * StringUtil.substring("abc", -4, 2)  = "ab"
   * </pre>
   *
   * @param text  the String to get the substring from, may be null
   * @param start the position to start from, negative means
   *              count back from the end of the String by this many characters
   * @param end   the position to end at (exclusive), negative means
   *              count back from the end of the String by this many characters
   * @return substring from start position to end position,
   * {@code null} if null String input
   */
  public static String substring(final String text, final int start, final int end) {
    if (text == null) {
      return null;
    }

    if (start > end) {
      return Strings.EMPTY;
    }

    int endPos = 0;

    if (end < 0
        && text.length() + end > 0) {
      endPos = text.length() + end;
    }

    if (end > text.length()) {
      endPos = text.length();
    }

    int startPos = 0;

    if (start < 0
        && text.length() + start > 0) {
      startPos = text.length() + start;
    }

    return text.substring(startPos, endPos);
  }

}