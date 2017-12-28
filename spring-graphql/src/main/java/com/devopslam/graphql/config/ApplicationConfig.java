package com.devopslam.graphql.config;

;import com.devopslam.graphql.exceptions.CustomGraphQLErrorHandle;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new CustomGraphQLErrorHandle();
    }
}
