package com.freightsol.freightsol.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by probal on 10/10/17.
 */
@Component
@ConfigurationProperties(prefix="app")
public class AppConfiguration {

    @Value("${appUrl}")
    private String appUrl;

    @Value("${jwtSecret}")
    private String jwtSecret;

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getJwtSecret() {
        return jwtSecret;
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }
}
