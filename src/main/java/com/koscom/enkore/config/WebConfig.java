package com.koscom.enkore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // [Cors-Orgin]
        // 참고: https://inpa.tistory.com/entry/AXIOS-%F0%9F%93%9A-CORS-%EC%BF%A0%ED%82%A4-%EC%A0%84%EC%86%A1withCredentials-%EC%98%B5%EC%85%98

        registry.addMapping("/**") // 프로그램에서 제공하는 URL
//                .allowedOrigins("http://localhost:8181") // 요청을 허용할 출처를 명시, 전체 허용 (가능하다면 보안을 위해 목록을 작성한다.)
//                .allowedHeaders("*") // 어떤 헤더들을 허용할 것인지
                .allowedOriginPatterns("*") // [참고] Spring-boot 2.4 이상부터 allowedOrigins() -> allowedOriginPatterns() 사용
                .allowedMethods("*") // 어떤 메서드를 허용할 것인지 (GET, POST...)
                .allowCredentials(true); // 쿠키 요청을 허용한다(다른 도메인 서버에 인증하는 경우에만 사용해야하며, true 설정시 보안상 이슈가 발생할 수 있다)
    }
}
