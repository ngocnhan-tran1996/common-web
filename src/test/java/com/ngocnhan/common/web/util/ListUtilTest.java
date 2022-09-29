package com.ngocnhan.common.web.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ListUtilTest {

  @Test
  void testIsEmptyObject() {

    final Object[] emptyArray = {};
    final Object[] notEmptyArray = {"Value"};
    assertEquals(new ArrayList<>(), ListUtil.emptyIfNull((Object[]) null));
    assertEquals(new ArrayList<>(), ListUtil.emptyIfNull(emptyArray));
    assertEquals(Arrays.asList(notEmptyArray), ListUtil.emptyIfNull(notEmptyArray));
  }

}