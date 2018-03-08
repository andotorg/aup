package org.andot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //让Spring来加载该类配置
@EnableSwagger2 //启用Swagger2
public class Swagger2 {
    @Bean
    public Docket alipayApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("农业灌溉系统文档-核心模块")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.andot.ais.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("农业灌溉系统")
                .description("水费计算、线上支付")
                .termsOfServiceUrl("http://andot.org")
                .contact(new Contact(" AUP ", "http://andot.org", "1481776135@qq.com"))
                .version("1.0").build();
    }
}
