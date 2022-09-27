package com.ngocnhan.common.web.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ngocnhan.common.web.constant.Strings;
import org.junit.jupiter.api.Test;

class ObjectUtilTest {

  @Test
  void testGetIfNull() {

    assertEquals(Strings.EMPTY, ObjectUtil.getIfNull(null, Strings.EMPTY));
    assertEquals(Strings.EMPTY, ObjectUtil.getIfNull(Strings.EMPTY, null));
  }

}