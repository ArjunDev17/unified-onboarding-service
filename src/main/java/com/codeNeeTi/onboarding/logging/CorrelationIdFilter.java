package com.codeNeeTi.onboarding.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Pattern;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CorrelationIdFilter extends OncePerRequestFilter {

  public static final String CORRELATION_ID = "correlationId";
  private static final String HEADER_NAME = "X-Correlation-ID";

  private static final Pattern VALID_ID = Pattern.compile("^[a-zA-Z0-9._-]{1,64}$");

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String incomingId = request.getHeader(HEADER_NAME);

    String correlationId =
        incomingId != null && VALID_ID.matcher(incomingId).matches()
            ? incomingId
            : UUID.randomUUID().toString();

    try {
      MDC.put(CORRELATION_ID, correlationId);
      response.setHeader(HEADER_NAME, correlationId);

      filterChain.doFilter(request, response);
    } finally {
      MDC.remove(CORRELATION_ID);
    }
  }
}
