package com.tensquare.article;

import com.tensquare.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @Description： TODO
 * @Author: xiaoxinghua
 * @Date: Created in 2019/12/10 17:01
 * @Version: 0.0.1
 **/
@SpringBootApplication
//Mapper扫描注解
@MapperScan("com.tensquare.article.dao")
@EnableEurekaClient
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
