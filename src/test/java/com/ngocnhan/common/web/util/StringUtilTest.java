package com.ngocnhan.common.web.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ngocnhan.common.web.constant.Strings;
import org.junit.jupiter.api.Test;

class StringUtilTest {

  private static final String NULL_VALUE = "null";
  private static final String TEXT = "text";

  @Test
  void testGetIfBlank() {

    assertEquals(NULL_VALUE, StringUtil.getIfBlank(null, NULL_VALUE));
    assertEquals(NULL_VALUE, StringUtil.getIfBlank(Strings.EMPTY, NULL_VALUE));
    assertEquals(NULL_VALUE, StringUtil.getIfBlank(Strings.SPACE, NULL_VALUE));
    assertEquals(TEXT, StringUtil.getIfBlank(TEXT, NULL_VALUE));
    assertNull(StringUtil.getIfBlank(Strings.SPACE, null));
  }

  @Test
  void testIsNotBlank() {

    assertFalse(StringUtil.isNotBlank(null));
    assertFalse(StringUtil.isNotBlank(Strings.EMPTY));
    assertFalse(StringUtil.isNotBlank(Strings.SPACE));
    assertTrue(StringUtil.isNotBlank(TEXT));
  }

}