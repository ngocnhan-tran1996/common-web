package com.ngocnhan.common.web.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.ngocnhan.common.web.constant.AppProperty.ExceptionProperty;
import com.ngocnhan.common.web.constant.Strings;
import org.junit.jupiter.api.Test;

class ObjectUtilTest {

  @Test
  void testGetIfNull() {

    assertEquals(Strings.EMPTY, ObjectUtil.getIfNull(null, Strings.EMPTY));
    assertEquals(Strings.EMPTY, ObjectUtil.getIfNull(Strings.EMPTY, null));
  }

  @Test
  void testToJsonString() {

    assertNull(ObjectUtil.toJsonString(null));
    assertEquals("\"\"", ObjectUtil.toJsonString(Strings.EMPTY));
    assertEquals("\"zz\"", ObjectUtil.toJsonString("zz"));
    assertEquals("\"{\\\"abc\\\":123}\"", ObjectUtil.toJsonString("{\"abc\":123}"));
    assertEquals("{\"code\":\"500\",\"message\":\"Unknown Exception\"}",
        ObjectUtil.toJsonString(ExceptionProperty.DEFAULT));
    assertNull(ObjectUtil.toJsonString(new MyObject()));
  }

  private static class MyObject {

  }
}