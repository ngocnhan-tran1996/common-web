package com.ngocnhan.common.web.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionAttribute {

  private String code;
  private String message;
  private Integer statusCode;

}