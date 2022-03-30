package com.shopping.interceptor;

import static com.shopping.constant.Default.LOG_KEY;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * interceptor interface의 구현
 * 
 * @author ycjung
 */
public class CustomHandlerInterceptor implements HandlerInterceptor{
    
    private final static Logger logger = LogManager.getLogger(CustomHandlerInterceptor.class);
    
    /*
     * Controller로 보내기 전에 처리하는 인터셉터
     * 반환이 false라면 Controller로 요청을 안함.
     * 매개변수 Obejct는 핸들러 정보를 의미한다. (RequestMapping, DefaultServletHandler)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.debug("{} ======> interceptor preHandle() init ======> ", LOG_KEY);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
    
    // Controller의 Handler가 끝나면 처리됨.
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        logger.debug("{} ======> interceptor postHandle() init ======> ", LOG_KEY);
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
    
    // view까지 처리가 끝난 후에 처리됨.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.debug("{} ======> interceptor afterCompletion() init ======> ", LOG_KEY);
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
