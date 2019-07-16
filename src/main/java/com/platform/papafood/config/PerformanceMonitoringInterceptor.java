package com.platform.papafood.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class PerformanceMonitoringInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (LOGGER.isDebugEnabled()) {
            request.setAttribute("startMs", System.currentTimeMillis());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) {
        if (LOGGER.isDebugEnabled()) {
            Optional<Long> startMs = Optional.ofNullable((Long) request.getAttribute("startMs"));
            if (startMs.isPresent()) {
                long durationMs = System.currentTimeMillis() - startMs.get();
                LOGGER.debug("{} \"{}\" took {} ms", request.getMethod(), request.getRequestURI(), durationMs);
            }
        }
    }
}
