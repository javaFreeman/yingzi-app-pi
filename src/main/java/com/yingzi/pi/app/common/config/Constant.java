package com.yingzi.pi.app.common.config;

import com.yingzi.lib.config.Config;
import com.yingzi.lib.config.Configurator;

import java.io.IOException;

/**
 * @program: yingzi-app-pi
 * @description: ..
 * @author: BaoGuoQiang
 * @create: 2018-10-08 16:38
 **/

public class Constant {

    static Config config;
    static {
        try {
            Configurator configurator = new Configurator();
            config = configurator.readYaml("application");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String version = config.getChild("spring").getChild("hsf").getChild("pi").getString("version");
    String serviceGroup = config.getChild("spring").getChild("hsf").getChild("pi").getString("serviceGroup");
    //final static String timeout = config.getString("timeout");

}