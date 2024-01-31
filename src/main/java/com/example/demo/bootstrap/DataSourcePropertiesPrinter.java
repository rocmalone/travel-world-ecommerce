package com.example.demo.bootstrap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSourcePropertiesPrinter implements CommandLineRunner {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Value("${spring.datasource.driver-class-name}")
    private String dataSourceDriverClassName;

    @Override
    public void run(String... args) {
        System.out.println("Datasource URL: " + dataSourceUrl);
        System.out.println("Datasource Username: " + dataSourceUsername);
        System.out.println("Datasource Password: " + dataSourcePassword);
        System.out.println("Datasource Driver Class Name: " + dataSourceDriverClassName);
    }
}
