/*
package com.killerexpertise.example.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthLoggingFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AuthLoggingFilter.class);
    private static final String EXPECTED_TOKEN = "Bearer secret-token"; // Hardcoded for simplicity

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("AuthLoggingFilter initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String authHeader = httpRequest.getHeader("Authorization");
        String path = httpRequest.getRequestURI();

        logger.info("Request to [{}] with Authorization header: {}", path, authHeader);

        if (authHeader == null || !authHeader.equals(EXPECTED_TOKEN)) {
            logger.warn("Unauthorized request to [{}] - Invalid or missing token", path);
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("Unauthorized - Invalid or missing token");
            return;
        }

        logger.info("Authorization successful for path: {}", path);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("AuthLoggingFilter destroyed.");
    }
}
*/
