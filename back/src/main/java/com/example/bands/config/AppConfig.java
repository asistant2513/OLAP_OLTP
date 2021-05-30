package com.example.bands.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean
    public FilterRegistrationBean hiddenHttpMethodFilter(){
        FilterRegistrationBean filter = new FilterRegistrationBean(new HiddenHttpMethodFilter());
        filter.setUrlPatterns(Arrays.asList("/*"));
        return filter;
    }
}
