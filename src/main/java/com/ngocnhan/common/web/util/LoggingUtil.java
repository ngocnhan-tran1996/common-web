package com.ngocnhan.common.web.util;

import javax.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LoggingUtil {

  public static void logRequest(HttpServletRequest httpServletRequest) {

    var logRequest = new StringBuilder()
        .append("REQUEST ")
        .append("method=[").append(httpServletRequest.getMethod()).append("] ")
        .append("path=[").append(httpServletRequest.getRequestURI()).append("] ")
        .toString();

    log.info(logRequest);
  }

  public static void logBody(Object body, String message) {

    String requestBody = new StringBuilder()
        .append(message)
        .append(" BODY=")
        .append(ObjectUtil.toJsonString(body))
        .toString();

    log.info(requestBody);
  }
}