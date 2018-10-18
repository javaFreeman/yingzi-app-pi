package com.yingzi.pi.app.common.config;

import com.yingzi.lib.config.Config;
import com.yingzi.lib.config.Configurator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @program: yingzi-app-pi
 * @description: 读取根目录下的yaml的HSF配置信息
 * @author: BaoGuoQiang
 * @create: 2018-10-18 09:19
 **/
@Component
public class HSFConfig {
    private static final String configDataId = "com.yingzi.app.pi.config";

    private String serviceGroup;
    private String version;
    private Integer timeout;

    @PostConstruct
    public void init() throws IOException {
        Configurator configurator = Configurator.getConfigurator();
        Config config = configurator.readYaml(configDataId);
        config = config.getChild("spring").getChild("hsf").getChild("pi");

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