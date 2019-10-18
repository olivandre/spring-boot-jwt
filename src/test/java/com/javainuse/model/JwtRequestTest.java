package com.javainuse.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class JwtRequestTest {

    private static Logger logger = LogManager.getLogger(JwtRequestTest.class);
    
    @Test
    public void testBuilderLombok() {
        JwtRequest jwtRequest = JwtRequest.builder()
                                          .username("username")
                                          .build();

        logger.info("jwtRequest: {}", jwtRequest.toString());

        assertEquals("username", jwtRequest.getUsername(), "validação de usuário NOK");

    }

    @Test
    public void testParameterConstructor(){
        JwtRequest jwtRequest = new JwtRequest("username", "password");
        logger.info("jwtRequest: {}", jwtRequest.toString());
        assertEquals("username", jwtRequest.getUsername(), "validação de usuário NOK");
    }
}
    