package com.oskworks.framework.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "application")
public class ApplicationConfiguration {

    private String version;

    private List<String> excludeUrls;

}
