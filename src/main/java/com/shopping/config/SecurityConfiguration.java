package com.shopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * WebSecurityConfigurerAdapter 상속 방식이 Deprecated되어 대안 방식으로 Security 설정 진행
 * 이유 : component-based security configuration에 대해 사용자들의 전환을 격력하기 위함
 * 
 * @author ycjung
 * @see <a href="https://velog.io/@chiyongs/Spring-deprecated%EB%90%9C-WebSecurityConfigurerAdapter-%EC%9D%B4%EC%A0%A0-%EC%95%88%EB%85%95">chiyongs.log</a>
 * @see <a href="https://stackoverflow.com/questions/72381114/spring-security-upgrading-the-deprecated-websecurityconfigureradapter-in-spring">stack overflow</a>
 */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//
//    /* HttpSecurity 설정 */
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        
//        http
//        .authorizeHttpRequests((authz) -> authz
//                .anyRequest().authenticated()
//                )
//        .httpBasic();
//        
//        return http.build();
//    }
//    
//    /* WebSecurity 설정 */
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/images/**", "/cmmn/**");
//    }
//    
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//    
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
