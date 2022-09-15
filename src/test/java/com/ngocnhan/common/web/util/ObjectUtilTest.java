package com.ngocnhan.common.web.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.ngocnhan.common.web.constant.Strings;
import org.junit.jupiter.api.Test;

class ObjectUtilTest {

  @Test
  void testGetIfNull() {

    assertEquals(Strings.EMPTY, ObjectUtil.getIfNull(null, Strings.EMPTY));
    assertEquals(Strings.EMPTY, ObjectUtil.getIfNull(Strings.EMPTY, null));
  }

  @Test
  void testFirstNonNull() {

    assertEquals(Strings.EMPTY, ObjectUtil.firstNonNull(null, Strings.EMPTY));
    assertEquals(Strings.EMPTY, ObjectUtil.firstNonNull(null, null, Strings.EMPTY, Strings.EMPTY));
    assertEquals(Strings.EMPTY, ObjectUtil.firstNonNull(Strings.EMPTY, null, Strings.EMPTY, null));

    assertNull(ObjectUtil.firstNonNull());
    assertNull(ObjectUtil.firstNonNull(null, null));
    assertNull(ObjectUtil.firstNonNull((Object) null));
    assertNull(ObjectUtil.firstNonNull((Object[]) null));
  }
}