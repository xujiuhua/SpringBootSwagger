package com.johuer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2016-10-21-14:14
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(myApiInfo());

    }

    /**
     * api信息描述
     *
     * @return
     */
    private ApiInfo myApiInfo() {
        ApiInfo apiInfo = new ApiInfo("Springfox",                      //大标题
                "REST API",                                             //小标题
                "0.1",                                                  //版本
                "NO terms of service",
                new Contact("xujiuhua", "url", "xujiuhuamoney@163.com"),//作者
                "Johuer's Blog",                      //链接显示文字
                "http://johuer.coding.me"                               //网站链接
        );

        return apiInfo;
    }

}