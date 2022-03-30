package com.shopping.web;

import static com.shopping.constant.Default.LOG_KEY;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.interceptor.CustomHandlerInterceptor;

/**
 * dispatcher-Servlet XML 설정파일
 * 
 * @since 2022.03.14
 * @author ycjung
 *
 */
@Configuration
@EnableWebMvc /* Spring Mvc를 구성할 때 필요한 빈 설정들을 자동으로 해주는 어노테이션 */
@ComponentScan(basePackages = "com.shopping")
public class WebConfig implements WebMvcConfigurer, InitializingBean{
    
    private final static Logger logger = LogManager.getLogger(WebConfig.class);
    
    // 인터셉터 설정
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomHandlerInterceptor())
                .addPathPatterns("/mall/*")
                .excludePathPatterns("/test/**/") // test 쪽 예외 처리.
                .excludePathPatterns("users/login"); // 로그인 쪽 예외처리.
    }
    
    // 메세지 변환
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper()));
    }
    
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        return objectMapper;
    }
    
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
         
    }
    
    // 뷰 리졸버
    public void configureViewResolvers(ViewResolverRegistry registry) {
        logger.debug("{} configureViewResolvers init ", LOG_KEY);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        
        registry.viewResolver(viewResolver);
    }
    

    public void afterPropertiesSet() throws Exception {
        logger.info("{} afterPropertiesSet() - {}", LOG_KEY, this.getClass().getName());
    }
    
}
