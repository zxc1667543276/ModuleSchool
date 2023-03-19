package com.example.moduleschool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.example.moduleschool.mapper")
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

public class ModuleSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleSchoolApplication.class, args);
    }

}
