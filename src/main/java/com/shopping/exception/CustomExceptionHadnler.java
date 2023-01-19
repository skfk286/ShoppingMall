package com.shopping.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class CustomExceptionHadnler extends SimpleMappingExceptionResolver{

    private final Logger logger = LogManager.getLogger(this.getClass());
    
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        
        if(logger.isDebugEnabled()) {
            
        }
        
        
        
        return null;
    }
}
