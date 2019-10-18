package com.javainuse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHelloWorldApplication {
    
    private static Logger logger = LogManager.getLogger(SpringBootHelloWorldApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloWorldApplication.class, args);

        logger.info("Start service {}", 1);
    }
    
}
