package com.shopping.filter;

import static com.shopping.constant.Default.LOG_KEY;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

public class FWFilter extends OncePerRequestFilter{

    private final Logger logger = LogManager.getLogger(this.getClass());
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        logger.debug("{} ▶▶▶▶▶▶▶▶▶▶▶▶▶  Filter requestURI : {} ▶▶▶▶▶▶▶▶▶▶▶▶▶", LOG_KEY, request.getRequestURI());
        
        filterChain.doFilter(request, response);
    }

}
