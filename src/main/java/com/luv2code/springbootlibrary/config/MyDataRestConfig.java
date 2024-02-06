package com.luv2code.springbootlibrary.config;

import com.luv2code.springbootlibrary.entity.Book;
import com.luv2code.springbootlibrary.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * Created By dhhaval thakkar on 2024-01-26
 */
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration configuration,
                                                     CorsRegistry cors) {

        HttpMethod[] theUnsupportedActions = {
                HttpMethod.POST,
                HttpMethod.PATCH,
                HttpMethod.DELETE,
                HttpMethod.PUT
        };

        configuration.exposeIdsFor(Book.class);
        configuration.exposeIdsFor(Review.class);

        disableHttpMethods(Book.class, configuration, theUnsupportedActions);
        disableHttpMethods(Review.class, configuration, theUnsupportedActions);


        /* Configure CORS Mapping */
        String theAllowedOrigins = "http://localhost:3000";
        cors.addMapping(configuration.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigins)
                .allowedHeaders("*");
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration configuration,
                                    HttpMethod[] theUnsupportedActions) {

        configuration.getExposureConfiguration()
                .forDomainType(Book.class)
                .withItemExposure((metdata, httpMethods) ->
                        httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

    }
}
