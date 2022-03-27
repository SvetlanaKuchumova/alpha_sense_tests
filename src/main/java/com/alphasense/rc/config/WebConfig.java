package com.alphasense.rc.config;

import org.aeonbits.owner.Config;

@Config.Sources
        ({
                "classpath:${environment}.properties"
        })

public interface WebConfig extends Config {
    @Key("rc.url")
    String rcUrl();
}
