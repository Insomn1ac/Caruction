package org.intensive.caruction.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("caruction")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi(
            @Value("${APPLICATION_NAME:CARUCTION}") String appName,
            @Value("${APPLICATION_DESCRIPTION:caruction - аукцион трансопртных средств}") String appDescription,
            @Value("${APPLICATION_VERSION: 1.0}") String appVersion) {

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("ApiKeyAuth"))
                .components(new Components().addSecuritySchemes("ApiKeyAuth",
                        new SecurityScheme()
                                .name("Authorization")
                                .in(SecurityScheme.In.HEADER)
                                .type(SecurityScheme.Type.APIKEY)))
                .info(new Info().title(appName)
                        .version(appVersion)
                        .description(appDescription));
    }
}
