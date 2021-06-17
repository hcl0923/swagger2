package com.kuang.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @program: swagger-demo
 * @description:
 * @author: 作者
 * @create: 2021-04-25 20:38
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    //配置swagger的Docket的Docket的bean实例
    @Bean
    public Docket docket(Environment environment) {
        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");
        //获取项目环境判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(
                DocumentationType.SWAGGER_2
        ).apiInfo(apiInfo()).groupName("hcl")
                .enable(flag)//看不到页面
                .select()
                //配置要扫描接口的方式
//                basePackage:扫描指定包
                //any:扫描全部
                //none：不扫描
                //withClassAnnotation:扫描类上的注解，参数是一个注解反射对象
                //withMethodAnnotation:扫描方法上的注解，
                .apis(RequestHandlerSelectors.basePackage("com.kuang"))
//                .paths(PathSelectors.ant("/kuang/**"))
                .build();
    }

    public ApiInfo apiInfo() {
        Contact contact = new Contact("hcl", "http://hcl", "2236347582@qq.com");
        return new ApiInfo(
                "Api kuangsheng",
                "再小的翻页能源行",
                "1.0",
                "http://kuang",
                contact,
                "",
                "", new ArrayList<>()
        );
    }
}
