package com.ngocnhan.common.web.exception;

import com.ngocnhan.common.web.util.ObjectUtil;
import com.ngocnhan.common.web.util.StringUtil;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@EqualsAndHashCode
public class ExceptionAttribute implements Serializable {

  private static final long serialVersionUID = 1L;

  private String code;
  private String message;

  @Getter(AccessLevel.NONE)
  private Integer statusCode;

  public ExceptionAttribute(String code, String message, Integer statusCode) {
    this.code = code;
    this.message = message;
    this.statusCode = ObjectUtil.getIfNull(statusCode, HttpStatus.INTERNAL_SERVER_ERROR.value());
  }

  public void setMessageIfNotBlank(String message) {
    if (StringUtil.isBlank(message)) {
      return;
    }

    this.message = message;
  }

  public HttpStatus retrieveHttpStatus() {

    HttpStatus resolveStatusCode = HttpStatus.resolve(this.statusCode);
    return ObjectUtil.getIfNull(resolveStatusCode, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}