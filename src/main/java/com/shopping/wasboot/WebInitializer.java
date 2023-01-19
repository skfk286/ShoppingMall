package com.shopping.wasboot;

import static com.shopping.constant.Default.LOG_KEY;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.shopping.filter.FWFilter;
import com.shopping.web.RootConfig;
import com.shopping.web.WebConfig;

/**
 * Web XML 설정파일
 * 
 * @since 2022.03.14
 * @author ycjung
 *
 */
public class WebInitializer implements WebApplicationInitializer{
    
    private final Logger logger = LogManager.getLogger(this.getClass());
    
    public void onStartup(ServletContext servletContext) throws ServletException {
        logger.debug("{} onStartup init ", LOG_KEY);
        registerDispatcherServlet(servletContext);
        registerCharacterEncodingFilter(servletContext);
        registerFWFilter(servletContext);
        
        logger.debug("{} onStartup end ", LOG_KEY);
    }
    
    private void registerDispatcherServlet(ServletContext servletContext) {
        logger.debug("{} ▶▶▶▶▶ registerDispatcherServlet ▶▶▶▶▶ ", LOG_KEY);
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebConfig.class);
        
        ServletRegistration.Dynamic dispatcher = 
                servletContext.addServlet("DispatcherServlet", new DispatcherServlet(webContext));
        
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        
        AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
        rootAppContext.register(RootConfig.class);
        
        ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
        servletContext.addListener(listener);
    }
    
    /**
     * 웹 요청과 응답에 대한 인코딩 처리
     * @param servletContext
     */
    private void registerCharacterEncodingFilter(ServletContext servletContext) {
        logger.debug("{} ▶▶▶▶▶ registerCharacterEncodingFilter ▶▶▶▶▶ ", LOG_KEY);
        FilterRegistration.Dynamic characterEncodingFilter = 
                servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
        characterEncodingFilter.addMappingForServletNames(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
    
    private void registerFWFilter(ServletContext servletContext) {
        //logger.debug("{} ▶▶▶▶▶ registerFWFilter ▶▶▶▶▶ ", LOG_KEY);
        //servletContext.addFilter("frameworkSessionFilter", new FWFilter()).addMappingForUrlPatterns(null, false, "/*");
    }
    
}
