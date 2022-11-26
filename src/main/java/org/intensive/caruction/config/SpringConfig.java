package org.intensive.caruction.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("org.intensive.caruction")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {
    private final ApplicationContext context;

    public SpringConfig(ApplicationContext context) {
        this.context = context;
    }
}
