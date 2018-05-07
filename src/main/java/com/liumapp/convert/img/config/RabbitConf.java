package com.liumapp.convert.img.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liumapp
 * @file RabbitConf.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 5/7/18
 */
@Configuration
public class RabbitConf {

    @Bean
    public Queue ImgConverterQueue () {
        return new Queue("img-converter-queue");
    }

}
