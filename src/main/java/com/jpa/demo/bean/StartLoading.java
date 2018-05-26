package com.jpa.demo.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartLoading implements CommandLineRunner {

    Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public void run(String... args) throws Exception {

        LOG.info("start run loading");
    }
}
