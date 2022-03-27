package com.alphasense.rc.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getRcUrl() {
        return getWebConfig().rcUrl();
    }

    private static WebConfig getWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}
