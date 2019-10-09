package com.capgemini.cn.core.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

@EnableSwagger2
@Configuration
public class ApiDocumentConfiguration {

    @Autowired
    private ApiConfigProperties properties;

    @Bean
    public Docket buildApiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build().pathMapping(this.properties.getPathMapping())
                .apiInfo(this.apiInfo())
                .directModelSubstitute(LocalDate.class, String.class)
                .useDefaultResponseMessages(false)
                .enableUrlTemplating(true)
                .enable(this.properties.isEnabled());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(this.properties.getTitle())
                .description(this.properties.getDescription())
                .contact(new Contact(this.properties.getContactName(), this.properties.getContactUrl(), this.properties.getContactEmail()))
                .license(this.properties.getLicense())
                .licenseUrl(this.properties.getLicenseUrl())
                .version(this.properties.getVersion())
                .build();
    }

}
