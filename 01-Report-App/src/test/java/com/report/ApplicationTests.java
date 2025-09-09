package com.report;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class ApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void helloEndpointShouldReturnMessage() {
        String body = restTemplate.getForObject("/pdf", String.class);
        assertThat(body).isEqualTo("Hello, Spring Boot Project is Running!");
    }
}