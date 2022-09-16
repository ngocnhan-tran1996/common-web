package com.ngocnhan.common.web.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionAttributeConstant {

  DEFAULT("500", "Unknown Exception", HttpStatus.INTERNAL_SERVER_ERROR.value());

  private final String code;
  private final String message;
  private final Integer statusCode;

}