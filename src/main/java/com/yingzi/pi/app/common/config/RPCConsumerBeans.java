package com.yingzi.pi.app.common.config;

import com.taobao.hsf.app.spring.util.HSFSpringConsumerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: yingzi-app-pi
 * @description: 生成消费者
 * @author: BaoGuoQiang
 * @create: 2018-10-18 09:28
 **/
@Configuration
public class RPCConsumerBeans {
    @Autowired
    HSFConfig hsfConfig;

    @Bean(initMethod = "init", name = "jobMessageService")
    public HSFSpringConsumerBean jobMessageService() {
        HSFSpringConsumerBean hsfSpringConsumerBean = new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterfaceName("com.yingzi.center.pi.api.JobMessageService");
        hsfSpringConsumerBean.setGroup(hsfConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(hsfConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(hsfConfig.getTimeout());
        return hsfSpringConsumerBean;
    }

    @Bean(initMethod = "init", name = "monthGradeService")
    public HSFSpringConsumerBean monthGradeService() {
        HSFSpringConsumerBean hsfSpringConsumerBean = new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterfaceName("com.yingzi.center.pi.api.MonthGradeService");
        hsfSpringConsumerBean.setGroup(hsfConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(hsfConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(hsfConfig.getTimeout());
        return hsfSpringConsumerBean;
    }

    @Bean(initMethod = "init", name = "personInformationService")
    public HSFSpringConsumerBean personInformationService() {
        HSFSpringConsumerBean hsfSpringConsumerBean = new HSFSpringConsumerBean();
        hsfSpringConsumerBean.setInterfaceName("com.yingzi.center.pi.api.PersonInformationService");
        hsfSpringConsumerBean.setGroup(hsfConfig.getServiceGroup());
        hsfSpringConsumerBean.setVersion(hsfConfig.getVersion());
        hsfSpringConsumerBean.setClientTimeout(hsfConfig.getTimeout());
        return hsfSpringConsumerBean;
    }
}