package com.oskworks;

import com.oskworks.framework.configure.ApplicationConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationConfiguration.class})
@MapperScan("com.oskworks.modules.*.mapper")
public class OskApplication {

    public static void main(String[] args) {
        SpringApplication.run(OskApplication.class, args);
    }

}
