package com.ngocnhan.common.web.advice;

import com.ngocnhan.common.web.constant.AppProperty.AdviceProperty;
import com.ngocnhan.common.web.util.LoggingUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
@ConditionalOnProperty(name = AdviceProperty.RESPONSE)
public class ResponseBodyAdviceChain implements ResponseBodyAdvice<Object> {

  @Override
  public boolean supports(MethodParameter returnType,
      Class<? extends HttpMessageConverter<?>> converterType) {
    return true;
  }

  @Override
  public Object beforeBodyWrite(Object body, MethodParameter returnType,
      MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
      ServerHttpRequest request, ServerHttpResponse response) {

    this.logBeforeBodyWrite(body);

    HttpServletRequest httpServletRequest = ((ServletServerHttpRequest) request).getServletRequest();
    HttpServletResponse httpServletResponse = ((ServletServerHttpResponse) response).getServletResponse();
    return this.handleBeforeBodyWrite(body, httpServletRequest, httpServletResponse);
  }

  protected void logBeforeBodyWrite(Object body) {
    LoggingUtil.logBody(body, "RESPONSE");
  }

  protected Object handleBeforeBodyWrite(
      Object body,
      HttpServletRequest request,
      HttpServletResponse response) {

    return body;
  }
}