package com.capgemini.cn.erpmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = "com.capgemini.cn")
@ServletComponentScan("com.capgemini.cn")
public class BasicServiceApplication{

    public static void main(String[] args) {
        SpringApplication.run(BasicServiceApplication.class, args);
    }
}
