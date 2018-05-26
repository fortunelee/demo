package com.jpa.demo.rest;


import com.jpa.demo.config.RabbitMqConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RabbitMqConfig sendeMsg;

    @Async
    @PostMapping("/setData/{value}")
    public String setData(@PathVariable String value){

        redisTemplate.opsForValue().set("hello",value);
        return "ok";
    }

    @GetMapping("/getData/{key}")
    public String getData(@PathVariable String key){

        return redisTemplate.opsForValue().get(key);
    }


    @GetMapping("/delData/{key}")
    public boolean delData(@PathVariable String key){

        return redisTemplate.opsForValue().getOperations().delete(key);
    }

    @PostMapping("/sendMsg/{msg}")
    public String sendMsg(@PathVariable String msg){

        sendeMsg.sendMsg(msg);
        return "ok";
    }

    @GetMapping("/getMsg")
    public String getMsg(){

        return sendeMsg.getMsg();
    }
}
