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
            config = new Configurator().readJson("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    final static String timeout = config.getString("timeout");

}