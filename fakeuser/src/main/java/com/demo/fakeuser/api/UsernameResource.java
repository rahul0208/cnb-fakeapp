package com.demo.fakeuser.api;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/username")
public class UsernameResource {
    Logger logger = LoggerFactory.getLogger(UsernameResource.class);
    private Faker faker;

    @PostConstruct
    void postConstruct() {
        faker = new Faker();
    }

    @GetMapping
    public Map<String, String> generate() {
        String generatedName = faker.name().fullName();
        Map<String, String> response = new HashMap<>();
        response.put("name", generatedName);
        logger.info("Generated name is {}", generatedName);
        return response;
    }
}
