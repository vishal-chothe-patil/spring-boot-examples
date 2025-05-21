package com.killerexpertise.example.filters;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SimpleFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(SimpleFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("SimpleFilter initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("Incoming request from IP: {}", request.getRemoteAddr());
        chain.doFilter(request, response); // Proceed to the next filter or servlet
    }

    @Override
    public void destroy() {
        logger.info("SimpleFilter destroyed.");
    }
}
