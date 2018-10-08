package com.yingzi.pi.app.common.config;

/**
 * @program: yingzi-app-pi
 * @description: swagger配置
 * @author: BaoGuoQiang
 * @create: 2018-10-07 16:04
 **/

import com.yingzi.pi.app.common.constant.ReturnCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * API接口测试：http://ip:port/swagger-ui.html
 * @author nullName
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private  static final String SWAGGER_APIOPEN = "close";

    @Value("${swagger.api.open}")
    private String swaggerApiIsopen;


    @Value("${swagger.api.version}")
    private String version;

    @Bean
    public Docket swagger2Api() {



        // 添加head参数start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();

        ApiSelectorBuilder apiSelectorBuilder = new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
                // .apis(RequestHandlerSelectors.basePackage("com.yingzi.center.bio.web.controller"))
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class));


        if(SWAGGER_APIOPEN.equalsIgnoreCase(swaggerApiIsopen)) {
            // 线上环境，添加路径过滤，设置为全部都不符合
            apiSelectorBuilder.paths(PathSelectors.none());
        }else {
            apiSelectorBuilder.paths(PathSelectors.any());
        }
        Docket docket = apiSelectorBuilder.build().globalOperationParameters(pars)
                //.globalResponseMessage(RequestMethod.GET, buildGlobalResponses())
                .globalResponseMessage(RequestMethod.POST, buildGlobalResponses())
                .globalResponseMessage(RequestMethod.PUT, buildGlobalResponses())
                .globalResponseMessage(RequestMethod.DELETE, buildGlobalResponses());

        return docket;
    }




    private List<ResponseMessage> buildGlobalResponses() {
        List<ResponseMessage> globalResponses = Arrays.asList(
                new ResponseMessageBuilder().code(200).message("OK").build(),
                new ResponseMessageBuilder().code(Integer.parseInt(ReturnCodeEnum.PARAM_MISSING.getCode())).message(ReturnCodeEnum.PARAM_MISSING.getMsg()).build(),
                new ResponseMessageBuilder().code(Integer.parseInt(ReturnCodeEnum.PARAM_ERROR.getCode())).message(ReturnCodeEnum.PARAM_ERROR.getMsg()).build(),
                new ResponseMessageBuilder().code(Integer.parseInt(ReturnCodeEnum.TOKEN_ERROR.getCode())).message(ReturnCodeEnum.TOKEN_ERROR.getMsg()).build(),
                new ResponseMessageBuilder().code(Integer.parseInt(ReturnCodeEnum.TOKEN_DISABLE.getCode())).message(ReturnCodeEnum.TOKEN_DISABLE.getMsg()).build(),
                new ResponseMessageBuilder().code(Integer.parseInt(ReturnCodeEnum.OTHOR_ERROR.getCode())).message(ReturnCodeEnum.OTHOR_ERROR.getMsg()).build());


        return globalResponses;

    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title("员工绩效系统--API说明文档")
                .description("开发测试版本API")
                .contact(new Contact("行政中心开发组", "", ""))
                .version(StringUtils.defaultString(this.version, "1.0.0"))
                .build();
    }
}