package com.ngocnhan.common.web.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ngocnhan.common.web.util.ObjectUtil;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionAttribute implements Serializable {

  private static final long serialVersionUID = 1L;

  private String code;
  private String message;

  @JsonIgnore
  private Integer statusCode;

  public ExceptionAttribute(String code, String message, Integer statusCode) {
    this.code = code;
    this.message = message;
    this.statusCode = ObjectUtil.getIfNull(statusCode, HttpStatus.INTERNAL_SERVER_ERROR.value());
  }

  public HttpStatus retrieveHttpStatus() {

    HttpStatus resolveStatusCode = HttpStatus.resolve(this.statusCode);
    return ObjectUtil.getIfNull(resolveStatusCode, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}