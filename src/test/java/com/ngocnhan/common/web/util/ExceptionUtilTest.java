package com.ngocnhan.common.web.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ngocnhan.common.web.exception.ExceptionAttribute;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ExceptionUtilTest {

  @Test
  void testCreateExceptionAttribute() {

    ExceptionAttribute exceptionAttribute = new ExceptionAttribute(
        "500",
        "Unknown Exception",
        HttpStatus.INTERNAL_SERVER_ERROR.value());
    assertEquals(exceptionAttribute
        , ExceptionUtil.createExceptionAttribute(ExceptionAttribute.Type.DEFAULT));
    assertThrows(NullPointerException.class
        , () -> ExceptionUtil.createExceptionAttribute(null));
  }

}