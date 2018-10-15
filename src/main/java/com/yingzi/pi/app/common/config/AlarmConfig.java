package com.yingzi.pi.app.common.config;

import com.yingzi.lib.config.Config;
import com.yingzi.lib.config.Configurator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @program: yingzi-center-alarm
 * @description:
 * @author: jianding
 * @create: 2018-09-26 16:12
 **/

@Component
public class AlarmConfig {
    private static final String configDataId = "com.yingzi.center.alarm.config";

    private String serviceGroup;
    private String version;
    private Integer timeout;

    @PostConstruct
    public void init() throws IOException {
        //实例化配置器
        Configurator configurator = Configurator.getConfigurator();
        //读取
        Config config = configurator.readYaml(configDataId);
        config = config.getChild("yz").getChild("alarm").getChild("hsf");

        this.serviceGroup = config.getString("serviceGroup");
        this.version = config.getString("version");
        this.timeout = config.getInteger("timeout");
    }

    public static String getConfigDataId() {
        return configDataId;
    }

    public String getServiceGroup() {
        return serviceGroup;
    }

    public void setServiceGroup(String serviceGroup) {
        this.serviceGroup = serviceGroup;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
