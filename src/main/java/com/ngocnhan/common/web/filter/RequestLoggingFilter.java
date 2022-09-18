package com.ngocnhan.common.web.filter;

import com.ngocnhan.common.web.util.LoggingUtil;
import java.util.UUID;
import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Slf4j
@Component
public class RequestLoggingFilter
    extends CommonsRequestLoggingFilter {

  @Override
  protected boolean shouldLog(HttpServletRequest request) {
    return DispatcherType.REQUEST == request.getDispatcherType();
  }

  @Override
  protected void beforeRequest(HttpServletRequest request, String message) {
    ThreadContext.put("ID", UUID.randomUUID().toString());
    LoggingUtil.logRequest(request);
  }

  @Override
  protected void afterRequest(HttpServletRequest request, String message) {
    ThreadContext.clearAll();
  }
}