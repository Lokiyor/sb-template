package com.ljy.sbtemplate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ljy.sbtemplate.*"})
@MapperScan({"com.ljy.sbtemplate.**.mapper"})
public class SbTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbTemplateApplication.class, args);
    }

}

