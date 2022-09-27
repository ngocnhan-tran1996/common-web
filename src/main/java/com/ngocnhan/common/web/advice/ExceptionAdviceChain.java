package com.ngocnhan.common.web.advice;

import com.ngocnhan.common.web.constant.AppProperty;
import com.ngocnhan.common.web.constant.AppProperty.AdviceProperty;
import com.ngocnhan.common.web.exception.DefaultException;
import com.ngocnhan.common.web.exception.ExceptionAttribute;
import com.ngocnhan.common.web.exception.ExceptionAttribute.Type;
import com.ngocnhan.common.web.util.ExceptionUtil;
import lombok.Getter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Getter
@RestControllerAdvice
@ConditionalOnProperty(name = AdviceProperty.EXCEPTION)
@ConfigurationProperties(prefix = AppProperty.APP_EXCEPTION)
public class ExceptionAdviceChain {

  private final ExceptionAttribute defaultAttribute = ExceptionUtil.createExceptionAttribute(
      Type.DEFAULT);

  @ExceptionHandler(DefaultException.class)
  public ResponseEntity<ExceptionAttribute> handleDefaultException(
      DefaultException defaultException) {

    HttpStatus statusCode = defaultException.getExceptionAttribute()
        .retrieveHttpStatus();

    return ResponseEntity.status(statusCode)
        .body(defaultException.getExceptionAttribute());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionAttribute> handleUncaughtException(
      Exception exception) {

    defaultAttribute.setMessageIfNotBlank(exception.getMessage());

    return ResponseEntity.status(defaultAttribute.retrieveHttpStatus())
        .body(defaultAttribute);
  }
}