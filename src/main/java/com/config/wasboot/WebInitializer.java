package com.config.wasboot;

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

import com.config.web.RootConfig;
import com.config.web.WebConfig;

/**
 * Web XML 설정파일
 * 
 * @since 2022.03.14
 * @author ycjung
 *
 */
public class WebInitializer implements WebApplicationInitializer{
    
    private Logger logger = LogManager.getLogger(WebInitializer.class);
    
    public void onStartup(ServletContext servletContext) throws ServletException {
        logger.debug("{} onStartup init ", "test");
        registerDispatcherServlet(servletContext);
        registerCharacterEncodingFilter(servletContext);
    }
    
    private void registerDispatcherServlet(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebConfig.class);
        
        ServletRegistration.Dynamic dispatcher = 
                servletContext.addServlet("DispatcherServlet", new DispatcherServlet(webContext));
        
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
        
        AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
        rootAppContext.register(RootConfig.class);
        
        ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
        servletContext.addListener(listener);
    }
    
    private void  registerCharacterEncodingFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic characterEncodingFilter = 
                servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
        characterEncodingFilter.addMappingForServletNames(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}
