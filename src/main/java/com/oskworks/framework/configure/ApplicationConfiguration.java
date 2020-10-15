package com.oskworks.framework.configure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@Configurable
@ConfigurationProperties(value = "application")
public class ApplicationConfiguration {

    protected String version;

    private List<String> excludeUrls;

}
