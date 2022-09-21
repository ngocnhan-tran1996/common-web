package com.ngocnhan.common.web.advice;

import com.ngocnhan.common.web.constant.AppProperty;
import com.ngocnhan.common.web.constant.AppProperty.AdviceProperty;
import com.ngocnhan.common.web.util.LoggingUtil;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.UUID;
import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

@RestControllerAdvice
@ConditionalOnProperty(name = AdviceProperty.REQUEST)
public class RequestAdviceChain
    extends CommonsRequestLoggingFilter
    implements RequestBodyAdvice {

  @Override
  protected boolean shouldLog(HttpServletRequest request) {
    return DispatcherType.REQUEST == request.getDispatcherType();
  }

  @Override
  protected void beforeRequest(HttpServletRequest request, String message) {
    ThreadContext.put(AppProperty.ID, UUID.randomUUID().toString());
    this.logBeforeRequest(request);
  }

  @Override
  protected void afterRequest(HttpServletRequest request, String message) {
    ThreadContext.clearAll();
  }

  protected void logBeforeRequest(HttpServletRequest request) {
    LoggingUtil.logRequest(request);
  }

  @Override
  public boolean supports(MethodParameter methodParameter, Type targetType,
      Class<? extends HttpMessageConverter<?>> converterType) {
    return true;
  }

  /**
   * The default implementation returns the InputMessage that was passed in.
   */
  @Override
  public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter,
      Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {

    return inputMessage;
  }

  /**
   * The default implementation returns the body that was passed in.
   */
  @Override
  public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
      Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {

    this.logAfterBodyRead(body);
    return this.handleAfterBodyRead(body);
  }

  /**
   * The default implementation returns the body that was passed in.
   */
  @Override
  @Nullable
  public Object handleEmptyBody(@Nullable Object body, HttpInputMessage inputMessage,
      MethodParameter parameter,
      Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {

    return body;
  }

  protected void logAfterBodyRead(Object body) {
    LoggingUtil.logBody(body, "REQUEST");
  }

  protected Object handleAfterBodyRead(Object body) {

    return body;
  }
}