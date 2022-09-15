package com.ngocnhan.common.web.exception;

import lombok.Getter;

@Getter
public class DefaultException extends RuntimeException {

  private final ExceptionAttribute exceptionAttribute;

  public DefaultException(String code, String message, Integer statusCode) {
    super(message);
    this.exceptionAttribute = new ExceptionAttribute(code, message, statusCode);
  }

}