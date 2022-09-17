package com.ngocnhan.common.web.advice;

import com.ngocnhan.common.web.constant.ExceptionAttributeConstant;
import com.ngocnhan.common.web.exception.DefaultException;
import com.ngocnhan.common.web.exception.ExceptionAttribute;
import com.ngocnhan.common.web.util.ExceptionUtil;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Getter
@RestControllerAdvice
@ConfigurationProperties(prefix = "app.exception")
public class ExceptionAdvice {

  private final ExceptionAttribute defaultAttribute = ExceptionUtil.createExceptionAttribute(
      ExceptionAttributeConstant.DEFAULT);

  @ExceptionHandler(DefaultException.class)
  public ResponseEntity<ExceptionAttribute> handleDefaultException(
      DefaultException defaultException) {

    HttpStatus statusCode = defaultException.getExceptionAttribute()
        .retrieveHttpStatus();

    return ResponseEntity.status(statusCode)
        .body(defaultException.getExceptionAttribute());
  }

}