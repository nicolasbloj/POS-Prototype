package com.nab.posprototype.component.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.nab.posprototype.dto.converter.ProductConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nab.posprototype.component")
public class AppConfig {


  @Bean
  public ProductConverter productConverter() {
    return new ProductConverter();
  }

}
