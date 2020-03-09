package be.vdab.groenetenen.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;



@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Bean
    CookieLocaleResolver localeResolver(){
      CookieLocaleResolver resolver = new CookieLocaleResolver();
      resolver.setCookieMaxAge(604_800);
      return resolver;
  }
}
