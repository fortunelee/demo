package com.jpa.demo.bean;

import com.jpa.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartLoading implements CommandLineRunner {

    Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public void run(String... args) throws Exception {

        LOG.info("start run loading");
    }
}
