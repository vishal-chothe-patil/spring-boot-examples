package com.killerexpertise.example.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        logger.info("Incoming request data -> URI: {}, Method: {}, IP: {}",
                request.getRequestURI(),
                request.getMethod(),
                request.getRemoteAddr());
        return true;  // continue processing the request
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        logger.info("Handler executed, preparing to render view");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        logger.info("Request completed");
        if (ex != null) {
            logger.error("Exception occurred: ", ex);
        }
    }
}
