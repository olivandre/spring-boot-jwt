package com.javainuse.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JwtRequestTest {
    
    @Test
    public void testBuilderLombok() {
        JwtRequest jwtRequest = JwtRequest.builder()
                                          .username("username")
                                          .build();

        System.out.println(jwtRequest.toString());

        assertEquals("username", jwtRequest.getUsername(), "validação de usuário NOK");

    }

    @Test
    public void testParameterConstructor(){
        JwtRequest jwtRequest = new JwtRequest("username", "password");
        assertEquals("username", jwtRequest.getUsername(), "validação de usuário NOK");
    }
}
    