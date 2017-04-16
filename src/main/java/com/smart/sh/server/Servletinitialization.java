package com.smart.sh.server;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;


/**
 * Created by 孙雪键 on 2017/4/15.
 */
@SpringBootApplication
public class Servletinitialization implements EmbeddedServletContainerCustomizer{

    @Value("${application.port}")
    private int port;

    @Override
    public void customize(ConfigurableEmbeddedServletContainer config) {
        config.setPort(port);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Servletinitialization.class).run(args);
    }
}
