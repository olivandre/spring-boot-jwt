package com.javainuse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;

import com.javainuse.model.JwtRequest;
import com.javainuse.model.JwtResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBootHelloWorldApplication.class, 
                webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

    private static Logger logger = LogManager.getLogger(DemoApplicationTests.class);

    @LocalServerPort
	private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    //@Test
    public void contextLoads() {
    }

    @Test
    public void testToken() {
        final String token = this.getToken();
        logger.info("token: {}", token);
        assertNotEquals("", token);
    }

    @Test
    public void testHelloWorld() {
        final String token = this.getToken();
        logger.info("token: {}", token);
        assertNotEquals("", token);

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        ResponseEntity<String> response = restTemplate.exchange(
            this.createURLWithPort("/hello"), 
            HttpMethod.GET, 
            new HttpEntity<>(null, headers), 
            String.class
        );

        logger.info("response: {}", response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hello World", response.getBody());
    }

    public String getToken() {
        JwtRequest jwtRequest = JwtRequest.builder()
                                          .username("javainuse")
                                          .password("password")
                                          .build();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        logger.info("url: {}", this.createURLWithPort("/authenticate"));

        ResponseEntity<JwtResponse> response = restTemplate.exchange(
            this.createURLWithPort("/authenticate"), 
            HttpMethod.POST, 
            new HttpEntity<JwtRequest>(jwtRequest, headers), 
            JwtResponse.class
        );

        logger.info("response: {}", response);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        
        return response.getBody().getJwtToken();
    }

    private String createURLWithPort(final String uri) {
        return "http://localhost:" + port + uri;
	}

}