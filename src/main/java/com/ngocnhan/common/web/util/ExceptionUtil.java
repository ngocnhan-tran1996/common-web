package com.ngocnhan.common.web.util;

import com.ngocnhan.common.web.constant.ExceptionAttributeConstant;
import com.ngocnhan.common.web.exception.ExceptionAttribute;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExceptionUtil {

  public static ExceptionAttribute createExceptionAttribute(
      final ExceptionAttributeConstant constant) {

    Objects.requireNonNull(constant, "Exception attribute must not be null");

    return new ExceptionAttribute(
        constant.getCode(),
        constant.getMessage(),
        constant.getStatusCode());
  }

}