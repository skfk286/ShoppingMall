package com.shopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(true) // Swagger 에서 제공해주는 기본 응답 코드 (200, 401, 403, 404) 등의 노출 여부
                .apiInfo(apiInfo()) // Swagger API 문서에 대한 설명을 표기하는 메서드.
                .select() // 선택된 api 에 대한 빌더를 초기화한다.
                .apis(RequestHandlerSelectors.basePackage("com.shopping")) // Swagger API 문서로 만들기, API 메서드들이 작성되어 있는 패키지의 경로를 지정 
                .paths(PathSelectors.any()) // 특정 Path 를 지정하여 apis() 에 지정된 경로 중에서 원하는 경로의 api 만 문서화한다.
                .build(); // ApiSelectorBuilder 를 빌드한다. Docket 타입을 반환한다.
    }
    
    @Bean ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Around Hub Open API Test with Swagger")
                .description("설명 부분")
                .version("1.0")
                .build();
    }
}
