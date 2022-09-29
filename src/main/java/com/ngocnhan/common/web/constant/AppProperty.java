package com.ngocnhan.common.web.constant;

import com.ngocnhan.common.web.exception.ExceptionAttribute;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppProperty {

  private static final String APP = "app.";
  public static final String ID = "ID";
  public static final String APP_EXCEPTION = APP + "exception";

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static final class AdviceProperty {

    private static final String ADVICE = "advice.";
    public static final String REQUEST = APP + ADVICE + "request";
    public static final String RESPONSE = APP + ADVICE + "response";
    public static final String EXCEPTION = APP + ADVICE + "exception";
  }

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static final class ExceptionProperty {

    public static final ExceptionAttribute DEFAULT = new ExceptionAttribute(
        "500",
        "Unknown Exception",
        HttpStatus.INTERNAL_SERVER_ERROR.value());
  }

}