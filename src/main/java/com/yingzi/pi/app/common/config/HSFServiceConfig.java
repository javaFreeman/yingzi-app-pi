package com.yingzi.pi.app.common.config;

import com.alibaba.boot.hsf.annotation.HSFConsumer;
import com.yingzi.lib.config.Config;
import com.yingzi.lib.config.Configurator;
import org.springframework.context.annotation.Configuration;
import com.yingzi.center.pi.api.*;

import java.io.IOException;

/**
 * @program: yingzi-app-pi
 * @description: HSF服务配置
 * @author: BaoGuoQiang
 * @create: 2018-10-07 15:32
 **/
@Configuration
public class HSFServiceConfig {


     //配置组件使用示例
    static {
        //实例化配置组件
        Configurator configurator = new Configurator();
        try {
            //watchJson可以实时监测配置文件的变动
            //Config config = configurator.watchJson("com.yingzi.center.pi.datasource");
            //readYaml读取application.yml文件
            Config config = configurator.readYaml("application");
            String version = config.getChild("spring").getChild("hsf").getChild("pi").getString("version");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @HSFConsumer(clientTimeout = 30000, serviceVersion = "${spring.hsf.pi.version:1.0.0}", serviceGroup = "${spring.hsf.pi.serviceGroup:HSF}")
    PersonInformationService personInformationService;

    @HSFConsumer(clientTimeout = 30000, serviceVersion = "${spring.hsf.pi.version:1.0.0}", serviceGroup = "${spring.hsf.pi.serviceGroup:HSF}")
    JobMessageService jobMessageService;

    @HSFConsumer(clientTimeout = 30000, serviceVersion = "${spring.hsf.pi.version:1.0.0}", serviceGroup = "${spring.hsf.pi.serviceGroup:HSF}")
    MonthGradeService monthGradeService;
}