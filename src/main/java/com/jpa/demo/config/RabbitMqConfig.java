package com.jpa.demo.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

@Configuration
@Component
public class RabbitMqConfig {

    Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue createQueue(){

        return new Queue("hello");
    }

    public void sendMsg(String msg){

        rabbitTemplate.convertAndSend("hello",msg);
    }

/*    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void getMsg(String msg){

        LOG.info("************************:{}",msg);
    }*/

    public String getMsg(){

        Message message = rabbitTemplate.receive("hello");
        String msg = new String(message.getBody());
        LOG.info("************************:{}",msg);
        return msg;
    }
}
