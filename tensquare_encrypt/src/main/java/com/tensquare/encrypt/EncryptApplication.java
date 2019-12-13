package com.tensquare.encrypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description： TODO
 * @Author: xiaoxinghua
 * @Date: Created in 2019/12/11 10:40
 * @Version: 0.0.1
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class EncryptApplication {
    public static void main(String[] args) {
        SpringApplication.run(EncryptApplication.class);
    }
}
