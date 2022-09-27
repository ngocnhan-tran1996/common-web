package com.ngocnhan.common.web.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppProperty {

  private static final String APP = "app.";
  public static final String ID = "ID";
  public static final String APP_EXCEPTION = APP + "exception";

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class AdviceProperty {

    private static final String ADVICE = "advice.";
    public static final String REQUEST = APP + ADVICE + "request";
    public static final String RESPONSE = APP + ADVICE + "response";
    public static final String EXCEPTION = APP + ADVICE + "exception";
  }
}