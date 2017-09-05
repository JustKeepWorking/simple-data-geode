package com.nduyhai.simpledatageode.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ConfigurationProperties(prefix = "app")
public class GemfireConfiguration {

    private Properties gemfire;

    public Properties getGemfire() {
        return gemfire;
    }

    public void setGemfire(Properties gemfire) {
        this.gemfire = gemfire;
    }
}
