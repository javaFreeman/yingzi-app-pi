package com.yingzi.pi.app.common.config;

import com.alibaba.boot.hsf.annotation.HSFConsumer;
import org.springframework.context.annotation.Configuration;
import com.yingzi.center.pi.api.*;

/**
 * @program: yingzi-app-pi
 * @description: HSF服务配置
 * @author: BaoGuoQiang
 * @create: 2018-10-07 15:32
 **/
@Configuration
public class HSFServiceConfig {

    @HSFConsumer(clientTimeout = 30000, serviceVersion = "${spring.hsf.pi.version:1.0.0}", serviceGroup = "${spring.hsf.pi.serviceGroup:HSF}")
    PersonInformationService personInformationService;

    @HSFConsumer(clientTimeout = 30000, serviceVersion = "${spring.hsf.pi.version:1.0.0}", serviceGroup = "${spring.hsf.pi.serviceGroup:HSF}")
    JobMessageService jobMessageService;
}